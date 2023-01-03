package com.example.libray_management_system.service;

import com.example.libray_management_system.entity.Publisher;
import com.example.libray_management_system.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;


    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher NOt found"));
        return publisher;
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher NOt found"));
        publisherRepository.deleteById(publisher.getId());
    }
}
