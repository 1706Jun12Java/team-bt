(function() {
    'use strict';

    angular
        .module('app')
        .factory('userService', userService);

    // UserService.$inject = [];

    function userService() {

        var userInfo = null;

        var userService = {
            setInfo: function(info) {
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