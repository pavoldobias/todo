package sk.garwan.todo.web.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Login controller implementation
 * 
 * @author Pavol Dobias
 *
 */
@Controller
public class LoginController {
 
	/**
	 * method for login
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
	
	/**
	 * method for unsuccessful login 
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
	
	
	/**
	 * method for logout
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
}