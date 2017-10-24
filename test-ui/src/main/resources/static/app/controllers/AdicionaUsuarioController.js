'use strict';

angular.module('test').controller('AdicionaUsuarioController', ['$scope', '$state', 'UsuarioService', 
function ($scope, $state, UsuarioService) {
	$scope.usuario = {};
	$scope.formulario = true;
	
	
	$scope.enviarFormulario = function(usuario) {
		
		UsuarioService.adicionarUsuario(usuario);	
		$scope.formulario = false;
	}
}]);