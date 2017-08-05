(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginCtrl', ['$scope', '$http', '$location','userService', function($scope, $http, $location, userService){
            $scope.loginUser = function() {
                $http.post('/login', $scope.user)
                    .then(function(response) {
                        console.log("sucess");
                        userService.setInfo(response.data);
                        $location.path('/');
                    }, function (error) {
                        console.log("error");
                        console.log(error);
                    })
            };
        }]);
})();