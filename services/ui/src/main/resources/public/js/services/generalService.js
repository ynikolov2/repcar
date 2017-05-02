/*
 * Copyright RepCar AD 2017
 */
angular.module('app').factory('GeneralService', ['$rootScope', '$resource', '$log', '$q', '$http', function ($rootScope, $resource, $log, $q, $http) {
    var GeneralService = {
        save: function (object, url) {
            $rootScope.showLoadingGif = true;
            var deferred = $q.defer();
            $resource(url).save(object, function (response) {
                $log.info('Item saved');
                $rootScope.showLoadingGif = false;
                deferred.resolve(response);
            }, function (errorMsg) {
                $log.error('Error creating item: ' + errorMsg.data.message);
                $rootScope.showLoadingGif = false;
                deferred.reject(errorMsg.data.message);
            });
            return deferred.promise;
        },
        list: function (url) {
            $rootScope.showLoadingGif = true;
            var deferred = $q.defer();
            $resource(url).query(function (response) {
                $log.info('Items Received');
                deferred.resolve(response);
                $rootScope.showLoadingGif = false;
            }, function (errorMsg) {
                $log.error('Error fetching items: ' + errorMsg.data.message);
                $rootScope.showLoadingGif = false;
                deferred.reject(errorMsg.data.message);
            });
            return deferred.promise;
        },
        get: function (url) {
            $rootScope.showLoadingGif = true;
            var deferred = $q.defer();
            $resource(url).get(function (response) {
                $log.info('Item Received');
                $rootScope.showLoadingGif = false;
                deferred.resolve(response);
            }, function (errorMsg) {
                $log.error('Error fetching item: ' + errorMsg.data.message);
                $rootScope.showLoadingGif = false;
                deferred.reject(errorMsg.data.message);
            });
            return deferred.promise;
        },
        delete: function (url) {
            $rootScope.showLoadingGif = true;
            var deferred = $q.defer();
            $resource(url).delete(function (response) {
                $log.info('Item Deleted');
                $rootScope.showLoadingGif = false;
                deferred.resolve(response);
            }, function (errorMsg) {
                $log.error('Error Deleting item: ' + errorMsg.data.message);
                $rootScope.showLoadingGif = false;
                deferred.reject(errorMsg.data.message);
            });
            return deferred.promise;
        },
        update : function(data, url) {
            $rootScope.showLoadingGif = true;
			var deferred = $q.defer();
			$http.put(url, data, null).success(
					function(data, status, headers, config) {
                        $rootScope.showLoadingGif = false;
						deferred.resolve(data);
					}).error(
					function(data, status, header, config) {
                        $rootScope.showLoadingGif = false;
						deferred.reject(data.message);
					});
			return deferred.promise;
        },
        getDeferred: function () {
            var deferred = $q.defer();
            return deferred;
        }
    };
    return GeneralService;
}]);
