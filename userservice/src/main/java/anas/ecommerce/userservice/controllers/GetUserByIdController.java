package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IGetUserByIdService;
import anas.ecommerce.userservice.dtos.userdto.UserDto;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class GetUserByIdController {


    private final IGetUserByIdService getUserByIdService;

    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<UserDto> getUSerById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(getUserByIdService.getUserById(new ObjectId(id)), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {

        }
    }
}
