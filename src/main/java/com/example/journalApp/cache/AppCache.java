package com.example.journalApp.cache;

import com.example.journalApp.entity.ConfigJournalAppEntity;
import com.example.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppCache {


    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String,String> AppCache;

    @PostConstruct
    public void init(){
        AppCache=new HashMap<>();
        List<ConfigJournalAppEntity> all= configJournalAppRepository.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity:all){
            AppCache.put(configJournalAppEntity.getKey(),configJournalAppEntity.getValue());
        }
    }
}
