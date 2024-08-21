package anas.ecommerce.userservice.services;

import anas.ecommerce.userservice.contracts.IUserAuthenticationService;
import anas.ecommerce.userservice.contracts.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAuthenticationService implements IUserAuthenticationService {

    private final IUserRepository repository;



}
