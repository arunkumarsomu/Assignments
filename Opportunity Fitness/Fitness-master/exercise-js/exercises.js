
	
	// Listing workouts for a muscle group 
	
	app.controller('exCtrl', function($scope,$rootScope, $http) {
	$rootScope.getUserInfo();
	$scope.cat = sessionStorage.category;
	console.log("desc = ",$scope.cat);	
	
	$scope.getLink = "http://localhost:8080/exercise/"+$scope.cat;
				$http({
					  url: $scope.getLink,
					  method: 'POST',
				
					}).success(function(data){
						$scope.records = data;
						console.log("Success getting workouts");
						console.log("data = ",$scope.records);
						for (var desc in $scope.records){
							console.log("Exercises : ",$scope.records[desc].exercise_name);
							$scope.newUrl = $scope.records[desc].url;
						}					
					});

		
		
	});