'use strict';

angular.module('crudApp').controller('EmployeeInfoController',
    ['EmployeeInfoService', '$scope',  function( EmployeeInfoService, $scope) {

        var self = this;
        self.employeeInfo = {};
        self.employeeInfos=[];
        
        self.costs=[];

        self.submit = submit;
        self.getAllEmployeeInfos = getAllEmployeeInfos;
        self.createEmployeeInfo = createEmployeeInfo;
        self.updateEmployeeInfo = updateEmployeeInfo;
        self.removeEmployeeInfo = removeEmployeeInfo;
        self.editEmployeeInfo = editEmployeeInfo;
        self.reset = reset;

        self.reloadCosts = reloadCosts;
        self.getAllCosts = getAllCosts;
        
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.employeeInfo.id === undefined || self.employeeInfo.id === null) {
                console.log('Saving New EmployeeInfo', self.employeeInfo);
                createEmployeeInfo(self.employeeInfo);
            } else {
                updateEmployeeInfo(self.employeeInfo, self.employeeInfo.id);
                console.log('EmployeeInfo updated with id ', self.employeeInfo.id);
            }
        }

        function createEmployeeInfo(employeeInfo) {
            console.log('About to create employeeInfo');
            EmployeeInfoService.createEmployeeInfo(employeeInfo)
                .then(
                    function (response) {
                        console.log('EmployeeInfo created successfully');
                        self.successMessage = 'EmployeeInfo created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.employeeInfo={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating EmployeeInfo');
                        self.errorMessage = 'Error while creating EmployeeInfo: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateEmployeeInfo(employeeInfo, id){
            console.log('About to update employeeInfo');
            EmployeeInfoService.updateEmployeeInfo(employeeInfo, id)
                .then(
                    function (response){
                        console.log('EmployeeInfo updated successfully');
                        self.successMessage='EmployeeInfo updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.employeeInfo={};
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating EmployeeInfo');
                        self.errorMessage='Error while updating EmployeeInfo '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeEmployeeInfo(id){
            console.log('About to remove EmployeeInfo with id '+id);
            EmployeeInfoService.removeEmployeeInfo(id)
                .then(
                    function(){
                        console.log('EmployeeInfo '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing employeeInfo '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllEmployeeInfos(){
            return EmployeeInfoService.getAllEmployeeInfos();
        }

        function editEmployeeInfo(id) {
            self.successMessage='';
            self.errorMessage='';
            EmployeeInfoService.getEmployeeInfo(id).then(
                function (employeeInfo) {
                    self.employeeInfo = employeeInfo;
                },
                function (errResponse) {
                    console.error('Error while removing employeeInfo ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.employeeInfo={};
            $scope.myForm.$setPristine(); //reset Form
        }
        
        function getAllCosts(){
        	return EmployeeInfoService.getAllCosts();
        }
        
        function reloadCosts() {
            console.log('Reloading all costs');
            EmployeeInfoService.loadAllCosts()
            .then(
                function (response) {
                    console.log('CompanySalaryCostGroup created successfully');
                    self.successMessage = 'CompanySalaryCostGroup created successfully';
                    self.errorMessage='';
                    self.done = true;
                    $scope.myForm2.$setPristine();
                },
                function (errResponse) {
                    console.error('Error while creating EmployeeInfo');
                    self.errorMessage = 'Error while creating EmployeeInfo: ' + errResponse.data.errorMessage;
                    self.successMessage='';
                }
            );
        }
    }


    ]);