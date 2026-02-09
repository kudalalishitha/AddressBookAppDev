package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.exception.IdNotFoundException;
import com.example.addressbookspring.model.AddressBookModel;
import com.example.addressbookspring.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public AddressBookModel addContact(AddressBookDTO dto) {

        AddressBookModel contact = new AddressBookModel();
        contact.setName(dto.getName());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());
        contact.setCity(dto.getCity());

        log.info("Adding new contact: {}", contact.getName());

        return repository.save(contact);
    }

    @Override
    public List<AddressBookModel> getAllContacts() {
        log.info("Fetching all contacts");
        return repository.findAll();
    }

    @Override
    public AddressBookModel getContactById(int id) {
        log.info("Fetching contact by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Contact not found with id: " + id));
    }

    @Override
    public AddressBookModel updateContact(int id, AddressBookDTO dto) {

        AddressBookModel contact = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Contact not found with id: " + id));

        contact.setName(dto.getName());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());
        contact.setCity(dto.getCity());

        log.info("Updating contact with id: {}", id);

        return repository.save(contact);
    }

    @Override
    public String deleteContact(int id) {

        AddressBookModel contact = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Contact not found with id: " + id));

        repository.delete(contact);

        log.info("Deleted contact with id: {}", id);

        return "Contact deleted successfully with id: " + id;
    }
}
