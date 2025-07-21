package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
       this.phonebook = map;
    }

    public PhoneBook() {
        phonebook = new HashMap <>();
    }

    public void add(String name, String phoneNumber) {
        if (!phonebook.containsKey(name)) 
        {
        phonebook.put(name, new ArrayList<>());
        }
        phonebook.get(name).add(phoneNumber);
    
    }

    public void addAll(String name, String... phoneNumbers) {
         if (!phonebook.containsKey(name)) {
        phonebook.put(name, new ArrayList<>());
    }

    List<String> numbersList = phonebook.get(name);
    for (String number : phoneNumbers) {
        numbersList.add(number);
    }

    }

    public void remove(String name) {
       phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
         return phonebook.get(name);

    }

    public String reverseLookup(String phoneNumber)  {
       for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) 
            {
                return entry.getKey();
            }
        }
        return null; // not found
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return  phonebook;
    }
}
