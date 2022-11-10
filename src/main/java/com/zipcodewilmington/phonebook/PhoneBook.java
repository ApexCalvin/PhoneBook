package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


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

        this(new LinkedHashMap<String, List<String>>()); //"Linked" sorts HashMap
    } //nullary constructor

    public void add(String name, String phoneNumber) {
        phonebook.put(name, new ArrayList<String>());
        // ( KEY , VALUE ) CREATING ARRAY LIST NAMED 'KEY' VALUE
        // *KEY TO THE ARRAY LIST*
        phonebook.get(name).add(phoneNumber);
        // GRAB KEY, ADDING TO VALUE (ARRAY LIST)
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<String>(List.of(phoneNumbers)));

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        Set<String> keys = phonebook.keySet(); //get all keys
        StringBuilder sb = new StringBuilder();
       for (String s : keys) {
           if(phonebook.get(s).contains(phoneNumber)){
               sb.append(s);
               //System.out.println("Key is: " + s);
           }
       }
       return sb.toString();
    }

    public List<String> getAllContactNames() {
        Set<String> keys = phonebook.keySet(); //.keySet returns all keys in map, returns list
        List<String> result = new ArrayList<>(keys); //restore as array list
        return result;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
