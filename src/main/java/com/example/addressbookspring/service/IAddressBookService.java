package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.model.AddressBookModel;

import java.util.List;

public interface IAddressBookService {

    AddressBookModel addContact(AddressBookDTO dto);

    List<AddressBookModel> getAllContacts();

    AddressBookModel getContactById(int id);

    AddressBookModel updateContact(int id, AddressBookDTO dto);

    String deleteContact(int id);
}
