package com.example.objects;

public class Fact {
    
    private String title;
    private String description;

    public Fact(String title, String description){
        this.title = title;
        this.description = description;
    }
    
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    
}
