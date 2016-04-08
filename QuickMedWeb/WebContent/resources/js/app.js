'use strict';

var App = angular.module('myApp',['ui.router','ui.bootstrap',"angucomplete-alt","ngGrid","ImageCropper","nvd3","jkuri.timepicker"]);

App.factory('Base64', function() {
    var keyStr = 'ABCDEFGHIJKLMNOP' +
            'QRSTUVWXYZabcdef' +
            'ghijklmnopqrstuv' +
            'wxyz0123456789+/' +
            '=';
    return {
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                        keyStr.charAt(enc1) +
                        keyStr.charAt(enc2) +
                        keyStr.charAt(enc3) +
                        keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                alert("There were invalid base64 characters in the input text.\n" +
                        "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                        "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = keyStr.indexOf(input.charAt(i++));
                enc2 = keyStr.indexOf(input.charAt(i++));
                enc3 = keyStr.indexOf(input.charAt(i++));
                enc4 = keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };
});



App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/")
	
	$stateProvider
	.state('home', {
		url: "/",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'home',
	        		controller : "HomeController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('category', {
		url: "/category",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'category',
	        		controller : "CategoryController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('itemInfo', {
		url: "/itemInfo",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'itemInfo',
	        		controller : "ItemController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('searchItems', {
		url: "/searchItems",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'searchItems',
	        		controller : "SearchItemController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('viewAllSubCategoryOrManufacturers', {
		url: "/viewAllSubCategoryOrManufacturers",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'viewAllSubCategoryOrManufacturers',
	        		controller : "ViewAllSubCategoryOrManufacturersController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('account', {
		url: "/account",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'account',
	        		controller : "AccountController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('shopping_cart', {
		url: "/shopping_cart",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'shopping_cart',
	        		controller : "ShoppingCartController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('checkoutAddress', {
		url: "/checkoutAddress",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'checkoutAddress',
	        		controller : "CheckoutAddressController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('checkout', {
		url: "/checkout",
			views: {
				'header' : {
					templateUrl : 'header',
					controller : "HeaderController"
					},
	            'content': {
	            	templateUrl: 'checkout',
	        		controller : "CheckoutController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
}]);

