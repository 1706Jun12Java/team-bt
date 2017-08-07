(function() {
    'use strict';

    angular
        .module('app')
        .controller('ProfileCtrl', ProfileCtrl);

    ProfileCtrl.$inject = ['$scope', '$http', '$location', 'userService','$route', 'toastr'];

    function ProfileCtrl($scope, $http, $location, userService,$route, toastr) {
            let vm = this;

            $http.get('/api/getProfile')
                .then(function(response) {
                    $scope.info=response.data;
                }, function (error) {
                    console.log("error");
                });

            $scope.changeNum = function() {
                $http.post('/api/changeNum', $scope.phoneNumber)
                    .then(function(response) {
                        userService.setInfo(response.data);
                        $route.reload();
                        toastr.success('Phone change success');
                    }, function (error) {
                        toastr.error('Phone change unsuccessful');
                    });
            };
    }
})();