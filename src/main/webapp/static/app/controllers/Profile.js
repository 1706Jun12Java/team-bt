(function() {
    'use strict';

    angular
        .module('app')
        .controller('ProfileCtrl', ProfileCtrl);

    ProfileCtrl.$inject = ['$scope', '$http', '$location', 'userService','$route'];

    function ProfileCtrl($scope, $http, $location, userService,$route) {
            $http.get('/getProfile')
                .then(function(response) {
                    console.log("sucess");
                    console.log(response);
                    $scope.info=response.data;
                    console.log($scope.info);
                }, function (error) {
                    console.log("error");
                    console.log(error);
                });
        $scope.changeNum = function() {
            $http.post('/changeNum', $scope.phoneNumber)
                .then(function(response) {
                    console.log("sucess");
                    userService.setInfo(response.data);
                    $route.reload();
                }, function (error) {
                    console.log("error");
                    console.log(error);
                });
        };
    }
})();