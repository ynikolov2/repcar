/*
 * Copyright RepCar AD 2017
 */
angular.module('app').factory('UserService', ['$rootScope', '$sessionStorage', 'GeneralService', '$q', function ($rootScope, $sessionStorage, GeneralService, $q) {
    var UserService = {
            loadUser : function() {
                var deferred = $q.defer();
                var username = null;
                GeneralService.get('security/user').then(function(response) {
                    username = response.name;
                });

                GeneralService.get('user/users/logged').then(function(response) {
                    var user = response;
                    if (user) {
                        sessionStorage.setItem("sessionUser", JSON.stringify(user)) ;
                        deferred.resolve(user);
                    }
                });
                return deferred.promise
            },
        isLoggedIn: function () {
            if (angular.isDefined(sessionStorage.sessionUser)) {
                if (sessionStorage.sessionUser) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        },
        isSuperAdmin: function () {
            if (angular.isDefined(sessionStorage.sessionUser)) {
                if (sessionStorage.sessionUser.userRole === 'ROLE_SUPER_ADMIN') {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        },
        isOrgAdmin: function () {
            if (angular.isDefined(sessionStorage.sessionUser)) {
                if (sessionStorage.sessionUser.userRole === 'ROLE_ORG_ADMIN') {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        },
        getUserOrganizationId: function () {
            if (angular.isDefined(sessionStorage.sessionUser)) {
                return sessionStorage.sessionUser.orgId;

            } else {
                return '';
            }
        },
        getUserDetails: function (user) {
            var deferred = $q.defer();

            var url = '/org/' + user.orgId + '/user/username/' + user.username;

            GeneralService.get(url).then(function (response) {
                deferred.resolve(response);
            });
            return deferred.promise;
        }

    };

    return UserService;
}]);
