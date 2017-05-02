/*
 * Copyright RepCar AD 2017
 */
angular.module('app').factory('OrderService', ['$resource', '$log', '$q', 'GeneralService', function ($resource, $log, $q, GeneralService) {
    var OrderService = {
        order: function (url, columnName, orderBy) {

            var deferred = $q.defer();
            var direction = checkOrderDirection(columnName);
            if(direction === ''){
                deferred.resolve('');
                return deferred.promise;
            }else{
                url = url + '&sort=' + orderBy + ',' + direction;

                GeneralService.get(url).then(function (response) {

                    var paginationOptions = {
                        pageSize: response.page.size,
                        pages: response.page.totalPages,
                        totalElements: response.page.totalElements,
                        orderDirection: direction,
                        orderBy : orderBy
                    };

                    var orderedObject = {
                        orderedObjects : response.content,
                        orderedOptions : paginationOptions,
                        links : response.links
                    };

                    deferred.resolve(orderedObject);
                });
                return deferred.promise;
            }
        },
        getDirection: function (columnName) {
            return checkOrderDirection(columnName);
        }
    };

    var checkOrderDirection = function (columnName) {
        var columnasc = angular.element(document.querySelector('#' + columnName + '.md-active .md-asc'));
        var columndesc = angular.element(document.querySelector('#' + columnName + '.md-active .md-desc'));

        if (columnasc.length > 0) {
            return 'desc';
        } else if (columndesc.length > 0) {
            return 'asc';
        } else {
            //return asc as default value
            return '';
        }
    };
    return OrderService;
}]);
