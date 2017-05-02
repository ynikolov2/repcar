angular.module('app').factory('AuthInterceptor',
        [ '$rootScope', '$location', '$sessionStorage', '$q', '$cookies', function($rootScope, $location, $sessionStorage, $q, $cookies) {
            return {
                'request' : function(config) {
                    config.headers = config.headers || {};
                    if(sessionStorage.access_token){
                        config.headers.Authorization = 'Bearer ' + sessionStorage.access_token;
                    }                
                    
                    return config;
                },
            	response : function(response) {
                    if (response.status === 401) {
                        console.log("Response 401");
                    }
                    return response || $q.when(response);
                },
                responseError : function(rejection) {
                    if (rejection.status === 401) {
                        /*jshint -W069 */
                        $location.path('/login');
                        var user = {
                            loggedIn: false
                        };
                        $sessionStorage.user = user;
                        $rootScope.authenticated = false;
                        $cookies.remove("XSRF-TOKEN");
                    }
                    return $q.reject(rejection);
                }
            };
        } ]);