angular.module("crudApp").controller("GeneralController", GeneralController);

GeneralController.inject = ['$scope', 'PersonalDetails'];

function GeneralController($scope, PersonalDetails){
	
	
	$scope.clients = PersonalDetails.query();
	$scope.client = {};
	$scope.buttonText = "Submit";
	
	$scope.saveClient = function(){
		
		if($scope.client.id !== undefined){
			PersonalDetails.update($scope, clients, function(){
				$scope.clients = PersonalDetails.query();
				$scope.client = {};
				$scope.buttonText = "Submit";
			});
		}
		else{
			PersonalDetails.save($scope, clients, function(){
				$scope.clients = PersonalDetails.query();
				$scope.client = {};
				$scope.buttonText = "Submit";
			});
		}
	}
	
	$scope.updateClientInit = function(client){
		$scope.buttonText = "Update";
		$scope.client = client;
	}
	
	$scope.deleteClient = function(){
		client.$delete({id:client.id}, function(){
			$scope.clients = PersonalDetails.query();
		});
	}
}