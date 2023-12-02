package anas.ecommerce.userservice.controllers;

import anas.ecommerce.userservice.contracts.IDeleteUserService;
import anas.ecommerce.userservice.exceptions.UserNotFoundException;
import anas.ecommerce.userservice.middlewares.ErrorResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@ControllerAdvice
public class DeleteUserController {

    private final Logger logger = Logger.getLogger(DeleteUserController.class.getName());

    @Autowired
    private IDeleteUserService deleteUserService;

    @DeleteMapping("users/delete-user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id){
        try {
            deleteUserService.deleteUser(new ObjectId(id));
            return new ResponseEntity<>("User with id " + id + " has been successfully deleted !", HttpStatus.NO_CONTENT);
        }
        catch (UserNotFoundException ex){
            return new ResponseEntity<>(new ErrorResponse("User not found: " + id), HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            logger.log(Level.ALL, "deleteUser ended !");

        }
    }

}
