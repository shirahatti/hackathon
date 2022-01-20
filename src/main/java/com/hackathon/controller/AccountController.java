package com.org.mybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.mybank.model.Account;
import com.org.mybank.model.User;
import com.org.mybank.service.AccountService;
import com.org.mybank.service.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {
    
	@Autowired
	private AccountService accountService;
	
/*    @GetMapping("/users")
    public List<User> getAllDevelopers(){
        return userService.getAllUsers();
    }*/
    
    @GetMapping("/details/{user_id}")
	public Account  getAccountDetails(@PathVariable (value = "user_id") long user_id) {
		
		// call delete employee method 
		//this.userService.deleteEmployeeById(id);
		return accountService.findByUserId(user_id);
	}
	
}
