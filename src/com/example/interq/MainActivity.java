package com.example.interq;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button bQuestions = (Button) findViewById(R.id.homeQuestionButton);
        bQuestions.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), QuestionHomeActivity.class);
                startActivity(i);
            }
        });
        
        Button bReview = (Button) findViewById(R.id.homeReviewButton);
        bReview.setOnClickListener(new OnClickListener(){
           @Override
           public void onClick(View v){
               Intent i = new Intent(v.getContext(), ReviewHomeActivity.class);
               startActivity(i);
           }
        });
        
        Button bForum = (Button) findViewById(R.id.homeForumButton);
        bForum.setOnClickListener(new OnClickListener(){
           @Override
           public void onClick(View v){
               Intent i = new Intent(v.getContext(), ForumHomeActivity.class);
               startActivity(i);
           }
        });
        
        Button bSettings = (Button) findViewById(R.id.homeSettingsButton);
        bSettings.setOnClickListener(new OnClickListener(){
           @Override
           public void onClick(View v){
               Intent i = new Intent(v.getContext(), SettingsHomeActivity.class);
               startActivity(i);
           }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
