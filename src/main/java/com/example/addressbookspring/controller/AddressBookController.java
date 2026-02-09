package com.example.addressbookspring.controller;

import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.model.AddressBookModel;
import com.example.addressbookspring.service.IAddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService service;

    @PostMapping("/add")
    public AddressBookModel addContact(@Valid @RequestBody AddressBookDTO dto) {
        return service.addContact(dto);
    }

    @GetMapping("/get")
    public List<AddressBookModel> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/get/{id}")
    public AddressBookModel getContactById(@PathVariable int id) {
        return service.getContactById(id);
    }

    @PutMapping("/update/{id}")
    public AddressBookModel updateContact(@PathVariable int id,
                                          @Valid @RequestBody AddressBookDTO dto) {
        return service.updateContact(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable int id) {
        return service.deleteContact(id);
    }
}
