'use strict';

App.controller('CheckoutController', ['$scope','$http','$rootScope','$state',"$location", function($scope,$http,$rootScope,$state,$location) {
	$rootScope.rsPageName = "checkout";
	$location.hash('checkOutDivId');
	
	/*//onchange quantity combo box in the checkout table
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
	};*/
	
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
    
    /*  //To get the gender combo
    $scope.getGenderCombo = function(){
		$scope.genderList = [{}];
		$scope.genderList.splice(0,1);
		var genders = ["Male","Female","Other"]
		
		for(var i=0;i<genders.length;i++){
			var obj = {};
			obj.value = genders[i];
			$scope.genderList.push(obj);
		}
    };*/
    
    //To perfomr cash on delivery
    $scope.cashOnDeliveryAction = function(){
    	angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
    		obj.customerId = $rootScope.rsCustomerJson.customerId;
    		obj.comment = $scope.comment;
  		});
    	$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.AddToCartController+'/placeCashOnDeliveryOrders',$rootScope.rsAddedCartItemList).success(function(data) {
			$rootScope.rsAddedCartItemList = null;
			$rootScope.rsCustomerJson.customerDeliveryAddressJson.totalOrderId = data;
			$scope.saveCustomerDeliverAddress();
		}).error(function() {
      	  console.error('Could not perform registration action');
        });
    };
    
 $scope.saveCustomerDeliverAddress = function(){
    	$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomerController+'/placeCustomerDeliverAddress',$rootScope.rsCustomerJson).success(function(data) {
//			$rootScope.rsAddedCartItemList = null;
    		if(data){
    			$state.go("home");
    		}
		}).error(function() {
      	  console.error('Could not save Customer Deliver Address');
        });
    } 
    
    //find the total order amount
    $scope.findTotalOrderAmount = function(){
    	 return $scope.findTotalSubCost()+49;
    }
   
    //init
   // $scope.getGenderCombo();
	
//	  $scope.saveCheckOutItems = function(){
//	    	$http.post(constants.localhost_port+"/"+constants.web_context+'/'+constants.CheckoutItemController+'/saveCheckOutItems',$rootScope.rsAddedCartItemList).success(function(data) {
//			}).error(function() {
//	      	  console.error('Could not save Customer Checkout Items');
//	        });
//	    }
//	  
	  //To save checkout items
//	$scope.saveCheckOutItems();
	
}]);