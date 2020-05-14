angular.module{'crudApp'}.factory('PersonalDetails', Client);

Client.$inject=['$resource'];

function Client($resource){
	
	var resourceUrl='api/client/:id';
	
	return $resource(resourceUrl,{},{'update' : {
		method : 'PUT'
		}
			});
}