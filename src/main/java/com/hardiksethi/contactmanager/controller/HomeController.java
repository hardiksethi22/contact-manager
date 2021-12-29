package com.hardiksethi.contactmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardiksethi.contactmanager.dao.UserDao;
import com.hardiksethi.contactmanager.entities.User;
import com.hardiksethi.contactmanager.helper.Message;

@Controller
public class HomeController {

	@Autowired
	private UserDao userdao;

	/* Home Page */
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Contact Manager");
		return "home";
	}

	/* About Page */
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "Contact Manager - About");
		return "about";
	}

	/* Sign Up Page */
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Contact Manager - Sign Up");
		model.addAttribute("user", new User());
		return "sign-up";
	}

	/* Handling sign-up request */
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession httpsession) {
		try {
			if (!agreement) {
				throw new Exception("Agreement not accepted");
			}
			user.setUser_role("ROLE_USER");
			user.setUser_enabled(true);
			user.setUser_image_url("default.png");
			model.addAttribute("user", new User());
			userdao.save(user);
			httpsession.setAttribute("message", new Message("Successfully Registered!!", "alert-primary"));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			httpsession.setAttribute("message",
					new Message("Something went wrong !!! " + e.getLocalizedMessage(), "alert-danger"));
		}
		return "sign-up";
	}
}
