package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IRegisterNewUserService;
import anas.ecommerce.userservice.dtos.userdto.CreateUserDto;
import anas.ecommerce.userservice.exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
@RestController
@Slf4j
@RequiredArgsConstructor
public class RegisterNewUserController {

    private final IRegisterNewUserService registerNewUserService;

    @ExceptionHandler(RuntimeException.class)
    @PostMapping("users/register-user")
    public ResponseEntity<CreateUserDto> registerUser(@RequestBody @Validated CreateUserDto createUserDto) {
        log.info("Adding new user ...");
        try {
            return new ResponseEntity<>(registerNewUserService.registerUser(createUserDto).get(), HttpStatus.CREATED);
        } catch (UserAlreadyExistException ex) {
            log.error("User already exist !");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (RuntimeException ex) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            log.info("registerUser ended !");
        }
    }

}
