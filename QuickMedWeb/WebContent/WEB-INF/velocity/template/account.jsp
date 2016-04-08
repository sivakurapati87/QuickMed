<div class="container-fluid" style="background: white; width: 100%;" id="login_signupDivId">
	<div style="height: 10px;"></div>
	<div
		style="width: 80%; background: #f3f2c5; margin: 2px auto; padding: 5px 10px;">
		<div class="row" ng-click="isSignupAscending = !isSignupAscending">
			<div class=" col-md-5">
				<h4>New customer ? Create Your Accout Here.</h4>
			</div>
			<div class=" col-md-7" style="text-align: right;">
				<span
					ng-class="isSignupAscending ? 'fa fa-caret-square-o-up color_blue' : 'fa fa-caret-square-o-down color_blue'"></span>
			</div>
		</div>
	</div>
	<div ng-if="isSignupAscending"
		style="width: 80%; background:; margin: -10px auto; border: 1px solid #f3f2c5; padding: 10px; border-top: none;">
		<form ng-submit="registrationAction()">
			<div style="height: 10px;"></div>
			<div class="row">
				<div class=" col-md-5">
					<label>Enter Your First Name</label> <input type="text"
						ng-model="rsCustomerJson.firstName" required="required"
						class="form-control">
				</div>
				<div class="col-md-1"></div>

				<div class=" col-md-5">
					<label>Enter Your Last Name</label> <input type="text"
						ng-model="rsCustomerJson.lastName" required="required"
						class="form-control">
				</div>
				<div class="col-md-1"></div>
			</div>
			<div style="height: 10px;"></div>
			<div class="row">
				<div class=" col-md-5">
					<label>Enter your E-mail Id (User Name)</label> <input type="text"
						ng-model="rsCustomerJson.emailId" required="required"
						class="form-control"> <small>Your Username is the
						same as your E-mail ID</small>
				</div>
				<div class="col-md-1"></div>

				<div class=" col-md-5">
					<label>Enter Your Mobile Number</label> <input type="text"
						ng-model="rsCustomerJson.phoneNumber" required="required"
						class="form-control">
				</div>
				<div class="col-md-1"></div>
			</div>
			<div style="height: 10px;"></div>
			<div class="row">
				<div class=" col-md-5">
					<label>Create Your Password</label> <input type="password"
						ng-model="rsCustomerJson.password" required="required"
						class="form-control"> <small>Important: Make sure
						your password is at least 6 characters long.</small>
				</div>
				<div class="col-md-1"></div>

				<div class=" col-md-5">
					<label>Conform Password</label> <input type="password"
						ng-model="rsCustomerJson.confirmPassword" required="required"
						class="form-control">
				</div>
				<div style="height: 20px;"></div>
				<div class="row">
					<div class=" col-md-12">
						<div class=" col-md-6"></div>
						<div class=" col-md-6">
							<input type="submit" class="btn btn-primary" value="REGISTER">
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div style="height: 10px;"></div>
		</form>
	</div>


	<div style="height: 10px;"></div>
	<div
		style="width: 80%; background: #f3f2c5; margin: 2px auto; padding: 5px 10px;">
		<div class="row" ng-click="isAscending = !isAscending">
			<div class=" col-md-5">
				<h4>Customer Account Login</h4>
			</div>
			<div class=" col-md-7" style="text-align: right;">
				<span
					ng-class="isAscending ? 'fa fa-caret-square-o-up color_blue' : 'fa fa-caret-square-o-down color_blue'"></span>
			</div>

		</div>
	</div>
	<div ng-if="isAscending"
		style="width: 80%; margin: 0 auto; margin: -10px auto; border: 1px solid #f3f2c5; padding: 10px; border-top: none;">
		<form ng-submit="loginAction()">
			<div style="height: 10px;"></div>

			<div style="height: 10px;"></div>
			<div class="row">
				<div class=" col-md-5">
					<label>Enter your E-mail Id (User Name)</label> <input type="text"
						ng-model="rsCustomerJson.userName" required="required"
						class="form-control"> <small>Your Username is the
						same as your E-mail ID</small>
				</div>
				<div class="col-md-1"></div>

				<div class=" col-md-5">
					<label>Enter Your Password</label> <input type="password"
						ng-model="rsCustomerJson.password" required="required"
						class="form-control"> <small><a
						data-toggle="modal" data-target="#forgotPassword"> Forgot Your
							Password?</a></small>
				</div>
				<div class="col-md-1"></div>
			</div>

			<div style="height: 10px;"></div>
			<div class="row">
				<div class=" col-md-12"">
					<div class=" col-md-6"></div>
					<div class=" col-md-6">
						<input type="submit" class="btn btn-primary" value="Log in ">
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</form>
	</div>
	<div style="height: 10px;"></div>
</div>


<!-- Modal -->
<div class="modal fade" id="forgotPassword" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Retrieve Your Password</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<p>Please enter your E-mail ID and we will send a link to your
							registered E-mail ID to reset your password.</p>
					</div>
				</div>
				<div class="row">
					<div class=" col-md-12">
						<label>Enter your E-mail Id (User Name)</label> <input type="text"
							class="form-control">

					</div>

				</div>
				<div style="height: 10px;"></div>

			</div>
			<div class="modal-footer">
				<input type="submit" value="GET PASSWORD" class="btn btn-info">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>