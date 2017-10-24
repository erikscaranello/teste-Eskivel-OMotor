
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/app-template.html',
		controller: 'AppController'
	
	}).state('listaUsuarios', {
		url: '/user',
		templateUrl: '/app/views/listaUsuario.html',
		controller: 'ListaUsuarioController'
	
	}).state('adicionaUsuario', {
		url: '/user/add',
		templateUrl: '/app/views/adicionaUsuario.html',
		controller: 'AdicionaUsuarioController'
	
	}).state('updateUsuario', {
		url: '/user/update/:id',
		templateUrl: '/app/views/adicionaUsuario.html',
		controller: 'UpdateUsuarioController'
	});
}]);