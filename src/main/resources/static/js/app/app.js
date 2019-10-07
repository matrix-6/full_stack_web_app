var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootDemoApp',
    EMPLOYEEINFO_SERVICE_API : 'http://localhost:8080/SpringBootDemoApp/api/employeeInfo/',
    COST_SERVICE_API : 'http://localhost:8080/SpringBootDemoApp/api/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'EmployeeInfoController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, EmployeeInfoService) {
                        console.log('Load all employeeInfos');
                        var deferred = $q.defer();
                        EmployeeInfoService.loadAllEmployeeInfos().then(deferred.resolve, deferred.resolve);
                        
                        EmployeeInfoService.loadAllCosts().then(deferred.resolve, deferred.resolve);
                        
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

