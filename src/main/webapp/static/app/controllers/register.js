(function() {
    'use strict';

    angular
        .module('app')
        .controller('RegisterCtrl', ['$scope', '$http', function($scope, $http){
            $scope.registerUser = function() {
                $http.post('/register', $scope.user)
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