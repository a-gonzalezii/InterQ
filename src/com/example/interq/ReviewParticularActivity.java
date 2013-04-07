package com.example.interq;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReviewParticularActivity extends ActionBarActivity {
    
    private String subtopic;
    private SQLiteDatabase db;
    private ArrayList<Integer> reviews;
    private String title;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_particular_activity);
        Bundle b = getIntent().getExtras();
        subtopic = b.getString("subtopic");       
        
        TextView titleText = (TextView) findViewById(R.id.review_particular_title);
        TextView descriptionText = (TextView) findViewById(R.id.review_particular_description);
        TextView topicText = (TextView) findViewById(R.id.review_particular_topic);
        
        db = DatabaseHandler.getInstance(this).getReadableDatabase();
        
        String cmd = "SELECT * FROM review WHERE subtopic=";
        
        //get/set title, description
        Cursor data = db.rawQuery(cmd+Integer.toString(DatabaseHandler.getSubTopicId(db, subtopic)), null);
        data.moveToFirst();        
        String firstTitle = data.getString(data.getColumnIndex("title"));
        for(data.move(0);data.isAfterLast();data.moveToNext()){
            Integer d = data.getInt(data.getColumnIndex("id"));
            reviews.add(d);
        }
        
        String description = data.getString(data.getColumnIndex("description"));
        String subtopicId = data.getString(data.getColumnIndex("subtopic"));
                
        titleText.setText(firstTitle);
        descriptionText.setText(description);
        
        //get/set topic text
        String subtopicCmd = "SELECT * FROM subtopic WHERE id=?";
        Cursor dataSubtopic = db.rawQuery(subtopicCmd,new String[]{subtopicId});
        dataSubtopic.moveToFirst();

        String topicId = Integer.toString(dataSubtopic.getInt(dataSubtopic.getColumnIndex("topic"))); 
        String topicCmd = "SELECT * FROM topic WHERE id=?";
        Cursor dataTopic = db.rawQuery(topicCmd,new String[]{topicId});
        Log.d("here","here");
        dataTopic.moveToFirst();
        
        String topic = dataTopic.getString(dataTopic.getColumnIndex("name"));
        topicText.setText(topic);
        Log.d("here","here");
    }
}
