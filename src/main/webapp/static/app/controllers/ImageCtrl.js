(function() {
    'use strict';

    angular
        .module('app')
        .controller('ImageCtrl', ImageCtrl);

    ImageCtrl.$inject = ['$scope', '$http', '$location', 'userService'];

    function ImageCtrl($scope, $http, $location, userService) {
        console.log("ImageCtrl");
    }
})();