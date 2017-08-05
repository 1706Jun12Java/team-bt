(function() {
    'use strict';

    angular
        .module('app')
        .controller('PostImageCtrl', ['$scope', '$http', '$location', 'userService', function($scope, $http, $location, userService){
            $scope.newImage = function() {
                $http.post('/postImage', $scope.postImage)
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