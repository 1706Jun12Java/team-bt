(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginCtrl', ['$scope', '$http', '$location','userService', function($scope, $http, $location, userService){
            $scope.loginUser = function() {
                $http.post('/login', $scope.user)
                    .then(function(response) {
                        console.log("sucess");
                        console.log($scope.user);
                        $location.path('/');
                        userService.setInfo(response.data);
                        console.log(response);
                    }, function (error) {
                        console.log("error");
                        console.log(error);
                        console.log($scope.user);
                    })
            };
        }]);
})();