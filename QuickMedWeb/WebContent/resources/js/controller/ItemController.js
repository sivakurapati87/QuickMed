'use strict';

App.controller('ItemController', ['$scope','$http','$rootScope','$state','$location', function($scope,$http,$rootScope,$state,$location) {
	$scope.isProcessing = true;
	$rootScope.rsPageName = "item";
	$scope.isQuantityExceeded = false;
	 $location.hash('itemInfoDivId');
	
	$scope.onChangeQuantityCombo = function(){
		angular.forEach($rootScope.itemInfoObj.comboJsonList, function(obj, key)
		{
			if(obj.value == $rootScope.itemInfoObj.selectedComboJson){
				$scope.actualPrice = obj.actualPrice;
				$scope.offerPrice = obj.offerPrice;
			}
		});
	};
	
	$scope.getSimilarPrescriptions = function(){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getAllSimilarItems/'+$rootScope.itemInfoObj.chemicalIngradient).success(function(data) {
			$scope.similarPrescriptionsList = data;
		}).error(function() {
      	  console.error('Could not get All Manufacturer List');
        });
	};
	
	
	 //Display item info
    $scope.displayItemInfo = function(item){
		$rootScope.itemInfoObj = item;
		$state.go('itemInfo', {}, {reload : true});
	};
	
	$scope.init = function(){
		if($rootScope.itemInfoObj){
		$rootScope.itemInfoObj.selectedComboJson =  $rootScope.itemInfoObj.comboJsonList[0].value;
		$scope.actualPrice = $rootScope.itemInfoObj.comboJsonList[0].actualPrice;
		$scope.offerPrice = $rootScope.itemInfoObj.comboJsonList[0].offerPrice;
		$scope.getSimilarPrescriptions();
		}
	};
	
	//Add to cart
	$scope.addToCart = function(){
		if(!$rootScope.rsAddedCartItemList){
		$rootScope.rsAddedCartItemList = [{}];
		$rootScope.rsAddedCartItemList.splice(0,1);
		}
		var isItemExists = false;
		angular.forEach($rootScope.rsAddedCartItemList, function(obj, key) {
			if(obj.itemId == $rootScope.itemInfoObj.itemId)
			{
				isItemExists = true;
				//If quantity is more than 10
				if((obj.quantity + $rootScope.itemInfoObj.selectedComboJson)>10){
					$scope.isQuantityExceeded = true;
				}else{
				$scope.isQuantityExceeded = false;
				obj.quantity += $rootScope.itemInfoObj.selectedComboJson;
				obj.price +=  $scope.actualPrice;
				obj.subTotal += $scope.offerPrice;
				obj.discount = obj.price - obj.subTotal;
				
				//limiting to 2 decimals
				obj.price = Math.round(obj.price * 100) / 100;
				obj.subTotal = Math.round(obj.subTotal * 100) / 100;
				obj.discount = Math.round(obj.discount * 100) / 100;
				}
			}
		});
		if(!isItemExists){
			var obj={};
			obj.itemId = $rootScope.itemInfoObj.itemId;
			obj.quantity = $rootScope.itemInfoObj.selectedComboJson;
			obj.price = $scope.actualPrice;
			obj.subTotal = $scope.offerPrice;
			obj.discount = obj.price - obj.subTotal;
			obj.itemImageBase64 = $rootScope.itemInfoObj.itemImageBase64;
			obj.itemName = $rootScope.itemInfoObj.itemName;
			obj.comboJsonList = $rootScope.itemInfoObj.comboJsonList;
			
			//limiting to 2 decimals
			obj.price = Math.round(obj.price * 100) / 100;
			obj.subTotal = Math.round(obj.subTotal * 100) / 100;
			obj.discount = Math.round(obj.discount * 100) / 100;
			$rootScope.rsAddedCartItemList.push(obj);
		}
	};
	
	
	//init
	$scope.init();
}]);
