angular.module('app').controller('mainCtrl',
    ['$rootScope', '$scope', '$mdSidenav', '$state', '$sessionStorage', '$location', 'UserService', '$mdDialog', 'Idle', 'GeneralService', '$cookies',
        function ($rootScope, $scope, $mdSidenav, $state, $sessionStorage, $location, UserService, $mdDialog, Idle, GeneralService, $cookies) {

            $scope.loaded = false;

            $scope.isSuperAdmin = function() {
                return UserService.isSuperAdmin();
            };

            $scope.$on('IdleTimeout', function() {
                $rootScope.announceClick("Logout");
            });

            $rootScope.forceChange = false;

            $rootScope.forcePasswordChange = false;
            $scope.$watch('forcePasswordChange', function () {
                if($rootScope.forcePasswordChange === 'true'){
                    $rootScope.forceChange = true;
                    $scope.changePasswordModal();
                }else {
                    $rootScope.forceChange = false;
                }

            }, true);

            $scope.themes = {
                'default': {
                    name: 'default'
                },
                'blue': {
                    name: 'blue'
                },
                'default-dark': {
                    name: 'default-dark'
                },
                'blue-dark': {
                    name: 'blue-dark'
                }

            };

            $scope.colorMode = '';
            $scope.activeTheme = 'default';

            $scope.themeChange = function (theme) {
                $scope.activeTheme = theme;
            };


            $scope.showMobileMainHeader = true;
            $scope.openSideNavPanel = function () {
                $mdSidenav('left').open();
            };
            $scope.closeSideNavPanel = function () {
                $mdSidenav('left').close();
            };

            $scope.go = function (location) {
                $scope.closeSideNavPanel();
                $state.go(location);
            };

            $scope.loaded = true;

            $scope.items = function () {
                if (angular.isDefined(sessionStorage.sessionUser)) {
                    return ['Logout', 'Change Password'];
                } else {
                    return ['Login'];
                }
            };

            $scope.goToUserLanding = function() {
                $scope.closeSideNavPanel();
                if(UserService.isSuperAdmin()){
                    $state.go('organizations');
                }else if(UserService.isOrgAdmin()){
                    $state.go('editOrganizationProfile', { organizationId: UserService.getUserOrganizationId() });
                }
            };


            $rootScope.loggedIn = false;
            if (angular.isDefined($sessionStorage.user)) {
                $rootScope.loggedIn = $sessionStorage.user.loggedIn;
            }
            $rootScope.announceClick = function (action) {
                if (action === 'Logout') {
                    GeneralService.get('/security/logout-user/'+'admin').then(function (response) {
                        /*jshint -W069 */
                        $cookies.remove("XSRF-TOKEN");
                        $cookies.remove("JSESSIONID");

                        delete sessionStorage.access_token;
                        if (angular.isDefined(sessionStorage.sessionUser)) {
                            var user = {
                                loggedIn: false
                            };
                            sessionStorage.sessionUser = user;
                            $rootScope.loggedIn = false;
                        }

                        $scope.go('login');
                    },function (error) {
                        console.log(error);
                    });

                } else if (action === 'Login') {
                    $location.path('/login');
                }else if (action === 'Change Password') {
                    $scope.changePasswordModal();
                }
            };

            $scope.changePasswordModal = function () {
                $mdDialog.show({
                    controller: ChangePasswordController,
                    templateUrl: 'view/dialogs/changePassword.html',
                    parent: angular.element(document.body),
                  //  targetEvent: ev,
                    clickOutsideToClose: !$rootScope.forceChange,
                    escapeToClose: !$rootScope.forceChange
                }).then(function (data) {
                    console.log("Change Password");
                }, function () {
                    $scope.status = 'Dialog canceled.';
                });
            };

            function ChangePasswordController($rootScope, $scope, $mdDialog, $mdToast, GeneralService, $state) {

                $scope.changePassword = {
                    userId: $rootScope.userDetails.userId,
                    orgId: UserService.getUserOrganizationId()
                };

                $scope.force = $rootScope.forceChange;

                $scope.hide = function () {
                    $mdDialog.hide();
                };

                $scope.cancel = function () {
                    $mdDialog.cancel();
                };

                if( $rootScope.organizationId){
                    $scope.changePasswordUrl = "/org/" + $rootScope.organizationId + "/change/password"; 
                }else{
                    $scope.changePasswordUrl = "/change/password";
                }


                $scope.answer = function (answer) {

                    GeneralService.save($scope.changePassword, $scope.changePasswordUrl).then(function (response) {
                        if(response.message === "OK"){
                            $scope.showOkToast();
                            $mdDialog.hide(answer);
                            if (angular.isDefined($sessionStorage.user)) {
                                var user = {
                                    loggedIn: false
                                };
                                $sessionStorage.user = user;
                                $rootScope.loggedIn = false;
                            }

                            $state.go('login');
                        }else{
                            $scope.showErrorToast(response.message);
                        }
                    },function (error) {
                        console.log(error);
                    });

                    //$mdDialog.hide(answer);
                };

                $scope.showErrorToast = function (message) {
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent('Error: ' + message)
                            .theme('error-toast')
                            .position('bottom')
                            .hideDelay(6000)
                    );
                };

                $scope.showOkToast = function () {
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent('Password Successfully changed!')
                            .theme('success-toast')
                            .position('bottom')
                            .hideDelay(3000)
                    );
                };
            }
        }]);

