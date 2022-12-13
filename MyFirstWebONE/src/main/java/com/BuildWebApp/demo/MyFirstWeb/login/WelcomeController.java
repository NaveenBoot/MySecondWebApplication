/*package com.BuildWebApp.demo.MyFirstWeb.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginView(@RequestParam String name, Model model) {
		model.addAttribute("MyName", name);
		return "login";
	}

}*/

package com.BuildWebApp.demo.MyFirstWeb.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("MyName")
public class WelcomeController {
	
	/*@Autowired
	private Authentication authentication;*/
	
	/*@RequestMapping(value="/", method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("MyName", "NaveenS");
		return "welcomepage";
	}*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("MyName", getLoggedInUsername());
		return "welcomepage";
	}
	
	private String getLoggedInUsername() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
	
	
	
	/*@RequestMapping(value="login", method=RequestMethod.POST)
	public String welcomePage(@RequestParam String username,@RequestParam String psd, Model model) {
		if(authentication.auth(username, psd)) {
			model.addAttribute("MyName", username);
			return "welcomepage";
		}
		model.addAttribute("errormsg", "Invlaid Credentials Please Try Again ");
		return "login";
	}*/

}





















