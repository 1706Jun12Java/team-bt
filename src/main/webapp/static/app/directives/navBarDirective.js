(function () {
    'use strict';

    angular
        .module('app')
        .directive('navbar', navbar);

    function navbar () {
        return {
            restrict: 'EA',
            templateUrl: '/static/views/navbar.html',
        };
    }
})();