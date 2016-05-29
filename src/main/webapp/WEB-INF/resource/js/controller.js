/**
 * Created by Alan_Finn on 28/05/2016.
 */
var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(cartId){
        $http.get('/MusicStore5/rest/cart/' + $scope.cartId).success(function (data){
            $scope.cart = data;
        });
    };

    $scope.clearCart = function(){
        $http.delete('/MusicStore5/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(productId){
        $http.put('/MusicStore5/rest/cart/add/' + productId).success(function (data){
            $scope.refreshCart($http.get("/MusicStore5/rest/cart/cartId"));
            alert('Product successfully added to the cart!');

        });
    };

    $scope.removeFromCart = function(productId){
        $http.put('/MusicStore5/rest/cart/remove/' + productId).success(function(data){
            $scope.refreshCart($http.get("/MusicStore5/rest/cart/cartId"));
        });
    };


});
