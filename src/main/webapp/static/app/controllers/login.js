(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginCtrl', ['$scope', '$http', function($scope, $http){
            $scope.loginUser = function() {
                $http.post('/login', $scope.user)
                    .then(function(response) {
                        console.log("sucess");
                        console.log($scope.user);
                        console.log(response);
                    }, function (error) {
                        console.log("error");
                        console.log(error);
                        console.log($scope.user);
                    })
            };
        }]);
})();