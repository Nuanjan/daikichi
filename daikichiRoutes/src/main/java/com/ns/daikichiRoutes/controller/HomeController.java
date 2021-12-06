package com.ns.daikichiRoutes.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daikichi")
public class HomeController {
	 @RequestMapping("")
	    // 3. Method that maps to the request route above
	    public String welcome() { // 3
	            return "Welcome";
	    }
	 
	 @RequestMapping("/today")
	 public String today() {
		 return "Today you will find luck in all your endoeavors!";
	 }
	 
	 @RequestMapping("/tomorrow")
	 public String tomorrow() {
		 return "Tomorrow, Tomorrow, I love you tomoorrow~";
	 }
	 
	 
	 @RequestMapping("/travel/{place}")
	 public String travelto(
			 @PathVariable("place") String place
			 
			 ) {
		 
		 return "Congratuations! You will soon travel to " + place;
	 }
	 @RequestMapping("/lotto/{number}")
	 public String lotto(
		 @PathVariable("number") Integer number
		 ) {		 
		 if(number % 2 == 0){
		 return "You will take a grand journey in the near future, but be weary of tempting offers.";
		 }
		 
		 return " You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	 }	 
	
}
