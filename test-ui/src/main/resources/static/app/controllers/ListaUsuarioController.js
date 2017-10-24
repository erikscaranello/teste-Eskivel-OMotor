'use strict';

angular.module('test').controller('ListaUsuarioController', ['$scope', '$state', '$window', 'UsuarioService',
function ($scope, $state, $window, UsuarioService) {
	
	var usuarios = UsuarioService.listaUsuarios().then(function (response){
		$scope.usuarios = response.data;
	}, function(error){
		alert(error);
	});
	
	
	$scope.editarUsuario = function(id) {
		$window.location.href = '/#/user/update/' + id;
	}
	
	$scope.excluirUsuario = function(id) {
		UsuarioService.excluirUsuario(id).then(function (response){
			alert("Usuario excluído");
		}, function(error){
			alert("Ocorreu um erro" + error);
		});
	}
	
}]);