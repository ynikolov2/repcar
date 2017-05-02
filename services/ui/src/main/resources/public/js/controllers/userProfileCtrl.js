/**
 * Created by mmanchev on 7/29/2016.
 */
angular.module('app').controller('userProfileCtrl', ['$scope', '$rootScope', '$mdEditDialog', '$mdDialog', '$q', '$timeout', '$state', '$stateParams', 'GeneralService', '$mdToast', 'UserService',
    function ($scope, $rootScope, $mdEditDialog, $mdDialog, $q, $timeout, $state, $stateParams, GeneralService, $mdToast, UserService) {

        $scope.userId = $stateParams.userId;
        $scope.newPassword = '';
        var pattern = '$@$!%*?&ABCDEFGHabcdefgh123456789908765043210';

        $scope.isUserSuperAdmin = UserService.isSuperAdmin();

        $scope.save = function (event) {
            $scope.user.roles = [];
            $scope.user.id = $scope.user.userId;
            $scope.user.username = $scope.user.username;
            $scope.user.organization = {id: $rootScope.orgId};
            if ($scope.newPassword !== pattern) {
                $scope.user.password = $scope.newPassword;
            } else {
                $scope.user.password = '';
            }

            $scope.roles.forEach(function (role) {
                if (role.flag) {
                    $scope.user.roles.push(role);
                }
                console.log(role.flag);
            });

            var url = '/org/' + $rootScope.orgId + '/user/';
            GeneralService.update($scope.user, url).then(
                function (response) {
                    $scope.showHgSuccessfullyUpdatedToast();
                    $scope.buttonsDisabled = true;
                    $scope.loadUser($scope.userId);
                });
        };

        $scope.loadUser = function (userId) {

            var url = '/org/' + $rootScope.orgId + '/user/' + userId;
            GeneralService.get(url).then(function (response) {
                response.links.forEach(function (link) {
                    if (link.rel === 'listClusters') {
                        $scope.listClustersURL = link.href;
                        listClusters();
                    }
                });

                $scope.user = response;
                $scope.newPassword = pattern;

                GeneralService.list('/user-roles').then(function (response) {
                    $scope.roles = response;
                    $scope.buttonsDisabled = true;
                    response.forEach(function (role) {
                        role.flag = userHasRole(role.id);
                    });
                });

            });
        };

        $scope.buttonsDisabled = true;

        $scope.userChange = function(){

            $scope.buttonsDisabled = false;
        };
        $scope.loadUser($scope.userId);

        function userHasRole(id) {
            var result = false;
            $scope.user.roles.some(function (role) {
                if (role.id === id) {
                    result = true;
                    return;
                }
            });
            return result;
        }

        $scope.showHgSuccessfullyUpdatedToast = function () {
            $mdToast.show(
                $mdToast.simple()
                    .textContent('User Updated!')
                    .theme('success-toast')
                    .position('bottom')
                    .hideDelay(6000)
            );
        };

        $scope.showHgNotUpdatedToast = function () {
            $mdToast.show(
                $mdToast.simple()
                    .textContent('User failed to update!')
                    .theme('error-toast')
                    .position('bottom')
                    .hideDelay(6000)
            );
        };

        function manageClusters(clusters) {
            $scope.providers= [''];
            $scope.clusters= [''];
            $scope.providerClusters= [{providerName:'', clusterNames: $scope.clusters}];
            for(var i = 0; i < clusters.length; i++){
                var providerName = clusters[i].providerName;
                if($scope.providers.indexOf(providerName) === -1){
                    $scope.providers.push(providerName);
                    $scope.providerClusters.push({providerName:providerName, clusterNames: ['']});
                }
                for(var x in $scope.providerClusters){
                    var providerCluster = $scope.providerClusters[x];
                    if(providerCluster.providerName === providerName){
                        var currentCluster = providerCluster.clusterNames;
                        currentCluster.push(clusters[i].callProcessingId);
                        break;
                    }
                }
            };
        };

        $scope.changedProviderName = function (providerName) {
            var providerName = $scope.user.providerName;
            for(var x in $scope.providerClusters){
                var providerCluster = $scope.providerClusters[x];
                if(providerCluster.providerName === providerName){
                    var currentCluster = providerCluster.clusterNames;
                    $scope.clusters = currentCluster;
                    return;
                }
            }
            $scope.clusters= [''];
        }

        function listClusters() {
            GeneralService.list($scope.listClustersURL).then(function (response) {
                manageClusters(response);
                $scope.changedProviderName();
            });
        };
    }]);
