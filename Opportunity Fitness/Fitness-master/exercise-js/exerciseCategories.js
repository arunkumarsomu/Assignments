
// Listing muscle group categories
	
	app.controller('catCtrl', function($scope,$rootScope, $http) {
	
	$rootScope.getUserInfo();
	
	$scope.getLink = "http://localhost:8080/exerciseCategories";
				$http({
					  url: $scope.getLink,
					  method: 'POST',
				
					}).success(function(data){
						$scope.records = data;
						console.log("Success getting list");
						console.log("data = ",$scope.records);
						for (var desc in $scope.records){
							console.log("Categories : ",$scope.records[desc].description);
						}					
					});
					
			$scope.setActiveCat= function(desc){
				console.log("desc clicked",desc);
				sessionStorage.setItem("category", desc);
			}
		
		
	});
	