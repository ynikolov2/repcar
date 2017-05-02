var app = angular.module('app', ['ngResource', 'ngMaterial', 'ngMessages', 'ui.router', 'md.data.table', 'ncy-angular-breadcrumb', 'ngStorage', 'ngCookies', 'mdPickers', 'ngIdle', 'ngSanitize', 'ngCsv', 'angularFileUpload']);
app.config(['$mdThemingProvider', '$mdIconProvider', '$urlRouterProvider', '$stateProvider', '$httpProvider',
    function ($mdThemingProvider, $mdIconProvider, $urlRouterProvider, $stateProvider, $httpProvider, $rootScope, $scope, $stateParams) {

        //UI Routing

        $stateProvider.state('login', {
            url: '',
            templateUrl: 'view/pages/login.html',
            controller: 'loginCtrl'
        }).state('unauthorized', {
            url: '/unauthorized',
            templateUrl: 'view/pages/unauthorized.html',
            controller: ''
        }).state('user', {
            url: '/editOrganizationProfile/{organizationId}/user/{userId}',
            templateUrl: 'view/pages/userProfile.html',
            controller: 'userProfileCtrl',
            resolve:{
                security: ['$q', 'UserService', '$stateParams', function($q, UserService, $stateParams){
                    if(UserService.isSuperAdmin() || (UserService.isOrgAdmin() && (UserService.getUserOrganizationId() ==$stateParams.organizationId))){
                        return;
                    }else{
                        return $q.reject("Not Authorized");
                    }
                }]
            },
            ncyBreadcrumb: {
                label: 'User',
                parent: function ($rootScope) {
                    return 'editHuntGroupProfile({huntGroupId: ' + $rootScope.huntGrId + ',organizationId: ' + $rootScope.orgId +'})';
                }
            }
        }).state('orgUser', {
            url: '/editOrganizationProfile/{organizationId}/orgUser/{userId}',
            templateUrl: 'view/pages/userProfile.html',
            controller: 'userProfileCtrl',
            resolve:{
                security: ['$q', 'UserService', '$stateParams', function($q, UserService, $stateParams){
                    if(UserService.isSuperAdmin() || (UserService.isOrgAdmin() && (UserService.getUserOrganizationId() ==$stateParams.organizationId))){
                        return;
                    }else{
                        return $q.reject("Not Authorized");
                    }
                }]
            },
            ncyBreadcrumb: {
                label: 'User',
                parent: function ($rootScope) {
                    return 'editOrganizationProfile({organizationId: ' + $rootScope.orgId + '})';
                }
            }
        }).state('editOrganizationProfile', {
            url: '/editOrganizationProfile/{organizationId}',
            templateUrl: 'view/pages/editOrganizationProfile.html',
            controller: 'editOrganizationProfileCtrl',
            resolve: {
                saveOrganizationId: ['$stateParams', '$rootScope', function ($stateParams, $rootScope) {
                    $rootScope.orgId = $stateParams.organizationId;
                    return $stateParams.organizationId;
                }],
                getParent: ['$rootScope', 'UserService', function ($rootScope, UserService) {

                    $rootScope.getParent = function(){
                        if(UserService.isSuperAdmin()){
                            return 'organizations';
                        }else{
                            return;
                        }
                    };

                }],
                security: ['$q', 'UserService', '$stateParams', function($q, UserService, $stateParams){
                    if(UserService.isSuperAdmin() || (UserService.isOrgAdmin() && (UserService.getUserOrganizationId() ==$stateParams.organizationId))){
                        return;
                    }else{
                        return $q.reject("Not Authorized");
                    }
                }]
            },
            ncyBreadcrumb: {

                label: 'Organization',
                parent: function($rootScope) {
                    return $rootScope.getParent();
                }
            }
        }).state('home', {
            url: '/home',
            templateUrl: 'view/pages/home.html',
            controller: 'homeCtrl',
            resolve: {
                security: ['$q', 'UserService', function($q, UserService){
                    if(UserService.isSuperAdmin()){
                        return $q.reject("Not Authorized");
                    }
                }]
            },
            ncyBreadcrumb: {
                label: 'Organizations'
            }
        });

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';


        var customPallete = $mdThemingProvider.extendPalette('grey', {
            'contrastDefaultColor': 'light'
        });

        // Register the new color palette map with the name <code>neonRed</code>
        $mdThemingProvider.definePalette('greyTheme', customPallete);

        $mdThemingProvider.theme('default')
            .primaryPalette('greyTheme')
            .accentPalette('grey');

        // other color intentions will be inherited
        // from default

        $mdThemingProvider.alwaysWatchTheme(true);

        $mdIconProvider
            .iconSet('social', 'img/icons/sets/social-icons.svg', 24)
            .defaultIconSet('img/icons/sets/core-icons.svg', 24);
    }]);

app.config(function ($breadcrumbProvider) {
    $breadcrumbProvider.setOptions({
        template: '<div><div class="breadcrumb flat"><a ng-repeat="step in steps" ng-switch="$last || !!step.abstract" ng-class="{active: $last}"  href="#{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a></div> </div>'
    });
});

app.config(function(IdleProvider, KeepaliveProvider) {
    // configure Idle settings
    IdleProvider.idle(1800); // in seconds
  //  IdleProvider.timeout(5); // in seconds
  //  KeepaliveProvider.interval(2); // in seconds
});

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push('AuthInterceptor');
}]);

app.run(function($rootScope, $state, $location, UserService){
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
    	$rootScope.loggedIn = UserService.isLoggedIn();
        /*       if  (toState.name !== 'login' && !loggedIn){
            $state.go('login');
        }else if(toState == fromState) {
            event.preventDefault();
            if(UserService.isSuperAdmin()){
                $state.go('home');
            }else if(UserService.isOrgAdmin()){
                $state.go('organizations', { organizationId: UserService.getUserOrganizationId() });
            }
        } */
    });
});

app.run(function(Idle){
    // start watching when the app runs. also starts the Keepalive service by default.
    Idle.watch();
});

app.run(function($rootScope, $state, $location, $sessionStorage, UserService){
    $rootScope.$on("$locationChangeStart", function (event, next, current) {
    	$rootScope.loggedIn = UserService.isLoggedIn();
      /*      if (next == current && loggedIn) {
            if (angular.isDefined(sessionStorage.sessionUser)) {
                UserService.getUserDetails(sessionStorage.sessionUser).then(function (response) {
                    $rootScope.userDetails = response;
                });
            	$rootScope.userDetails = sessionStorage.sessionUser;
            }
            event.preventDefault();
            if(UserService.isSuperAdmin()){
                $state.go('organizations');
            }else if(UserService.isOrgAdmin()){
                $state.go('editOrganizationProfile', { organizationId: UserService.getUserOrganizationId() });
            }
        } else if(!loggedIn) {
            $state.go('login');
        } */
    });
});

app.run(function($rootScope, $state){
    $rootScope.$on('$stateChangeError', function(e, toState, toParams, fromState, fromParams, error){
        if(error === "Not Authorized"){
            $state.go("unauthorized");
        }
    });
});