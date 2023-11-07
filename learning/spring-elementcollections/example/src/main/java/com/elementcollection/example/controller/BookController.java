package com.elementcollection.example.controller;

import com.elementcollection.example.entity.Books;
import com.elementcollection.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getBooks")
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
    @PostMapping("/addBooks")
    public Books createBook(@RequestBody Books books) {
        return bookRepository.save(books);
    }
}
