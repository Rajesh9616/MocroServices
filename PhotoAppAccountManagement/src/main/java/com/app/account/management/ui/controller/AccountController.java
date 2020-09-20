package com.app.account.management.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {
	@GetMapping("/status/check")
	//@RequestMapping(method = RequestMethod.GET)
	public String checkStatus() {
		return "User Controller Status working";
	}

}
