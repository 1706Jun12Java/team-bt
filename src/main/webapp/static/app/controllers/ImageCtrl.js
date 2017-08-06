(function() {
    'use strict';

    angular
        .module('app')
        .controller('ImageCtrl', ImageCtrl);

    ImageCtrl.$inject = ['$scope', '$http', '$location', 'userService','$routeParams'];

    function ImageCtrl($scope, $http, $location, userService,$routeParams) {
        console.log("ImageCtrl");
        console.log($routeParams.id)
        $http.get('/image/'+$routeParams.id)
            .then(function(response) {
            console.log("sucess");
            console.log(response);
            $scope.imgdata=response.data;
            console.log($scope.imgdata);
        }, function (error) {
            console.log("error");
            console.log(error);
        });

    }
})();