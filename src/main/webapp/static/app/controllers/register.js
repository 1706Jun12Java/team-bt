(function() {
    'use strict';

    angular
        .module('app')
        .controller('RegisterCtrl', ['$scope', '$http', '$location', 'userService', function($scope, $http, $location, userService){
            $scope.registerUser = function() {
                $http.post('/register', $scope.user,$scope.phoneNumber)
                    .then(function(response) {
                        console.log("sucess");
                        console.log($scope.user);
                        <!--userService.setInfo(response.data);-->
                        console.log(response);
                        $location.path('/');
                    }, function (error) {
                        console.log("error");
                        console.log(error);
                        console.log($scope.user);
                    })

            };
        }]);
})();