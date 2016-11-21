
app.controller('oneDayFoodCtrl', function($scope, $rootScope,$http, $location, filterFilter) {
	
	$rootScope.getUserInfo();
$scope.disable = true;
$scope.columnBreak = 5;

	console.log("Id = ",$rootScope.userId);	
	$scope.dayno = sessionStorage.dayno;
	console.log("dayno = ",$scope.dayno);
	
			$scope.getLink = "http://localhost:8080/trackThisDay/" + $rootScope.userId + "/" + $scope.dayno;
				$http({
				  url: $scope.getLink,
				  method: 'POST'
					}).success(function(data){
						
							$scope.exercises = data;
									console.log("data = ",$scope.exercises);
									$scope.count =  $scope.exercises.length;
										for (var desc in $scope.exercises){
											console.log("Exercise Names : ",$scope.exercises[desc].ex_name);
										}
										
					});
	
	$scope.getPercent = function(){
		$scope.currentVal = 0;
		for (var desc in $scope.exercises){
			if($scope.exercises[desc].complete === true)
				$scope.currentVal += 1;
		}
		$scope.oneVal = 100 / $scope.count ;
		$scope.percent = Math.round($scope.currentVal * $scope.oneVal);
		console.log("Percent = ",$scope.percent);
		$scope.width = "width:" + $scope.percent +"%";
		$scope.percentVal = $scope.percent +"%";
	}
	

		$scope.getRowVal = function(){
			for (var desc in $scope.exercises){
				console.log("Exercise Names : ",$scope.exercises[desc].ex_name);
				console.log("Exercise Complete?? : ",$scope.exercises[desc].complete);
				
					$scope.getLink = "http://localhost:8080/updateThisDay/" + $rootScope.userId + "/" + $scope.dayno
									  + "/" + $scope.exercises[desc].ex_name + "/" + $scope.exercises[desc].complete 
									  + "/" + $scope.exercises[desc].numberOfSets + "/" + $scope.exercises[desc].numberOfReps ;
				$http({
				  url: $scope.getLink,
				  method: 'POST',
				  transformResponse: [function (data) {
						console.log("data=",data);
						  return data;
					  }]
					}).success(function(data){
						console.log("Track update response ",data);
										if (data === "true")
											console.log("Updated tracking details");
																				
					});
			}	
		}

		
		$scope.delCall = function(val){
			var flag = "string";
			console.log("Val =",val);
			$scope.delLink = "http://localhost:8080/deleteThisExercise/" + $rootScope.userId + "/" + val.dayNo
									  + "/" + val.ex_name ;
					$http({
					  url: $scope.delLink,
					  method: 'DELETE'
				
					}).success(function(data){
						console.log("Success deleting workouts");
						console.log("data = ",data);
						flag = "success";
						if (flag == "success"){
								location.reload();
								console.log("reload");
						}
						
					}).error(function(data){
						console.log("Failed delete workouts");
						console.log("data = ",data);
					});
			
			
		}
		// To list workouts for users to add from screen 
	$scope.showExList = function(){	
	$scope.selectFlag = false;
	$scope.getLink = "http://localhost:8080/exercisesList/"+$scope.exercises[0].ex_name;
	console.log("$scope.exercises[0].ex_name =",$scope.exercises[0].ex_name);
	$scope.exNames =[];
				$http({
					  url: $scope.getLink,
					  method: 'POST'
				
					}).success(function(data){
						$scope.exList = data;
						console.log("Success getting workouts");
						console.log("data = ",$scope.exList);
						for (var desc in $scope.exList){
							console.log("Exercises : ",$scope.exList[desc].exercise_name);
							$scope.exNames.push($scope.exList[desc].exercise_name);
						}					
					});
	$scope.selectFlag = true;

	}

   $scope.addExToList = function(selectedEx){
	   console.log("$scope.selectedEx = ",selectedEx);
	   	var flag = "string";
		$scope.updateLink = "http://localhost:8080/addExToRoutine/"+$rootScope.userId + "/" + $scope.dayno + "/" + selectedEx;
	
				$http({
					  url: $scope.updateLink,
					  method: 'POST'
				
					}).success(function(data){
						console.log("Success updating workouts");
						console.log("data = ",data);
						flag = "success";
						if (flag == "success"){
								location.reload();
								console.log("reload");
						}
						
					}).error(function(data){
						console.log("Failed updating workouts");
						console.log("data = ",data);
					});
				
 console.log("here ---");				
			
	   
   }
	
	
  		});