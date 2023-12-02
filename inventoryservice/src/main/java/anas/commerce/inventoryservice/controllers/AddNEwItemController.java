package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IAddNewItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class AddNEwItemController {

    private final Logger logger = Logger.getLogger(AddNEwItemController.class.getName());

    @Autowired
    private IAddNewItemService addNewItemService;

}
