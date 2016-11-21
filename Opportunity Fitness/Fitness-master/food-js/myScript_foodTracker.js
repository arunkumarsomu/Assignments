app.controller('foodTrackerCtrl', function($scope, $rootScope, $http, filterFilter) {

$rootScope.getUserInfo();

	//not sure why but this is the way to make default buttons with AngularJS (checked="checked" doesn't work)
	$scope.selectedMeal="";

	$scope.foodOptions = [];
	$scope.foodOptions.push({id:0, client_id: "ALL FOODS"});
	
	//button to add selected foods to the summary table
	//note all foods selected will be added, only way to remove them now is to uncheck
	$scope.showSelected = function showSelected()
	{
		$scope.selected = filterFilter($scope.fullfoodlist, {selected:true});
		$scope.total = 0;
		for (var i = 0; i < $scope.selected.length;i++)
		{
			console.log($scope.selected[i]);
			$scope.total = $scope.total + $scope.selected[i].calories;
			console.log($scope.total);
		}	
	}
	
	//will take the items added in scope.selected and store in database
	$scope.addFoodDay = function()
	{
		$scope.dayno = sessionStorage.dayno;
		console.log($scope.selected[0].description)
		console.log($scope.selected[1].description)
		console.log($scope.selected[2].description)
	var data1 =[];	
	for (var i = 0; i < $scope.selected.length;i++)
	{	
		data1[i]=
		{
			user_id: $rootScope.userId,
			dayNo: $scope.dayno,
			food_desc:$scope.selected[i].description,
			food_cat_id:$scope.selected[i].client_id,
			protein:$scope.selected[i].protein,
			fat:$scope.selected[i].fat,
			carbs:$scope.selected[i].carbs,
			calories:$scope.selected[i].calories
		}
	}
		
	//	data1 = $scope.selected;
		console.log("Data 1 =",data1);
		
		$http({
			url: "http://localhost:8080/storeFood/",
			method: 'POST',
			data: data1,
			}).success(function(data)
			{
				//console.log(data.description);
			});
	}
	
	//this will get all the food categories
	$scope.getLink = "http://localhost:8080/foodcategories/";
		$http({
			url: $scope.getLink,
			method: 'GET',
				
			}).success(function(data){
				$scope.foodcategorylist = data;
				for(var i = 0; i < $scope.foodcategorylist.length; i++)
				{
					//$scope.foodOptions.push($scope.foodcategorylist[i].client_id);
					$scope.foodOptions.push($scope.foodcategorylist[i]);
				}
			});
				
	//this will get the entire food list
	$scope.getLink = "http://localhost:8080/food/";
		$http({
			url: $scope.getLink,
			method: 'GET',
				
			}).success(function(data){
				$scope.fullfoodlist = data;
			});

				
	this.search= function(id){
		console.log("d passed:",id); 
	
		$scope.getLink = "http://localhost:8080/food/"+id;
				$http({
					  url: $scope.getLink,
					  method: 'GET',
				
					}).success(function(data){
						$scope.foodlist = data;						
					});
	}
	
		//function to filter food list according to the food category option selected
	$scope.filter= function(opt)
	{
		var selection = String(opt);
		console.log(opt)
		if(opt.client_id === "ALL FOODS" || opt == null)
			$scope.selectedMeal = "";
		else
			$scope.selectedMeal = opt.id;
	}
});