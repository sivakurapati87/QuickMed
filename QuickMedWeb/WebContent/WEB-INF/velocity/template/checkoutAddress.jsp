<div class="container-fluid" style="background: white; width: 100%;" id="checkoutAddressDivId">
	<div class="row align_center" style="width: 80%; margin-top: 20px;">
		<div class="col-md-12">
			<!--// pages -->
			<div class="clear"></div>
			<form ng-submit="saveCheckoutAddress()">
				<div class="row checkoutBg">
					<div class="col-md-12">
						<div class="row bg_green height32">
							<div class="col-md-12 label_bold_18">
								<label>Personal Information & Billing Address</label>
							</div>
						</div>
						<div style="margin-top: 20px;"></div>
						<div class="row">
							<div class="col-md-5">
								<div class="row">
									<div class="col-md-12">
										<label> Your First Name*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="text" class="form-control" required="required"
											ng-model="rsCustomerJson.firstName" placeholder="First Name">
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>Your Last Name*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="text" class="form-control" required="required"
											ng-model="rsCustomerJson.lastName" placeholder="Last Name">
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>Gender*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<select
											class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
											required ng-model="rsCustomerJson.gender"
											ng-options="gender.value as gender.value for gender in  genderList">
											<option value="" disabled selected>Select</option>
										</select>
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>Date of Birth*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="input-group">
											<input type="text" class="form-control" required="required"
												ng-model="rsCustomerJson.strDateOfBirth"
												datepicker-popup="dd-MMM-yyyy" is-open="Opened"
												ng-click="Opened=true"> <span
												class="input-group-btn">
												<button type="button" class="btn btn-default"
													ng-click="Opened=true;$event.stopPropagation();">
													<i class="glyphicon glyphicon-calendar"></i>
												</button>
											</span>
										</div>
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>Mobile Number*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="text" class="form-control" required="required"
											ng-model="rsCustomerJson.phoneNumber"
											placeholder="Mobile Number">
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>E-mail ID*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="text" class="form-control" required="required"
											ng-model="rsCustomerJson.emailId" placeholder="E-mail ID">
									</div>
								</div>
								<div style="margin-bottom: 20px;"></div>
							</div>
							<div class="col-md-2"></div>


							<div class="col-md-5">
								<div class="row">
									<div class="col-md-12">
										<label>Pincode*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="text" class="form-control" required="required"
											ng-model="rsCustomerJson.customerDeliveryAddressJson.pincode"
											placeholder="Pincode" maxlength="6">
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>Address*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<textarea id="description" class="form-control" rows="4"
											style="resize: none;"
											ng-model="rsCustomerJson.customerDeliveryAddressJson.address"></textarea>
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>City*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<input type="text" class="form-control" required="required"
											ng-model="rsCustomerJson.customerDeliveryAddressJson.city"
											placeholder="City">
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>State*</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div angucomplete-alt id="searchStateId"
											input-class="form-control height40"
											placeholder="Type your product name here.." pause="100"
											selected-object="selectedStateAction" search-fields="description"
											title-field="description" minlength="3"
											initial-value="stateObj"
											remote-url="http://localhost:8080/QuickMedService/LookUpController/searchState/"
											match-class="highlight"></div>
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-12">
										<label>Country</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<label>India (Delivery within India ONLY)</label>
									</div>
								</div>
								<div style="height: 10px"></div>
								<div class="row">
									<div class="col-md-8">
										<button type="submit" class="btn btn-success width80">SAVE
											DELIVERY ADDRESS</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>