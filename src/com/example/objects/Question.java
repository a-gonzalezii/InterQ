package com.example.objects;

public class Question {

    private String title;
    private String description;
    private String hint;
    private String reviewLink;
    private String forumLink;
    private String answer;
    private QType questionType;
    
    public Question(String t, String d, String h, String r, String f, String a, Character q){
        title = t; description = d; hint = h; reviewLink = r; forumLink = f; answer = a;
        if(q.equals('c')){
            questionType = QType.CODING;
        }else if(q.equals('f')){
            questionType = QType.FILLIN;
        }else{
            throw new RuntimeException("Received an unknown question type");
        }
    }
    
    
    
    
    
    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getHint(){
        return hint;
    }
    public String getReviewLink(){
        return reviewLink;
    }
    public String getForumLink(){
        return forumLink;
    }
    public String getAnswer(){
        return answer;
    }
    //TODO: return a way to get the size we need for the input box.
    
    
    
    
    
    
    
    
    
    
    public enum QType{
        CODING, FILLIN;
    }
    
}
