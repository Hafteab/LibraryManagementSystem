package com.example.libray_management_system.service;

import com.example.libray_management_system.entity.Book;
import com.example.libray_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
        return book;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
        bookRepository.deleteById(book.getId());
    }
}
