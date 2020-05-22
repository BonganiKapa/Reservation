(function () {
    'use strict';
    angular
        .module('app')
        .controller('HomeController', HomeController);
 
    HomeController.$inject = ['$window', '$http', '$scope'];
    function HomeController($window, $http, $scope) {
        var vm = this;
        vm.client = null;
 
        initController();
 
        function initController() {
            $http({
                url: 'http://localhost:8080/client',
                method: "GET"
            }).then(function (response) {
                vm.client = response.data.name;
            }, function (error) {
                console.log(error);
            });
        };
 
        $scope.logout = function () {
            $window.sessionStorage.setItem('clientData', '');
            $http.defaults.headers.common['Authorization'] = 'Basic';
        }
    }
})();