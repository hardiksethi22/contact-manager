package com.hardiksethi.contactmanager.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
	
	/* Sign In Page */
	@GetMapping("/signin")
	public String signin(Model model) {
		model.addAttribute("title", "Contact Manager - Sign In");
		return "sign-in";
	}
	
	/* Handling sign-up request */
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult bindingresult,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession httpsession) {
		try {
			if (!agreement) {
				throw new Exception("Agreement not accepted");
			}
			if (bindingresult.hasErrors()) {

				System.out.println(bindingresult.toString());
				model.addAttribute("user", user);
				return "sign-up";
			}
			user.setUser_role("ROLE_USER");
			user.setUser_enabled(true);
			user.setUser_image_url("default.png");
			user.setUser_password(passwordEncoder.encode(user.getUser_password()));
			model.addAttribute("user", new User());
			System.out.println(user);
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
