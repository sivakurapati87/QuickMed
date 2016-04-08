<div class="category_main_div" id="categoriesDivId">

<!-- <input ng-model="model.itemName" /> -->
<!-- | filter : { itemName : model.itemName} -->
		
	  <ul class="example" >
  		<li class="li" ng-repeat="(key,value) in itemWithCategoryMap" >
  				<h5 class="label_bold_18" style="line-height: 2px">{{key}}</h5>
				<h6 ng-repeat="item in value" class="lable16" style="cursor: pointer;" ng-click="displayItemInfo(item)">{{item.itemName}} </h6>
		 </li>
  
	</ul>  

</div>

