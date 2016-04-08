'use strict';

App.controller('HeaderController', ['$scope','$http','$rootScope','$state','Base64', function($scope,$http,$rootScope,$state,Base64) {
	
		// get module names with all sub modules
		$scope.getAllSubModulesWithModuleNameMap = function(){
			if(!$rootScope.subModules_With_ModuleNamesMap){
				 $http.defaults.headers.common['Authorization'] = 'Basic ' + Base64.encode('siva' + ':' + 'kurapati');
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.SubModuleController+'/getAllSubModulesWithModuleNameMap').success(function(data) {
				$rootScope.subModules_With_ModuleNamesMap = data;
				$scope.getAllManufacturers();
			}).error(function() {
	      	  console.error('Could not get All SubModules With Module Names Map');
	        });}
		};

		$scope.getAllManufacturers = function(){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getAllManufacturers').success(function(data) {
				$rootScope.manufacturerList = data;
			}).error(function() {
	      	  console.error('Could not get All Manufacturer List');
	        });
		};
		
		
		// get module names with all sub modules
		$scope.getAllCategoriesWithItemsBySubModuleCode = function(subModuleCode){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getAllCategoriesWithItemsBySubModuleCode/'+subModuleCode).success(function(data) {
				$rootScope.itemWithCategoryMap = data;
				$state.go("category");
//				$state.reload();//To reload the current state
			}).error(function() {
	      	  console.error('Could not get All Categories With Items By SubModule Code');
	        });
		};
		
		// get all categories with corresponding items map by manufacturer name
		$scope.getACategoryWithItemsByManufacturerName = function(manufacturer){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getACategoryWithItemsByManufacturerName/'+manufacturer).success(function(data) {
				$rootScope.itemWithCategoryMap = data;
				$state.go("category");
			}).error(function() {
	      	  console.error('Could not get A Category With Items By Manufacturer Name');
	        });
		};

		
		//getting the selected product name from auto complete
	    $scope.selectedProductAction = function(selected) {
	        if (selected) {
	        	$rootScope.selectedProduct = selected.description.itemName;
	        } else {
	          console.log('error at selected Product Action');
	        }
	      };
		

	    //when we click on search button
	      $scope.onclickSearchAction = function(){
	    	  if($rootScope.selectedProduct){
	    		 $state.go('searchItems', {}, {reload : true});
	    	  }
	      };
		
	      //when we click on view all button
	      $scope.viewAllSubcategoriesOrManufacturers = function(type,list){
	    	  $rootScope.viewAllSubCategoryOrManufacturerList = list;
	    	  if(type == 'subCategories'){
	    		 $rootScope.rsIsSubCategory = true;
	    	  }else{
	    		  $rootScope.rsIsSubCategory = false;
	    	  }
	    	  $state.go('viewAllSubCategoryOrManufacturers', {}, {reload : true});
	      }
	      
	      
	      //find the sum of all the items
	      $scope.totalCost = function(){
	    	  if($rootScope.rsAddedCartItemList){
	    		  $rootScope.totalAmount = 0;
	    	  angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
	    		  $rootScope.totalAmount += obj.subTotal;
	  		}); 
	    	  $rootScope.totalAmount = Math.round($rootScope.totalAmount * 100) / 100;
	    	  return $rootScope.totalAmount;
	    	  }
	      };
	      
	      //checkout action
	      $scope.checkout = function(){
	    	  if($rootScope.rsCustomerJson){
	    		  $state.go("shopping_cart");
	    	  }else{
	    		  $state.go("account");
	    	  }
	      };
		
          //init
		$scope.getAllSubModulesWithModuleNameMap();
          
}]);
