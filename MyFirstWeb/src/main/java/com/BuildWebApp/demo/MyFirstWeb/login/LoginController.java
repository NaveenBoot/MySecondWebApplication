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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("MyName")
public class LoginController {
	
	@Autowired
	private Authentication authentication;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginView() {
		
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String welcomePage(@RequestParam String username,@RequestParam String psd, Model model) {
		if(authentication.auth(username, psd)) {
			model.addAttribute("MyName", username);
			return "welcomepage";
		}
		model.addAttribute("errormsg", "Invlaid Credentials Please Try Again ");
		return "login";
	}

}





















