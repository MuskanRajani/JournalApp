package com.example.journalApp.services;


import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

@Autowired
public JournalEntryRepository JournalRepository;

@Autowired
public UserService userService;

@Transactional
public void save(JournalEntry journalEntry, String username){
    try {
        journalEntry.setDate(LocalDateTime.now());
        User user = userService.findByUsername(username);
        JournalEntry entry = JournalRepository.save(journalEntry);
        user.getJournalEntries().add(entry);
        userService.saveUser(user);
    }
    catch (Exception e){
        System.out.println(e);
        throw new RuntimeException("An error has occured while saving the entry",e);
    }

}
    public void save(JournalEntry journalEntry){
        JournalRepository.save(journalEntry);
    }
public List<JournalEntry> getAll(){
        return JournalRepository.findAll();
    }
   public Optional<JournalEntry> findById(ObjectId id){
    return JournalRepository.findById(id);
   }
    @Transactional
    public boolean deleteById(ObjectId id, String username) {
        boolean removed = false;
        try {
            User user = userService.findByUsername(username);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                JournalRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
        return removed;
    }

}
