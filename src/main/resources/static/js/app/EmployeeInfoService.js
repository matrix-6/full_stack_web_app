'use strict';

angular.module('crudApp').factory('EmployeeInfoService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllEmployeeInfos: loadAllEmployeeInfos,
                getAllEmployeeInfos: getAllEmployeeInfos,
                getEmployeeInfo: getEmployeeInfo,
                createEmployeeInfo: createEmployeeInfo,
                updateEmployeeInfo: updateEmployeeInfo,
                removeEmployeeInfo: removeEmployeeInfo,
                loadAllCosts: loadAllCosts,
                getAllCosts: getAllCosts
            };

            return factory;

            function loadAllEmployeeInfos() {
                console.log('Fetching all employeeInfos');
                var deferred = $q.defer();
                $http.get(urls.EMPLOYEEINFO_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all employeeInfos');
                            $localStorage.employeeInfos = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading employeeInfos');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllEmployeeInfos(){
                return $localStorage.employeeInfos;
            }

            function getEmployeeInfo(id) {
                console.log('Fetching EmployeeInfo with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.EMPLOYEEINFO_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully EmployeeInfo with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading employeeInfo with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createEmployeeInfo(employeeInfo) {
                console.log('Creating EmployeeInfo');
                var deferred = $q.defer();
                $http.post(urls.EMPLOYEEINFO_SERVICE_API, employeeInfo)
                    .then(
                        function (response) {
                            loadAllEmployeeInfos();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating EmployeeInfo : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateEmployeeInfo(employeeInfo, id) {
                console.log('Updating EmployeeInfo with id '+id);
                var deferred = $q.defer();
                $http.put(urls.EMPLOYEEINFO_SERVICE_API + id, employeeInfo)
                    .then(
                        function (response) {
                            loadAllEmployeeInfos();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating EmployeeInfo with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeEmployeeInfo(id) {
                console.log('Removing EmployeeInfo with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.EMPLOYEEINFO_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllEmployeeInfos();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing EmployeeInof with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            
            function loadAllCosts() {
                console.log('Fetching all companySalarCostGroups');
                var deferred = $q.defer();
                $http.get(urls.COST_SERVICE_API + "companySalaryCostGroup/")
                    .then(
                        function (response) {
                            console.log('Fetched successfully all companySalaryCostGroups');
                            $localStorage.costs = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading companySalaryCostGroup');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function getAllCosts(){
                return $localStorage.costs;
            }

        }
    ]);