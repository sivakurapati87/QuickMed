<div class="container-fluid" style="background: white; width: 100%;" id="itemInfoDivId">
	<div class="row searchbg_bg_image" style="background: #edeab1;">
		<div class="col-md-12" style="margin-top: 20px; margin-bottom: 20px;">
			<div class="row">
				<div class="col-md-2">
					<img ng-src="{{itemInfoObj.itemImageBase64}}">
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
	<!-- <div class="row searchbg_bg_image" style="background: #edeab1;">
		<div class="col-md-12" style="margin-top: 20px; margin-bottom: 20px;">
			{{rsAddedCartItemList}}</div>
	</div> -->
</div>