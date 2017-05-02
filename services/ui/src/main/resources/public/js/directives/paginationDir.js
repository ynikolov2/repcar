angular.module('app').directive('pagination',
    ['GeneralService', '$q', function (GeneralService, $q) {
        return {
            restrict: 'E',
            scope: {
                paginate: '&',
                paginationOptions: '=',
                navigationButtons: '='
            },
            templateUrl: '/view/templates/paginationTempl.html',
            link: function ($scope, elements, attrs) {

                $scope.currentPage = 1;
                $scope.limitOptions = [5, 10, 15, 20];
                $scope.firstWatchingElement = 1;
                $scope.lastWatchingElement = 1;
                $scope.pages = [];

                $scope.$watch('paginationOptions', function () {
                    if (angular.isDefined($scope.paginationOptions)) {
                       // $scope.lastWatchingElement = $scope.paginationOptions.totalElements;
                        $scope.populatePagesArray($scope.paginationOptions.pages);
                        if($scope.paginationOptions.resetPagination){
                            $scope.currentPage = 1;
                            $scope.calculateElements();


                        }

                    }

                }, true);

                $scope.$watch('navigationButtons', function () {
                    if (angular.isDefined($scope.navigationButtons)) {
                            $scope.organizeButtons($scope.navigationButtons);
                    }

                }, true);

                $scope.onPaginationChange = function (selectedPage) {
                    if($scope.paginationOptions.resetPagination && $scope.currentPage == 1){
                        $scope.paginationOptions.resetPagination = false;
                        return;
                    }

                    $scope.paginationOptions.currentPage = selectedPage - 1;

                    $scope.paginateObjects($scope.paginationOptions, '', false).then(function (response) {

                        var pagedObjects = response.pagedObjects;
                        $scope.paginationOptions = response.paginateOptions;
                        $scope.calculateElements();

                        //return paginated objects and page options to the parent controller
                        $scope.paginate({options: $scope.paginationOptions, pagedObject: pagedObjects});
                    });

                };

                $scope.toggleLimitOptions = function (limit) {

                    $scope.paginationOptions.currentPage = $scope.currentPage - 1;
                    $scope.paginationOptions.limit = limit;

                    //check if the new page size exceed total elements

                    while (($scope.paginationOptions.currentPage * $scope.paginationOptions.limit) > $scope.paginationOptions.totalElements) {
                        $scope.paginationOptions.currentPage--;
                        $scope.currentPage--;
                    }


                    $scope.paginateObjects($scope.paginationOptions, '', false).then(function (response) {

                        var pagedObjects = response.pagedObjects;
                        $scope.paginationOptions = response.paginateOptions;
                        $scope.calculateElements();

                        //return paginated objects and page options to the parent controller
                        $scope.paginate({options: $scope.paginationOptions, pagedObject: pagedObjects});
                    });

                };

                $scope.populatePagesArray = function (size) {
                    $scope.pages = [];
                    for (var i = 0; i < size; i++) {
                        $scope.pages.push(i + 1);
                    }
                };

                $scope.organizeButtons = function (links) {
                    if(angular.isDefined(links)){

                        var hasFirst = false;
                        var hasPrev = false;
                        var hasNext = false;
                        var hasLast = false;

                        for(var i=0; i<links.length; i++){
                            if(links[i].rel === 'first'){
                                $scope.navigationButtons.first = links[i].href;
                                hasFirst = true;
                            }else if(links[i].rel === 'prev'){
                                $scope.navigationButtons.prev = links[i].href;
                                hasPrev = true;
                            }
                            else if(links[i].rel === 'next'){
                                $scope.navigationButtons.next = links[i].href;
                                hasNext = true;
                            }
                            else if(links[i].rel === 'last'){
                                $scope.navigationButtons.last = links[i].href;
                                hasLast = true;
                            }
                        }
                        //check if some link is undefined and assign empty string to reset it.
                        if(!hasFirst){
                            $scope.navigationButtons.first = '';
                        }else if(!hasPrev){
                            $scope.navigationButtons.prev = '';
                        }
                        else if(!hasNext){
                            $scope.navigationButtons.next = '';
                        }
                        else if(!hasLast){
                            $scope.navigationButtons.last = '';
                        }
                    }
                };

                $scope.calculateElements = function () {

                    if ($scope.paginationOptions.totalElements === 0) {
                        $scope.firstWatchingElement = 0;
                        $scope.lastWatchingElement = 0;
                    } else {
                        if ($scope.currentPage == 1) {
                            $scope.firstWatchingElement = 1;
                            if (($scope.currentPage * $scope.paginationOptions.pageSize) > $scope.paginationOptions.totalElements) {
                                $scope.lastWatchingElement = $scope.paginationOptions.totalElements;
                            } else {
                                $scope.lastWatchingElement = $scope.currentPage * $scope.paginationOptions.pageSize;
                            }
                        } else {
                            $scope.firstWatchingElement = (($scope.currentPage * $scope.paginationOptions.pageSize) - $scope.paginationOptions.pageSize) + 1;
                            if (($scope.currentPage * $scope.paginationOptions.pageSize) > $scope.paginationOptions.totalElements) {
                                $scope.lastWatchingElement = $scope.paginationOptions.totalElements;
                            } else {
                                $scope.lastWatchingElement = $scope.currentPage * $scope.paginationOptions.pageSize;
                            }
                        }

                    }

                };

                $scope.paginateObjects = function (paginateOptions, directUrl, fromNavigation) {
                    var deferred = $q.defer();
                    var url = "";

                    if(fromNavigation){
                        url = directUrl;
                        paginateOptions = $scope.paginationOptions;
                    }else{
                        url = paginateOptions.url + paginateOptions.currentPage + '&size=' + paginateOptions.pageSize + '&sort=' + paginateOptions.orderBy + ',' + paginateOptions.orderDirection;
                    }

                    GeneralService.get(url).then(function (response) {

                        var pagedObjects = response.content;

                        paginateOptions.pageSize = response.page.size;
                        paginateOptions.pages = response.page.totalPages;
                        paginateOptions.totalElements = response.page.totalElements;
                        $scope.organizeButtons(response.links);

                        var pagedAndOptions = {
                            pagedObjects: pagedObjects,
                            paginateOptions: paginateOptions
                        };

                        deferred.resolve(pagedAndOptions);
                    });

                    return deferred.promise;
                };

                $scope.navigateTo = function (direction, url) {
                    $scope.paginateObjects('', url, true).then(function (response) {

                        var pagedObjects = response.pagedObjects;
                        $scope.paginationOptions = response.paginateOptions;
                        if(direction === 'first'){
                            $scope.paginationOptions.currentPage = 0;
                        }else if(direction === 'prev'){
                            $scope.paginationOptions.currentPage--;
                        }
                        else if(direction === 'next'){
                            $scope.paginationOptions.currentPage++;
                        }
                        else if(direction === 'last'){
                            $scope.paginationOptions.currentPage = $scope.paginationOptions.pages - 1;
                        }
                        $scope.currentPage = $scope.paginationOptions.currentPage + 1;
                        $scope.calculateElements();

                        //return paginated objects and page options to the parent controller
                        $scope.paginate({options: $scope.paginationOptions, pagedObject: pagedObjects});
                    });
                };

            }
        };
    }]);
