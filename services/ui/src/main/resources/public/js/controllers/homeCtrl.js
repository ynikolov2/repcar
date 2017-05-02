/**
 * Created by mmanchev on 7/29/2016.
 */
angular.module('app').controller('homeCtrl', ['$scope', '$rootScope', '$mdEditDialog', '$mdDialog', '$q', '$timeout', '$state', '$stateParams', 'GeneralService', '$mdToast', 'UserService',
    function ($scope, $rootScope, $mdEditDialog, $mdDialog, $q, $timeout, $state, $stateParams, GeneralService, $mdToast, UserService) {

		$scope.dashboard = 'Dashboard';
		  GeneralService.get('/user/users?'+'companyId=1').then(function (response) {
			  console.log(response);
          },function (error) {
              console.log(error);
          });
	
    }]);
