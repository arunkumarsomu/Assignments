	
	
// Display workout routine for user


app.controller('routineCtrl', function($scope, $http,$location, $rootScope) {
	
	$rootScope.getUserInfo();
	console.log("desc = ",$rootScope.userId);	
	$scope.dailyFlag = [];
			
		$scope.getLink = "http://localhost:8080/exerciseTracking/"+$rootScope.userId
		$http({
				  url: $scope.getLink,
				  method: 'POST'
			}).success(function(data){
				$scope.records = data;
				console.log("data = ",$scope.records);
				var len = $scope.records.length;
			
				 
					for (var desc in $scope.records){
												
						if($scope.records[desc].todays_date !== null){
							$scope.records[desc].canTrack = false;
							
						}else {$scope.records[desc].canTrack = true;
						      
						}
						
					}
					
					var j = 0;
					
					for (var i=0; i< len; i++){
						console.log($scope.records[i].dayNo);
					
						if (i>0){
							if ($scope.records[i].dayNo !== $scope.records[i-1].dayNo){
									$scope.dailyFlag[j] = $scope.records[i-1].canTrack;
										j += 1;
							}
						}
						
						if(i === len-1)
							$scope.dailyFlag[j] = $scope.records[i-1].canTrack;
					}
			 
					console.log("flag = ",$scope.dailyFlag);	
						
			})
						

	
	$scope.getExVal = function(dayno){
		sessionStorage.setItem("dayno",dayno);
		 $location.path('/trackThisDay');
	}

	$scope.delRoutine = function(){
	
	console.log("desc = ",$rootScope.userId);	
			$scope.delLink = "http://localhost:8080/deleteRoutine/" + $rootScope.userId;
				$http({
				  url: $scope.delLink,
				  method: 'DELETE',
				  transformResponse: [function (data) {
					  console.log("data=",data);
					  return data;
						}]
					}).success(function(data){
						console.log("data=",data);
						$rootScope.surveyDone = false;
						$rootScope.storeUserInfo2();
						
						alert("Your workout routine deleted successfully, please fill out survey page to create a new one");
						$location.path('/survey');
					});
	
	}
	
	$scope.downloadPDF = function(){
	  html2canvas(document.getElementById('exportthis'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500,
                    }]
                };
                pdfMake.createPdf(docDefinition).download("Workout_Routine.pdf");
            }
        });
	}
	
	
	});
