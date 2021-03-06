<style>
ul li a {
	color: #eee;
}

ul li a:hover {
	color: #fff;
}
</style>

<div class="container-fluid" style="width: 100%; text-align: center;">
	<div class="row"
		style="background: #C7C29E; color: #eee; margin-top: 20px; padding-bottom: 10px;">

		<div class="col-md-12" style="text-align: left;">
			<div class="row" style="width: 80%; margin: 10px auto;">
				<div class="col-md-3" style="text-align: left;">
					<h5 style="">
						<b>COMPANY INFORMATION</b>
					</h5>

					<ul
						style="list-style: none; text-align: left; margin: 0px; padding: 0px;">
						<li>About Quickmed</li>
						<li>Customers Speak</li>
						<li>In the News</li>
						<li>FAQs</li>
						<li>Quickmed Reward Points</li>
						<li>Terms and Conditions</li>
						<li>Privacy Policy</li>
						<li>Contact Us</li>
					</ul>

				</div>
				<div class="col-md-3" style="text-align: left;">
					<h5 style="">
						<b>SHOP @ QUICKMED</b>
					</h5>
					<ul
						style="list-style: none; text-align: left; margin: 0px; padding: 0px;">
						<li>Shop by Condition/Category</li>
						<li>Shop by Manufacturer</li>
						<li>Shop Over-the-Counter items</li>
						<li>Upload Prescription</li>
						<li>Offers</li>
						<li>Refunds</li>
					</ul>
				</div>
				<div class="col-md-3" style="text-align: left;">
					<h5 style="">
						<b>YOUR QUICKMED ACCOUNT</b>
					</h5>
					<ul
						style="list-style: none; text-align: left; margin: 0px; padding: 0px;">
						<li><a ui-sref="account" ng-if="!rsCustomerJson.customerId">Register/Account Login</a></li>
						<li>Track Your Order</li>
						<li>Check Your Reward Points</li>
						<li>Manage Your e-Wallet</li>
						<li>Review & Rate Items</li>
					</ul>
				</div>
				<div class="col-md-3" style="text-align: left;">
					<h5 style="">
						<b>e-NEWSLETTER SIGN UP</b>
					</h5>

					Sign up to our eNewsletter to receive email updates on our upcoming
					promotions, special discount offers, health information, latest
					products, events and a lot more!
				</div>
			</div>

		</div>

	</div>
	<div class="row"
		style="background: #A6A284; color: #eee; padding-bottom: 10px;">

		<div class="col-md-12">
			<div class=" row" class="" style="width: 80%; margin: 10px auto;">
				<div class="col-md-6">

					<div class="row" style="text-align: left;">
						<div class="col-md-12" style="text-align: left;">
							<h5 style="">
								<b>FOLLOW US</b>
							</h5>
						</div>

						<div class="col-md-12" style="text-align: left;">
							<div class="col-md-3 icon">
								<i class="fa fa-facebook"></i>
							</div>
							<div style="" class="col-md-3 icon">
								<i class="fa fa-youtube"></i>
							</div>
							<div style="" class="col-md-3 icon">
								<i class="fa fa-twitter"></i>
							</div>
							<div style="" class="col-md-3 icon">
								<i class="fa fa-google-plus"></i>
							</div>
						</div>
					</div>
				</div>


				<div class="col-md-6">
					<div class="row">
						<div class="col-md-12" style="text-align: left;">
							<h5 style="">
								<b>PAYMENT OPTIONS</b>
							</h5>
						</div>
						<div class="col-md-12" style="text-align: left;">
							<div style="" class="icon1"></div>
							<div style="" class="icon1"></div>
							<div style="" class="icon1"></div>
							<div style="" class="icon1"></div>
							<div style="" class="icon1"></div>
							<div style="" class="icon1"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row"
		style="background: #949175; color: #eee; padding-bottom: 10px;">

		<div class="col-md-12">
			<div class="" style="width: 80%; margin: 10px auto;">
				<div class="col-md-12" style="text-align: center;">
					<div style="padding: 5px; background:;">
						<h3 style="display: inline-block;">PRODUCT CATEGORIES</h3>
					</div>
				</div>
			</div>
			<div class="" style="width: 80%; margin: 10px auto;">
				<div class="col-md-9"
					style="-webkit-columns: 200px; -moz-columns: 200px; columns: 200px; -webkit-column-gap: 10px; -moz-column-gap: 10px; column-gap: 10px; text-align: left;">

					<h4
						style="-webkit-column-span: all; -moz-column-span: all; column-span: all;">PRESCRIPTION
						DRUGS</h4>
					<ul
						style="list-style: none; text-align: left; margin: 0px; padding: 0px;" ng-repeat="(key,value) in subModules_With_ModuleNamesMap">
						<li ng-repeat="subModule in value |limitTo:20"
								ng-click="getAllCategoriesWithItemsBySubModuleCode(value[$index].subModuleCode)" ng-if="key == 'PRESCRIPTION'">
								<span style="cursor: pointer; ">
									{{value[$index].subModuleName}}
								</span>
							</li>

					</ul>

				</div>

				<div class="col-md-3" style="background:;">
					<h4 style="text-align: left;">NON-PRESCRIPTIONS</h4>
					<ul
						style="list-style: none; text-align: left; margin: 0px; padding: 0px;">
						<li>NON-PRESCRIPTIONS</li>
						<li>OTC</li>
						<li>Diabetes</li>
						<li>Baby & Mother</li>
						<li>Personal Care</li>
						<li>Wellness</li>
						<li>Household</li>
					</ul>
				</div>

			</div>
		</div>

	</div>
</div>


<table cellpadding="0" cellspacing="0" border="0" width="100%"
	class="footerPosition">
	<tr class="footerBgColor">


		<td style="height: 80px;" class="intro_text lable14" align="center">�
			2016 Quickmeds. All Rights Reserved. Designed by <a
			href="http://intuiture.com/"
			style="color: #ff5b5b; cursor: pointer; text-decoration: none; font-weight: bold;">Intuiture.Com</a>



		
		</td>



	</tr>
</table>
