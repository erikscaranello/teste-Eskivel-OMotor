'use strict';

angular.module('test').controller('UpdateUsuarioController', ['$scope', '$state', '$location', 'UsuarioService', 
function ($scope, $state, $location, UsuarioService) {
	$scope.usuario = {};
	
	var location = $location.$$path;
	var arrayLocation = location.split("/");
	var id = arrayLocation[arrayLocation.length - 1];
	
	var usuarios = UsuarioService.obterUsuario(id).then(function (response){
		$scope.usuario = response.data;
	}, function(error){
		alert(error);
	});
	
	
	$scope.formulario = true;
	
	
	$scope.enviarFormulario = function(usuario) {		
		UsuarioService.adicionarUsuario(usuario);	
		$scope.formulario = false;
	}
}]);