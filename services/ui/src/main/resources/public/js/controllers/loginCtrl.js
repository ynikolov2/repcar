angular.module('app').controller('loginCtrl',
        ['$rootScope', '$scope', '$mdDialog','$http', '$sessionStorage', '$state', 'AuthService', 'UserService', 'GeneralService',
         function ($rootScope, $scope, $mdDialog, $http, $sessionStorage, $state, AuthService, UserService, GeneralService) {

    $scope.username = null;
    $scope.password = null;

    var authenticate = function(username, password, callback) {
		
				var req = {
                    method: 'POST',
                    url: '/token?username=' + username + '&password=' + password
                };
                AuthService.login(req).then(function (response) {
                    if (response.access_token) {
                        $http.defaults.headers.common['Authorization'] = 'Bearer ' + response.access_token;
                        sessionStorage.setItem('access_token', response.access_token);
                        $rootScope.loggedIn = true;
                        $scope.logoutButton = true;
                        UserService.loadUser().then(function() {
                        	 $state.go('home');
                        });
                    } else if(response.error) {
                        alert("Bad Credentials!");
                    }
                });

 /*       var token = btoa(username + ":" + password);
        var user = {};
        var config = {
            headers: {}
        };
        config.headers.Authorization = 'Basic ' + token;
        $http.get('login-user', config).success(function(data) {

            if (data.name) {
              user = {
                  loggedIn: true,
                  username: data.name,
                  orgId: data.principal.orgId
              };

              if(userHasRole(data, 'ROLE_SUPER_ADMIN')){
                  user.userRole ='ROLE_SUPER_ADMIN';
              }else if(userHasRole(data, 'ROLE_ORG_ADMIN')){
                  user.userRole ='ROLE_ORG_ADMIN';
              }

              $sessionStorage.user = user;
              $rootScope.loggedIn = true;
                if (angular.isDefined($sessionStorage.user)) {
                    UserService.getUserDetails($sessionStorage.user).then(function (response) {
                        $rootScope.userDetails = response;
                    });
                }
          } else {
              user = {
                  loggedIn: false
              };
              $sessionStorage.user = user;
              $rootScope.loggedIn = false;
          }
            /*jshint -W030 */
 /*         callback && callback();
        }).error(function() {
            user = {
                loggedIn: false
            };
            $sessionStorage.user = user;
            /*jshint -W030 */
 /*         callback && callback();
        });
*/
      };

    $scope.login = function(username, password){

            authenticate(username, password, function() {
              if ($sessionStorage.user.loggedIn) {
                  if(UserService.isSuperAdmin()){
                      $state.go('organizations');
                  }else if(UserService.isOrgAdmin()){
                      $state.go('editOrganizationProfile', { organizationId: UserService.getUserOrganizationId() });
                  }
                  $scope.error = false;
              }else{
                  $scope.error = true;
              }
            });
    };

    function userHasRole(user, id){
        var result = false;
        user.authorities.some(function(role) {
            if(role.authority === id){
                result = true;
                return;
            }
        });
        return result;
     }
}]);
