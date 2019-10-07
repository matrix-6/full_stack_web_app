<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">EmployeeInfo </span></div>
		<div class="panel-body">
		
			<table class="table table-hover">
				<tr>
					<th>
						<div class="formcontainer">
				            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
				            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
				            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
				                <input type="hidden" ng-model="ctrl.employeeInfo.id" />
				                <div class="row">
				                    <div class="form-group col-md-12">
				                        <label class="col-md-2 control-lable" for="sFirstName">First Name</label>
				                        <div class="col-md-7">
				                            <input type="text" ng-model="ctrl.employeeInfo.sFirstName" id="sFirstName" class="employeeInfoname form-control input-sm" placeholder="Enter your first name" required ng-minlength="3"/>
				                        </div>
				                    </div>
				                </div>
				                
				                <div class="row">
				                    <div class="form-group col-md-12">
				                        <label class="col-md-2 control-lable" for="sLastName">Last Name</label>
				                        <div class="col-md-7">
				                            <input type="text" ng-model="ctrl.employeeInfo.sLastName" id="sLastName" class="employeeInfoname form-control input-sm" placeholder="Enter your last name" required ng-minlength="3"/>
				                        </div>
				                    </div>
				                </div>
			
				                <div class="row">
				                    <div class="form-group col-md-12">
				                        <label class="col-md-2 control-lable" for="sCompany">Company</label>
				                        <div class="col-md-7">
				                            <input type="text" ng-model="ctrl.employeeInfo.sCompany" id="sCompany" class="employeeInfoname form-control input-sm" placeholder="Enter your company name." required ng-minlength="3"/>
				                        </div>
				                    </div>
				                </div>
				                
				                <div class="row">
				                    <div class="form-group col-md-12">
				                        <label class="col-md-2 control-lable" for="sAddress">Address</label>
				                        <div class="col-md-7">
				                            <input type="text" ng-model="ctrl.employeeInfo.sAddress" id="sAddress" class="form-control input-sm" placeholder="Enter your address" required ng-minlength="3"/>
				                        </div>
				                    </div>
				                </div>
				
				                <div class="row">
				                    <div class="form-group col-md-12">
				                        <label class="col-md-2 control-lable" for="dSalary">Salary</label>
				                        <div class="col-md-7">
				                            <input type="text" ng-model="ctrl.employeeInfo.dSalary" id="dSalary" class="form-control input-sm" placeholder="Enter your Salary." required ng-pattern="ctrl.onlyNumbers"/>
				                        </div>
				                    </div>
				                </div>
			
				                <div class="row">
				                    <div class="form-actions floatRight">
				                        <input type="submit"  value="{{!ctrl.employeeInfo.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
				                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
				                    </div>
				                </div>
				            </form>
			    	    </div>
					</th>
					<th>
						<div class="table-responsive">
					        <table class="table table-hover">
					            <thead>
					            <tr>
					                <th>ID</th>
					                <th>FIRST NAME</th>
					                <th>LAST NAME</th>
					                <th>COMPANY</th>
					                <th>ADDRESS</th>
					                <th>SALARY</th>
					                <th width="100"></th>
					                <th width="100"></th>
					            </tr>
					            </thead>
					            <tbody>
					            <tr ng-repeat="u in ctrl.getAllEmployeeInfos()">
					                <td>{{u.id}}</td>
					                <td>{{u.sFirstName}}</td>
					                <td>{{u.sLastName}}</td>
					                <td>{{u.sCompany}}</td>
					                <td>{{u.sAddress}}</td>
					                <td>{{u.dSalary}}</td>
					                <td><button type="button" ng-click="ctrl.editEmployeeInfo(u.id)" class="btn btn-success custom-width">Edit</button></td>
					                <td><button type="button" ng-click="ctrl.removeEmployeeInfo(u.id)" class="btn btn-danger custom-width">Remove</button></td>
					            </tr>
					            </tbody>
					        </table>		
						</div>
					</th>
				</tr>		
			</table>    	    
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Find Company Salary Cost </span></div>
		<div class="panel-body">
			
			<div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	           
	            <form ng-submit="ctrl.reloadCosts()" name="myForm2" class="form-horizontal">
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="sFirstName">Company Name</label>
	                        <div class="col-md-7">	                            							
								<select ng-model="companyCost" ng-options="cost.sCompany for cost in ctrl.getAllCosts()" class="form-control input-sm">
							      <option value="">-- choose company --</option>
							    </select>								
	                        </div>
	                    </div>
	                </div>
	                			
	                <tt>Current Salary Cost($): {{companyCost.dSumSalary}}</tt><br/>
	                <hr>
	                			
					<div class="row">
	                    <div class="form-actions floatRight">
	                        <button type="button" ng-click="ctrl.reloadCosts()" class="btn btn-warning btn-sm" >Reload Company Salary Cost</button>
	                    </div>
	                </div>
	            </form>				
			
		</div>
    </div>
</div>