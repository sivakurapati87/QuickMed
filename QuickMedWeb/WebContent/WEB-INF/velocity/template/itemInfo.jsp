<div class="container-fluid" style="background: white; width: 100%;"
	id="itemInfoDivId">
	<div class="row searchbg_bg_image" style="background: #edeab1;">
		<div class="col-md-12" style="margin-top: 20px; margin-bottom: 20px;">
			<div class="row">
				<div class="col-md-2">
					<img ng-src="{{itemInfoObj.itemImageBase64}}" width="100" height="100">
				</div>
				<div class="col-md-3">
					<div class="row">
						<div class="col-md-12">
							<label class="lable16"> {{itemInfoObj.itemName}} </label>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<label class="lable16"><i
								class="fa fa-exclamation-triangle" style="color: red;"></i>
								prescription needed </label>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<label class="lable16"> <i class="fa fa-building fa-2x"></i>{{itemInfoObj.manufacturerName}}
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-2" style="margin-top: 30px;">
					<label class="label_bold_16" ng-if="actualPrice != offerPrice">
						Rs. {{offerPrice}}</label> <br> <label class="label_bold_16"
						ng-if="actualPrice != offerPrice"
						style="text-decoration: line-through;"> Rs.
						{{actualPrice}}</label> <label class="label_bold_16"
						ng-if="actualPrice == offerPrice"> Rs. {{actualPrice}}</label>
				</div>
				<div class="col-md-3">
					<!-- <div class="row" style="margin-bottom: 20px;">
						<div class="col-md-12">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Enter your pincode">
								<div class="input-group-addon">Go</div>
							</div>
						</div>
					</div> -->
					<div class="row">
						<div class="col-md-12">
							<label class="lable_14">SELECT QUANTITY</label>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
								ng-model="itemInfoObj.selectedComboJson"
								ng-change="onChangeQuantityCombo()"
								ng-options="combo.value as combo.description for combo in  itemInfoObj.comboJsonList">
							</select>
						</div>
					</div>
					<div class="row" style="margin-bottom: 40px;">
						<div class="col-md-12">
							<label class="lable_red_16" ng-if="isQuantityExceeded">Exceeded
								the maximum quantity limit per order!</label>
						</div>
					</div>
				</div>
				<div class="col-md-2" style="margin-top: 20px;">

					<div class="row">
						<div class="col-md-12">
							<button class="fa fa-shopping-cart btn btn-success width80"
								ng-click="addToCart()">&nbsp; Add to cart</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>







	<div style="height: 20px;"></div>
	<div class="row" style="width: 80%;margin: 0 auto;">
		<div class="row show1 " style="background: #a3a92e;">
			<div class="col-md-4">
				<label class="label_bold_18">Name</label>
			</div>
			<div class="col-md-4">
				<label class="label_bold_18">Price</label>
			</div>
			<div class="col-md-4">
				<label class="label_bold_18">Manufacturer</label>
			</div>
		</div>
		<div class="row show1" ng-repeat="product in similarPrescriptionsList"
			ng-click="displayItemInfo(product)" style="cursor: pointer;"
			ng-class-odd="'odd'" ng-class-even="'even'">
			<div class="col-md-4">
				<label class="lable16" style="cursor: pointer;">{{product.itemName}}</label>
			</div>
			<div class="col-md-4">
				<label class="lable16"  style="cursor: pointer;">{{product.comboJsonList[0].offerPrice}}</label>
			</div>
			<div class="col-md-4">
				<label class="lable16"  style="cursor: pointer;">{{product.manufacturerName}}</label>
			</div>
		</div>
		<!-- for mobile mobile -->
		<div class="row show2" ng-repeat="product in similarPrescriptionsList"
			ng-click="displayItemInfo(product)" style="cursor: pointer;"
			ng-class-odd="'odd'" ng-class-even="'even'">
			<div class="row">
				<div class="col-md-4 float_l">
					<label class="label_bold_18">Name</label>
				</div>
				<div class="col-md-8 float_l">
					<label class="lable16">{{product.itemName}}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 float_l">
					<label class="label_bold_18">Price</label>
				</div>
				<div class="col-md-8 float_l">
					<label class="lable16">{{product.comboJsonList[0].offerPrice}}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 float_l">
					<label class="label_bold_18">Manufacturer</label>
				</div>
				<div class="col-md-8 float_l">
					<label class="lable16">{{product.manufacturerName}}</label>
				</div>
			</div>

		</div>
		<!-- for mobile mobile -->
	</div>
</div>