<div class=" width80 align_center margin_top30"
		ng-if="productList.length > 0">
		<div class="col-md-12">
			<div class="row" style=" background:#868548;  max-height:80px; height:auto;  display: block;"><!-- pages -->
				<div class="col-md-9 float_l">
					<ul class="pagination">
						<li ng-repeat="page in pages" ng-class="{'active':(page.recordOffset===pageNo)}"><a style="cursor: pointer;" ng-click="nextPageRecords(page.recordOffset)">{{page.number}}</a></li>
					</ul>
				</div>
				<div class="col-md-3 float_l" style="margin-top: 0px; background: #aaa; float: right;">
					<label class="lable_yellow_16">No of records : {{noOfRecords}}</label>
					<br>
					<label class="lable_yellow_14">Records in this page : {{productList.length}}</label>
				</div>
			</div><!--// pages -->
			<div class="clear"></div>
			
			<div class="row show1 "  style="background: #a3a92e;"  >
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
			<div class="row show1" ng-repeat="product in productList"
				ng-click="displayItemInfo(product)" style="cursor: pointer;"
				ng-class-odd="'odd'" ng-class-even="'even'">
				<div class="col-md-4">
					<label class="lable16">{{product.itemName}}</label>
				</div>
				<div class="col-md-4">
					<label class="lable16">{{product.comboJsonList[0].offerPrice}}</label>
				</div>
				<div class="col-md-4">
					<label class="lable16">{{product.manufacturerName}}</label>
				</div>
			</div>
			<!-- for mobile mobile -->
			<div class="row show2" ng-repeat="product in productList"
				ng-click="displayItemInfo(product)" style="cursor: pointer;"
				ng-class-odd="'odd'" ng-class-even="'even'">
				<div class="row">
					<div class="col-md-4 float_l"><label class="label_bold_18">Name</label></div>
					<div class="col-md-8 float_l"><label class="lable16">{{product.itemName}}</label></div>
				</div>
				<div class="row">
					<div class="col-md-4 float_l"><label class="label_bold_18">Price</label></div>
					<div class="col-md-8 float_l"><label class="lable16">{{product.comboJsonList[0].offerPrice}}</label></div>
				</div>
				<div class="row">
					<div class="col-md-4 float_l"><label class="label_bold_18">Manufacturer</label></div>
					<div class="col-md-8 float_l"><label class="lable16">{{product.manufacturerName}}</label></div>
				</div>
				
			</div><!-- for mobile mobile -->
			
			
			<div class=" row " style=" background: #868548;  max-height:80px; height:auto; display: block;"><!-- pages -->
				<div class="col-md-9 float_l">
					<ul class="pagination">
						<li ng-repeat="page in pages" ng-class="{'active':(page.recordOffset===pageNo)}"><a style="cursor: pointer;" ng-click="nextPageRecords(page.recordOffset)">{{page.number}}</a></li>
					</ul>
				</div>
				
			</div><!--// pages -->
			
			
			
			
			
			
			
			
		</div>
	</div>