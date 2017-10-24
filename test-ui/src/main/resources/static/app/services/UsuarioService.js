'use strict';
angular.module('test').service('UsuarioService', ['$http', function($http){
	this.listaUsuarios = function() {
		
		return $http.get("http://localhost:5000/api/user/listaUsuarios");
	}
	
	this.obterUsuario = function(id) {
		
		return $http.get("http://localhost:5000/api/user/listaUsuarios/" + id);
	}
	
	this.adicionarUsuario = function(usuario) {
		
		var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
		
		$http.post("http://localhost:5000/api/user/insert", usuario, config).then(function (response){
			return response.data;
		}, function(error){
			return error;
		});
	}
	
	this.excluirUsuario = function(id) {
		var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
		
		
		return $http.delete("http://localhost:5000/api/user/delete/"+ id, config);
	}
	
}]);