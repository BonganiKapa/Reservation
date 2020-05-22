(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController);
 
    LoginController.$inject = ['$location', '$window', '$http'];
    function LoginController($location, $window, $http) {
        var vm = this;
        vm.login = login;
 
        (function initController() {
            $window.localStorage.setItem('token', '');
        })();
 
        function login() {
            $http({
                url: 'http://localhost:8080/login',
                method: "POST",
                data: { 
                    'clientEmail': vm.email,
                    'password': vm.password
                }
            }).then(function (response) {
                if (response.data) {
                    var token
                      = $window.btoa(vm.email + ':' + vm.password);
                    var userData = {
                        clientEmail: vm.email,
                        authData: token
                    }
                    $window.sessionStorage.setItem(
                      'clientData', JSON.stringify(clientData)
                    );
                    $http.defaults.headers.common['Authorization']
                      = 'Basic ' + token;
                    $location.path('/');
                } else {
                    alert("Authentication failed.")
                }
            });
        };
    }
})();