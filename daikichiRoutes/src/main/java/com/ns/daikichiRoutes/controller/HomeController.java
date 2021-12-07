package com.ns.daikichiRoutes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {
//	 @RequestMapping("")
//	    // 3. Method that maps to the request route above
//	    public String welcome() { // 3
//	            return "Welcome";
//	    }
//	 
//	 @RequestMapping("/today")
//	 public String today() {
//		 return "Today you will find luck in all your endoeavors!";
//	 }
//	 
//	 @RequestMapping("/tomorrow")
//	 public String tomorrow() {
//		 return "Tomorrow, Tomorrow, I love you tomoorrow~";
//	 }
//	 
//	 
//	 @RequestMapping("/travel/{place}")
//	 public String travelto(
//			 @PathVariable("place") String place
//			 
//			 ) {
//		 
//		 return "Congratuations! You will soon travel to " + place;
//	 }
//	 @RequestMapping("/lotto/{number}")
//	 public String lotto(
//		 @PathVariable("number") Integer number
//		 ) {		 
//		 if(number % 2 == 0){
//		 return "You will take a grand journey in the near future, but be weary of tempting offers.";
//		 }
//		 
//		 return " You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
//	 }	
//	 
	 @RequestMapping("/omikuji")
	 public String index() {
		 System.out.println(" here ios pass");
		 return "omikujiForm.jsp";
	 }
	 
	 @RequestMapping(value="/omikuji/process", method=RequestMethod.POST)
	 public String process(
			 @RequestParam(value="number", required = false) Integer number,
			 @RequestParam(value="city", required = false) String city,
			 @RequestParam(value="person", required = false) String person,
			 @RequestParam(value="hobby", required = false) String hobby,
			 @RequestParam(value="thing", required = false) String thing,
			 @RequestParam(value="comment",required = false) String comment,
			 HttpSession session,
			 RedirectAttributes redirectAttributes
			 ) {
		 System.out.print(number + city+person+hobby+thing+ comment);
		if(number == null || city == null || person == null || hobby == null || thing == null || comment == null) {
			redirectAttributes.addFlashAttribute("error", "All field are required!");
			return "redirect:/omikuji";
		}
		 String omikuji = String.format("In %d years, you will live in %s with %s as your roommate, selling %s for a living. The next time you see a %s, you will have a good luck. Also, %s"  , number, city, person, hobby, thing, comment);
		 session.setAttribute("omikuji", omikuji);
	 return "redirect:/omikuji/result";
	 }
	 
	 @RequestMapping("/omikuji/result")
	 public String result(HttpSession session, Model model) {
		 String omikuji = (String)session.getAttribute("omikuji");
		 System.out.println(omikuji);
		 model.addAttribute("omikuji", omikuji);
		 return "result.jsp";
	 }
	
}
