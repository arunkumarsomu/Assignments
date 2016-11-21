package com.tiy.ssa.exerciseWebApp.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tiy.ssa.exerciseWebApp.entity.Food;
import com.tiy.ssa.exerciseWebApp.entity.Food_Category;
import com.tiy.ssa.exerciseWebApp.entity.Food_Tracking;
import com.tiy.ssa.exerciseWebApp.entity.Userinfo;
import com.tiy.ssa.exerciseWebApp.service.FoodService;
import com.tiy.ssa.exerciseWebApp.service.IFood_CategoryService;
import com.tiy.ssa.exerciseWebApp.service.IFood_TrackingService;
import com.tiy.ssa.exerciseWebApp.service.IFoodService;

@Controller
@RequestMapping("/")
@CrossOrigin
public class FoodController {

		@Autowired
		private IFoodService foodService;
		
		@Autowired
		private IFood_CategoryService foodCategoryService;
		
		@Autowired
		private IFood_TrackingService foodTrackingService;
  
		@RequestMapping(value= "/food/{id}", method = RequestMethod.GET)
		public ResponseEntity<Food> getFoodById(@PathVariable("id") Integer id)
		{
			return new ResponseEntity<Food>(foodService.getFoodById(id), HttpStatus.OK);
		}
		
		@RequestMapping(value= "/foodcategorylist/{id}", method = RequestMethod.GET)
		public ResponseEntity<List<Food>> getFoodByCategory(@PathVariable("id") Integer id)
		{
			return new ResponseEntity<List<Food>>(foodService.getFoodListByCategory(id), HttpStatus.OK);
		}
		
		@RequestMapping(value= "/food/", method = RequestMethod.GET)
		public ResponseEntity<List<Food>> getAllFood()
		{
			//return new ResponseEntity<List<Food_Category>>(foodCategoryService.getAllFoodCategory(), HttpStatus.OK);
			return new ResponseEntity<List<Food>>(foodService.getAllFoodC(), HttpStatus.OK);
		}
		
		@RequestMapping(value= "/foodcategories/", method = RequestMethod.GET)
		public ResponseEntity<List<Food_Category>> getFoodCategories()
		{
			return new ResponseEntity<List<Food_Category>>(foodCategoryService.getAllFoodCategory(), HttpStatus.OK);
		}
		
		@RequestMapping(value= "/storeFood/", method = RequestMethod.POST)
		@ResponseBody
		public void storeFood(@RequestBody List<Food_Tracking> foodTrack)
		{
			System.out.println(foodTrack.get(0).getFood_desc());
			for (Food_Tracking fdTk : foodTrack){
				foodTrackingService.insertFoodTrack(fdTk);
			}
			
		}
		
	    
	}
