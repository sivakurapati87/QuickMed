<div class="container-fluid" style="width: 100%;">
	<div class="row" style="background:;">
		<div class="col-md-12">
			<div class="row"
				style="width: 80%; margin: 0 auto; background: #aaa;">
				<div class="col-md-3"></div>
				<div class="col-md-3"></div>
				<div class="col-md-3"></div>
				<div class="col-md-3" style="text-align: center;">
					<div class="row">
						<div class="col-md-12">
							<div class="row">
								<div class="cartName" ng-if="rsAddedCartItemList.length >0">
									<i class="fa fa-shopping-cart fa-2x"></i> Cart
									<div class="cartItems" style="padding-bottom: 10px;">
										<div class="row" style="margin: 5px 0px;"
											ng-repeat="cartItem in rsAddedCartItemList">
											<div class="col-md-3">
												<img ng-src="{{cartItem.itemImageBase64}}" width="80"
													height="80">
											</div>
											<div class="col-md-3">
												<label class="lable_12">{{cartItem.itemName}}</label>
											</div>
											<div class="col-md-3">
												QTY : <label class="lable_12">{{cartItem.quantity}}</label>
											</div>
											<div class="col-md-3">
												Rs. <label class="lable_12">{{cartItem.subTotal}}</label>
											</div>
										</div>
										<div style="width: 100%">
											<div class="col-md-5">
												<label class="lable16">
													{{rsAddedCartItemList.length}}</label> items in your cart
											</div>
											<div class="col-md-2">Subtotal</div>
											<div class="col-md-5">
												<label class="lable16">Rs.{{totalCost()}}</label>
											</div>
										</div>
										<div style="width: 100%;margin: 10px 0px;">
											<div class="col-md-12">
												<button class="btn btn-success width80"
													ng-click="checkout()">
													PROCEED TO CHECKOUT &nbsp; <i class="fa fa-play"></i>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4" style="margin-bottom: 20px;">
			<img alt="logo" src="resources/images/logo.png" ui-sref="home"
				style="cursor: pointer;">
		</div>
		<div class="col-md-8">
			<ul class="nav1">
				<li ng-repeat="(key,value) in subModules_With_ModuleNamesMap"><a
					href="#" title="{{key}}"> {{key}}</a>
					<div class="div" ng-if="key == 'PRESCRIPTION'">
						<div class="div1 ">
							<h6 style="background: ;height: 30px; padding: 10px; background: #999661; color: #DED9B0; font-weight: 900;">BY CONDITIONS</h6>

							<div class="val" ng-repeat="subModule in value |limitTo:20"
								ng-click="getAllCategoriesWithItemsBySubModuleCode(value[$index].subModuleCode)">
								<span style="cursor: pointer; text-transform: uppercase;">
									<label class="lable_12" style="cursor: pointer;">{{value[$index].subModuleName}}</label>
								</span>
							</div>
							<input type="button" class="btn btn-primary " value="VIEW ALL"
								ng-click="viewAllSubcategoriesOrManufacturers('subCategories',value)"
								style="float: right; margin: 10px;">

						</div>
						<div class="div1">
							<h6 style="height: 30px; padding: 10px; background: #999661; color: #DED9B0; font-weight: 900;">BY MANUFACTURER</h6>

							<div class="val "
								ng-repeat="manufacturer in manufacturerList |limitTo:15"
								ng-click="getACategoryWithItemsByManufacturerName(manufacturer.manufacturerName)">
								<span style="cursor: pointer; text-transform: capitalize;">
									<label class="lable_12" style="cursor: pointer;">{{manufacturer.manufacturerName}}</label>
								</span>
							</div>
							<input type="button" class="btn btn-primary " value="VIEW ALL"
								ng-click="viewAllSubcategoriesOrManufacturers('manufacturers',manufacturerList)"
								style="float: right; margin: 10px;">

						</div>
					</div>


					<div class="div" ng-if="key != 'PRESCRIPTION'">
						<div class="div1">
							<div class="val " ng-repeat="subModule in value">
								<span style="cursor: pointer; text-transform: uppercase;"
									ng-click="getAllCategoriesWithItemsBySubModuleCode(value[$index].subModuleCode)">
									<label class="lable_12">{{value[$index].subModuleName}}</label>
								</span>
							</div>
						</div>

					</div></li>


			</ul>
		</div>
	</div>

	<div style="height: 20px;"></div>

	<div class="row"
		style="background: url('resources/images/background.png'); height: auto;"
		ng-if="rsPageName != 'home'">
		<div class="col-md-12">
			<div class="row searchbg_bg_image"
				style="background: #edeab1; margin-bottom: 30px; padding-bottom: 30px;">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-9">
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-12">
									<label class="lable_blue_24">Search from thousands of
										products available on quickmeds</label>
								</div>
							</div>
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-9">

									<div angucomplete-alt id="searchProductId"
										input-class="form-control height40"
										placeholder="Type your product name here.." pause="100"
										selected-object="selectedProductAction"
										search-fields="searchItemName" title-field="searchItemName"
										minlength="3"
										remote-url="http://localhost:8080/QuickMedService/ItemController/searchProduct/"
										match-class="highlight"></div>
								</div>
								<div class="col-md-3">
									<button type="button" class="btn btn-info"
										ng-click="onclickSearchAction()"
										style="width: 100%; height: 40px;">Search</button>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-12">
									<label class="lable_blue_24">Upload Prescription</label>
								</div>
							</div>
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-8">
									<button type="button" class="btn btn-info"
										style="width: 100%; height: 40px;">Upload</button>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
</div>