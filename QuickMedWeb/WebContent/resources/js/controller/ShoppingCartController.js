'use strict';

App.controller('ShoppingCartController', ['$scope','$http','$rootScope','$state','$location', function($scope,$http,$rootScope,$state,$location) {
	$rootScope.rsPageName = "checkout";
	 $location.hash('shopping_cartDivId');
	
	//onchange quantity combo box in the checkout table
	$scope.onChangeQuantityCombo = function(cartItem){
		angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
			if(obj.itemId == cartItem.itemId)
			{
				angular.forEach(cartItem.comboJsonList, function(comboObj, comboKey)
				{
					if(comboObj.value == obj.quantity){
						obj.price =  comboObj.actualPrice;
						obj.subTotal = comboObj.offerPrice;
						obj.discount = obj.price - obj.subTotal;
						
						//limiting to 2 decimals
						obj.price = Math.round(obj.price * 100) / 100;
						obj.subTotal = Math.round(obj.subTotal * 100) / 100;
						obj.discount = Math.round(obj.discount * 100) / 100;
					}
				});
			}
		});
	};
	
	//find the sum of all sub costs
    $scope.findTotalSubCost = function(){
  	  if($rootScope.rsAddedCartItemList){
  		  $scope.totalSubCost = 0;
  	  angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
  		  $scope.totalSubCost += obj.subTotal;
		}); 
  	  $scope.totalSubCost = Math.round($scope.totalSubCost * 100) / 100;
  	  return $scope.totalSubCost;
  	  }
    };
    
  //find the sum of all discounts
    $scope.findTotalDiscount = function(){
  	  if($rootScope.rsAddedCartItemList){
  		  $scope.totalDiscount = 0;
  	  angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
  		  $scope.totalDiscount += obj.discount;
		}); 
  	  $scope.totalDiscount = Math.round($scope.totalDiscount * 100) / 100;
  	  return $scope.totalDiscount;
  	  }
    };
    
    $scope.removeItemFromCart = function(itemId){
    	var i=0,itemLocation=null;
    	angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
    		
			if(obj.itemId == itemId)
			{
				itemLocation = i;
			}
			i++;
		});
    	if(itemLocation >=0){
    		if($rootScope.rsAddedCartItemList){
    			$rootScope.rsAddedCartItemList.splice(itemLocation,1);
    		}
    	}
    };
    
    //find the total order amount
    $scope.findTotalOrderAmount = function(){
    	 return $scope.findTotalSubCost()+49;
    }
}]);