<div class="category_main_div">



	<ul class="subCategory_Manufacturer" ng-if="rsIsSubCategory">
		<li class="li"
			ng-repeat="item in viewAllSubCategoryOrManufacturerList"><label
			class="lable_Copper_16" style="cursor: pointer;"
			ng-click="getAllCategoriesWithItemsBySubModuleCode(item.subModuleCode)">{{item.subModuleName}}</label>
		</li>
	</ul>

	<ul class="subCategory_Manufacturer" ng-if="!rsIsSubCategory">
		<li class="li"
			ng-repeat="item in viewAllSubCategoryOrManufacturerList"><label
			class="lable_Copper_16" style="cursor: pointer;"
			ng-click="getACategoryWithItemsByManufacturerName(item.manufacturerName)">{{item.manufacturerName}}</label>
		</li>
	</ul>
</div>
