"use strict";

angular.module('productApp', [])

        .factory('productFactory', function ($http) {
            var factory = {};

            factory.getAllProduct = function () {
                return $http.get('/product');
            };

            factory.addProduct = function (product) {
                return $http.post('/product', {
                    nom: product.nom,
                    quantite: product.quantite
                });
            };

            return factory;
        })

        .controller('ProductListController', function ($scope, productFactory) {
            var productList = this;

            productList.products = [];
            productList.nameText = '';
            productList.quantiteText = 0;

            // refrech products
            productList.reloadProducts = function () {
                console.log("reloadProducts");
                productList.products = [];
                productList.nameText = '';
                productList.quantiteText = 0;

                productFactory.getAllProduct()
                        .then(function (response) {
                            if (response.status === 200 &&
                                    response.data && response.data.uiProductDtoList) {
                                productList.products = response.data.uiProductDtoList;

                            }
                            console.log("reloadProducts response",
                                    response.status, productList.products);
                        });
            };
            productList.reloadProducts();

            // add new product
            productList.addProduct = function () {

                productFactory.addProduct({
                    nom: productList.nameText,
                    quantite: productList.quantiteText
                }).then(function (response) {

                    console.log("addProduct", response.status);
                    productList.reloadProducts();
                });
            };

            // get number of product
            productList.remaining = function () {
                var count = 0;
                if (productList.products) {
                    count = productList.products.length;
                }
                return count;
            };

            productList.archive = function () {
            };
        });

