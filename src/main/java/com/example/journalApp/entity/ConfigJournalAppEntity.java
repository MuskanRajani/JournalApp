package com.example.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "config_journal_app")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigJournalAppEntity {


    private String key;
    private String value;

}



















//making plane pojo to mongodb instance
//
//import lombok.*;
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Document(collection = "users")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class User {
//
//    @Getter
//    @Id
//    private ObjectId id;
//    @Indexed(unique = true)
//    @NonNull
//    private String username;
//
//    public @NonNull String getUserName() {
//        return username;
//    }
//
//    public void setUserName(@NonNull String username) {
//        this.username = username;
//    }
//
//    public @NonNull String getPassword() {
//        return password;
//    }
//
//    public void setPassword(@NonNull String password) {
//        this.password = password;
//    }
//
//    public List<JournalEntry> getJournalEntries() {
//        return journalEntries;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public void setJournalEntries(List<JournalEntry> journalEntries) {
//        this.journalEntries = journalEntries;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<String> roles) {
//        this.roles = roles;
//    }
//
//    @NonNull
//    private String password;
//    @Setter
//    @Getter
//    @DBRef
//    private List<JournalEntry> journalEntries = new ArrayList<>();
//    @Setter
//    @Getter
//    private List<String> roles;
//
//
//}