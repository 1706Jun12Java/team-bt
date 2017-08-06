(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginCtrl', LoginCtrl);

        LoginCtrl.$inject = ['$scope', '$http', '$location', 'userService', 'toastr'];

        function LoginCtrl($scope, $http, $location, userService, toastr) {
                $scope.loginUser = function() {
                    $http.post('/api/login', $scope.user)
                        .then(function(response) {
                            userService.setInfo(response.data);
                            $location.path('/');
                            toastr.success('Login Success');
                        }, function (error) {
                            toastr.error("Username and password you entered did not match our records.");
                        });
                };
        }
})();