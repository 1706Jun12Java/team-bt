(function() {
    'use strict';

    angular
        .module('app')
        .controller('ImageCtrl', ImageCtrl);

    ImageCtrl.$inject = ['$scope', '$http', '$location', 'userService','$routeParams'];

    function ImageCtrl($scope, $http, $location, userService,$routeParams) {
        console.log("ImageCtrl");
        console.log($routeParams.id)
        $http.get('/api/image/'+$routeParams.id)
            .then(function(response) {
                $scope.imgdata=response.data;
            }, function (error) {
                console.log(error);
            });

    }
})();