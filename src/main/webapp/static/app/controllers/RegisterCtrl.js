(function() {
    'use strict';

    angular
        .module('app')
        .controller('RegisterCtrl', RegisterCtrl);

        RegisterCtrl.$inject = ['$scope', '$http', '$location', 'userService', 'toastr'];

        function RegisterCtrl($scope, $http, $location, userService, toastr) {
            $scope.registerUser = function() {
                        $http.post('/api/register', $scope.user,$scope.phoneNumber)
                            .then(function(response) {
                                userService.setInfo(response.data);
                                $location.path('/');
                                toastr.success('Register Success');
                            }, function (error) {
                                toastr.error("Username is already in exist.");
                            });
            };
        }
})();