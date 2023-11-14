package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IGetAllUsersService;
import anas.ecommerce.userservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@ControllerAdvice
public class GetAllUsersController {

    private final Logger logger = Logger.getLogger(GetAllUsersController.class.getName());

    @Autowired
    private IGetAllUsersService getAllUsersService;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(getAllUsersService.getAllUsers(), HttpStatus.OK);
    }
}
