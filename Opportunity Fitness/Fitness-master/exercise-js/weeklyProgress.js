	
	app.controller('weeklyProgCtrl', function($http,$scope,$rootScope,$parse) {
	
		$rootScope.getUserInfo();	
		console.log("desc = ",$rootScope.userId);	
		
		$scope.myDataSource = {};
		$scope.myDataSource0 = {};
		$scope.myDataSource1 = {};
		$scope.myDataSource2 = {};
		$scope.myDataSource3 = {};
		$scope.foodDataSource = {};
		$scope.foodDataSource0 = {};
		$scope.foodDataSource1 = {};
		$scope.foodDataSource2 = {};
		$scope.foodDataSource3 = {};
		$scope.data=[];
		
		$scope.calDataSource = {};
		$scope.calDataSource0 = {};
		$scope.calDataSource1 = {};
		$scope.calDataSource2 = {};
		$scope.calDataSource3 = {};
		
		$scope.week1 = false;
		$scope.week2 = false;
		$scope.week3 = false;
		$scope.week4 = false;
		
		$scope.getData = function(weekno){
				$scope.week1 = false;
				$scope.week2 = false;
				$scope.week3 = false;
				$scope.week4 = false;
			
			
			$scope.getLink = "http://localhost:8080/weeklyProgress/" + $rootScope.userId ;
				$http({
				  url: $scope.getLink,
				  method: 'POST'
					}).success(function(response){
						console.log("response =",response);
						$scope.data  = response;
					console.log("Data =",$scope.data);
						console.log("day1 =" ,$scope.data[0].day1);
						 val = $scope.data[0].day1;
						 console.log("Val =",val);
				 for (var count in $scope.data){
							console.log("count =" ,count);
							$scope.weekNo = "Week " + ( parseInt(count) + 1 ) + " Progress";
						 $scope.myDataSource = {
						   'chart': {
							   caption: "Workout Progress Chart",
							   numberSuffix: "%",
							   "subCaption": " Efficiency of Workout by Day",
								"xAxisName": "Days",
								"yAxisName": "Percent Completed",
								"showHoverEffect":"1",
								"showLegend": "1",
							   theme: "fint"
						   },
						   'data':[{
							   label: "Day 1",
							   value: $scope.data[count].day1
						   },
						   {
							   label: "Day 2",
							   value:  $scope.data[count].day2
						   },
						   {
							   label: "Day 3",
							   value: $scope.data[count].day3
						   },
						   {
							   label: "Day 4",
							   value: $scope.data[count].day4
						   },
						   {
							   label: "Day 5",
							   value: $scope.data[count].day5
						   }]
						};	
						
						var the_string = 'myDataSource' + count ;
						console.log("the_string =" ,the_string);
						var model = $parse(the_string);
						model.assign($scope, $scope.myDataSource);
						 console.log("$scope.myDataSource0 =" ,$scope.myDataSource0);
						 
						 
					 $scope.foodDataSource = {
						   'chart': {
							    "caption": "Nutrition Track chart",
								"subCaption": " Intake by day",
								"xAxisName": "Day",
								"yAxisName": "Nutrition Percent",
								"numberSuffix": "%"
								
						   },
						 "categories": [
									{
									"category": [
										{
											"label": "Day1"
										},
										{
											"label": "Day2"
										},
										{
											"label": "Day3"
										},
										{
											"label": "Day4"
										},
										{
											"label": "Day5"
										}
									]
								}
							],
						   'dataset':[
						   {
							   "seriesname": "Protein",
								   'data':[{
									   value: $scope.data[count].day1fd[1]
								   },
								   {
									   
									   value:  $scope.data[count].day2fd[1]
								   },
								   {
									  
									   value: $scope.data[count].day3fd[1]
								   },
								   {
									   
									   value: $scope.data[count].day4fd[1]
								   },
								   {
									  
									   value: $scope.data[count].day5fd[1]
								   }]
								   
						   },
						   {
							   "seriesname": "Carbs",
							   'data':[{
									   
									   value: $scope.data[count].day1fd[2]
								   },
								   {
									   
									   value:  $scope.data[count].day2fd[2]
								   },
								   {
									  
									   value: $scope.data[count].day3fd[2]
								   },
								   {
									  
									   value: $scope.data[count].day4fd[2]
								   },
								   {
									  
									   value: $scope.data[count].day5fd[2]
								   }]
							   
							   
						   },
						     {
							   "seriesname": "Fat",
							   'data':[{
									   
									   value: $scope.data[count].day1fd[3]
								   },
								   {
									   
									   value:  $scope.data[count].day2fd[3]
								   },
								   {
									  
									   value: $scope.data[count].day3fd[3]
								   },
								   {
									  
									   value: $scope.data[count].day4fd[3]
								   },
								   {
									  
									   value: $scope.data[count].day5fd[3]
								   }]
							   
							   
						   }
						  ]
						   
						  
						   
						   
						};	//food data source  chart
						
						
						 var the_string1 = 'foodDataSource' + count ;
						console.log("the_string1 =" ,the_string1);
						var model1 = $parse(the_string1);
						model1.assign($scope, $scope.foodDataSource);
						 console.log("$scope.foodDataSource0 =" ,$scope.foodDataSource0);

						 $scope.calDataSource = {
						   'chart': {
							   caption: "Calories consumed Chart",
							   numberSuffix: "cals",
							   "subCaption": " calorie intake by day",
								 "bgColor": "#ffffff",
                "showBorder": "0",
                "use3DLighting": "0",
                "showShadow": "0",
                "enableSmartLabels": "0",
                "startingAngle": "0",
                "showPercentValues": "0",
                "showPercentInTooltip": "0",
                "decimals": "3",
                "captionFontSize": "14",
                "subcaptionFontSize": "14",
                "subcaptionFontBold": "0",
                "toolTipColor": "#ffffff",
                "toolTipBorderThickness": "0",
                "toolTipBgColor": "#000000",
                "toolTipBgAlpha": "80",
                "toolTipBorderRadius": "2",
                "toolTipPadding": "5",
                "showHoverEffect":"1",
                "showLegend": "1",
                "legendBgColor": "#ffffff",
                "legendBorderAlpha": '0',
                "legendShadow": '0',
                "legendItemFontSize": '10',
                "legendItemFontColor": '#666666'
						   },
						   'data':[{
							   label: "Day 1",
							   value: $scope.data[count].day1fd[0]
						   },
						   {
							   label: "Day 2",
							   value:  $scope.data[count].day2fd[0]
						   },
						   {
							   label: "Day 3",
							   value: $scope.data[count].day3fd[0]
						   },
						   {
							   label: "Day 4",
							   value: $scope.data[count].day4fd[0]
						   },
						   {
							   label: "Day 5",
							   value: $scope.data[count].day5fd[0]
						   }]
						};	

						var the_string2 = 'calDataSource' + count ;
						console.log("the_string2 =" ,the_string1);
						var model2 = $parse(the_string2);
						model2.assign($scope, $scope.calDataSource);
						 console.log("$scope.foodDataSource0 =" ,$scope.calDataSource0);

						
				}  // for loop end
					

					
						 
				});	 //http call success end
			return true;	
		}  // getdata function						
	
				
	});	 // controller end