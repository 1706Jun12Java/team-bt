(function() {
    'use strict';

    angular
        .module('app')
        .factory('userService', userService);

    userService.$inject = [];

    function userService() {

        var userInfo = null;

        var userService = {
            setInfo: function(info) {
                // console.log($cookies.getAll());
                userInfo = info;
            },
            removeInfo: function() {
                userInfo = null;
            },
            isAuthenticated: function() {
                if (userInfo !== null)
                    return true;
                return false;
            }
        };

        return userService;
    }
})();