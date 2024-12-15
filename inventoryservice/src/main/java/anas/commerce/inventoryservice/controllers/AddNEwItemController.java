package anas.commerce.inventoryservice.controllers;

import anas.commerce.inventoryservice.contracts.IAddNewItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AddNEwItemController {


    private final IAddNewItemService addNewItemService;

}
