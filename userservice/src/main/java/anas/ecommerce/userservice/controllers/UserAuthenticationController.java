package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IUserAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final IUserAuthenticationService authenticateUserService;

}
