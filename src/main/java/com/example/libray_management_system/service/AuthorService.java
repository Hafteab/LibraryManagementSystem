package com.example.libray_management_system.service;


import com.example.libray_management_system.entity.Author;
import com.example.libray_management_system.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author NOt found"));
        return author;
    }

    public void updateAuthor(Author author){
           authorRepository.save(author);
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author NOt found"));
        authorRepository.deleteById(author.getId());
    }
}
