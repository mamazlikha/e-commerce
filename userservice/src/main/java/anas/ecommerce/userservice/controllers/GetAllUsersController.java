package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IGetAllUsersService;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class GetAllUsersController {

    private final IGetAllUsersService getAllUsersService;

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(getAllUsersService.getAllUsers(), HttpStatus.OK);
    }
}
