package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IUserAuthenticationService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserAuthenticationService implements IUserAuthenticationService {
    private final Logger logger = Logger.getLogger(UserAuthenticationService.class.getName());

}
