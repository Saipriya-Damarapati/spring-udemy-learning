package learn.springboot.webapp.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	private AuthenticationService authenticationService;
	
	// Constructor auto-wiring
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	// Step 1: Exercise
	/* For the action url /login, redirect to learn.springboot.webapp.myfirstwebapp.login.LoginController 
	 * which returns response from login.jsp
	 */
	
	// Step 2: Capturing Query Params using RequestParam
	/*
	 * http://localhost:8080/login?name=Ranga
	 * Pass the parameter ModelMap and add the required details to modelmap to use them in a jsp
	 * In jsp, Expression language is used to display the value ${attribute_name_key}
	 */
	@RequestMapping("/login-old")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		return "login-old";
	}
	
	// this method supports only for GET methods
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	// this method supports only for POST method, which happens on form submission
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		// Authentication
		if(authenticationService.authenticate(name, password)) {
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials, please re-enter username & password !");
		return "login";
	}
}
