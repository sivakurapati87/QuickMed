<div class="container-fluid" style="background: white; width: 100%;" id="checkOutDivId">
	<div class="row checkoutBg align_center"
		style="width: 80%; margin-top: 20px;">
		<div class="col-md-12">

			<div class="row bg_green height32">
				<div class="col-md-12 label_bold_18">
					<label>Review Your Order</label>
				</div>
			</div>
			<div style="height: 10px"></div>
			<!--// pages -->
			<div class="clear"></div>

			<div class="row show1 checkoutReview_width"
				style="background: #a3a92e;">
				<div class="col-md-3">
					<label class="label_bold_18">Medicine/Product Name</label>
				</div>
				<div class="col-md-3">
					<label class="label_bold_18">Quantity</label>
				</div>
				<div class="col-md-3">
					<label class="label_bold_18">Amount (Rs.)</label>
				</div>
				<div class="col-md-3">
					<label class="label_bold_18">Discount (Rs.)</label>
				</div>
			</div>
			<div class="row show1 checkoutReview_width"
				ng-repeat="cartItem in rsAddedCartItemList" ng-class-odd="'odd'"
				ng-class-even="'even'">
				<div class="col-md-3">
					<label class="lable16">{{cartItem.itemName}}</label>
				</div>
				<div class="col-md-3">
					<select
						class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
						ng-model="cartItem.quantity"
						ng-change="onChangeQuantityCombo(cartItem)"
						ng-options="combo.value as combo.description for combo in  cartItem.comboJsonList">
					</select>
				</div>
				<div class="col-md-3">
					<label class="label_bold_16"
						ng-if="cartItem.price != cartItem.subTotal"
						style="text-decoration: line-through;"> Rs.
						{{cartItem.price}}</label> <label class="label_bold_16"
						ng-if="actualPrice == offerPrice"> Rs.
						{{cartItem.subTotal}}</label>
				</div>
				<div class="col-md-3">
					<label class="lable16">{{cartItem.discount}}</label>
				</div>
			</div>
			<!-- for mobile mobile -->
			<div class="row show2 checkoutReview_width"
				ng-repeat="cartItem in rsAddedCartItemList" ng-class-odd="'odd'"
				ng-class-even="'even'">
				<div class="row">
					<div class="col-md-3 float_l">
						<label class="label_bold_18">Medicine/Product Name</label>
					</div>
					<div class="col-md-9 float_l">
						<label class="lable16">{{cartItem.itemName}}</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 float_l">
						<label class="label_bold_18">Quantity</label>
					</div>
					<div class="col-md-9 float_l">
						<select
							class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
							ng-model="cartItem.quantity"
							ng-change="onChangeQuantityCombo(cartItem)"
							ng-options="combo.value as combo.description for combo in  cartItem.comboJsonList">
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 float_l">
						<label class="label_bold_18">Amount (Rs.)</label>
					</div>
					<div class="col-md-9 float_l">
						<label class="label_bold_16"
							ng-if="cartItem.price != cartItem.subTotal"
							style="text-decoration: line-through;"> Rs.
							{{cartItem.price}}</label> <label class="label_bold_16"
							ng-if="actualPrice == offerPrice"> Rs.
							{{cartItem.subTotal}}</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 float_l">
						<label class="label_bold_18">Discount (Rs.)</label>
					</div>
					<div class="col-md-9 float_l">
						<label class="lable16">{{cartItem.discount}}</label>
					</div>
				</div>

			</div>
			<div style="height: 20px"></div>
			<!-- 		for all -->
			<div class="row">
				<div class="col-md-7">
					<label class="lable16 align_right">Subtotal (Rs.)</label>
				</div>
				<div class="col-md-2">{{findTotalSubCost()}}</div>
				<div class="col-md-3">
					<label class="lable16">{{findTotalDiscount()}}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-7">
					<label class="lable16 align_right">Shipping Charges (Rs.)</label>
				</div>
				<div class="col-md-5">49.00</div>
			</div>

			<div class="row">
				<div class="col-md-7">
					<label class="lable16 align_right">Order Total (Rs.)*</label>
				</div>
				<div class="col-md-5">{{findTotalOrderAmount()}}</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<label class="lable16 align_right">You Saved Rs.
						{{findTotalDiscount()}}(Discount)</label>
				</div>
				<div class="col-md-4"></div>
			</div>

			<div class="row" style="margin-bottom: 20px;">
				<div class="col-md-4">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Enter Promo code">
						<div class="input-group-addon">Apply</div>
					</div>
				</div>
			</div>

		</div>
	</div>



	<div class="row checkoutBg align_center"
		style="width: 80%; margin-top: 20px;">
		<div class="col-md-12">

			<div class="row bg_green height32">
				<div class="col-md-12 label_bold_18">
					<label>Select Your Payment Method</label>
				</div>
			</div>
			<div style="height: 10px"></div>
			<div class="row">
				<div class="col-md-5">
					<button class="btn btn-success width80" ng-click="cashOnDeliveryAction()">
						Cash On Delivery &nbsp; <i class="fa fa-caret-right fa-lg"></i>
					</button>
				</div>
			</div>
			<div style="height: 10px"></div>
		</div>
	</div>

	<div class="row align_center" style="width: 80%; margin-top: 20px;">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<label>Notes and special requests (Optional)</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<textarea id="description" class="form-control" rows="4"
						style="resize: none;" ng-model="comment"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="width: 80%; margin-top: 20px;">
		<div class="col-md-9"></div>
		<div class="col-md-3">
			<button class="btn btn-success width80" ui-sref="checkout">
				PAY NOW &nbsp; <i class="fa fa-caret-right fa-lg"></i>
			</button>
		</div>
	</div>
</div>