package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IUserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class UserAuthenticationController {

    private final Logger logger = Logger.getLogger(UserAuthenticationController.class.getName());

    @Autowired
    private IUserAuthenticationService authenticateUserService;




}
