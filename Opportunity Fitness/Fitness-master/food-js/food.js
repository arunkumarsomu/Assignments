//Getting food from ID
//search.$inject = ["foods"]
app.controller('foodCtrl', function($scope, $http, $filter,$rootScope) {

$rootScope.getUserInfo();	
				console.log("desc = ",$rootScope.userId);
	//not sure why but this is the way to make default buttons with AngularJS (checked="checked" doesn't work)
	$scope.selectedMeal="";
	$scope.foodOptions = [];
	$scope.foodOptions.push({id:0, client_id: "ALL FOODS"});
	
	//this will get all the food categories
	$scope.getLink = "http://localhost:8080/foodcategories/";
		$http({
			url: $scope.getLink,
			method: 'GET',
				
			}).success(function(data){
				$scope.foodcategorylist = data;
				console.log($scope.foodcategorylist);
				for(var i = 0; i < $scope.foodcategorylist.length; i++)
				{
					//$scope.foodOptions.push($scope.foodcategorylist[i].client_id);
					$scope.foodOptions.push($scope.foodcategorylist[i]);
				}
				
			});
			
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
	
	/* When the user clicks on the button, 
	toggle between hiding and showing the dropdown content */
	function dropDown() {
		document.getElementById("dropDown").classList.toggle("show");
	}

	// Close the dropdown menu if the user clicks outside of it
	window.onclick = function(event) {
	  if (!event.target.matches('.dropbtn')) {

		var dropdowns = document.getElementsByClassName("dropdown-content");
		var i;
		for (i = 0; i < dropdowns.length; i++) {
		  var openDropdown = dropdowns[i];
		  if (openDropdown.classList.contains('show')) {
			openDropdown.classList.remove('show');
		  }
		}
	  }
	}
});