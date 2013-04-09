package com.example.interq;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReviewTopicActivity extends ActionBarActivity{
    private SQLiteDatabase db;
    private String topic;
    
   
    public class subtopicListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), ReviewParticularActivity.class);
            Button b = (Button) v;
            
            String topic = (String) b.getText();
            //TODO: IF TOPIC = RANDOM RANDOMLY CHOOSE NEW TOPIC
            i.putExtra("subtopic", topic);
            startActivity(i);            
        }
    }
    

    
    
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_topic_activity);
        Bundle b = getIntent().getExtras();
        topic = b.getString("Topic");
     
        TextView heading = (TextView) findViewById(R.id.review_subtopic_heading); 
        heading.setText(topic+" : ");
        
        
        //May need to make this scroll-able
        db = DatabaseHandler.getInstance(this).getReadableDatabase();
        String cmd = "SELECT * FROM subtopic WHERE topic=";
        
        Cursor data = db.rawQuery(cmd+Integer.toString(DatabaseHandler.getTopicId(db,topic)), null);
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.review_topic_buttons);
        
        for(data.move(0);  data.moveToNext();data.isAfterLast()){
            Button button = new Button(this);
            String name = data.getString(data.getColumnIndex("name"));
        
            button.setText(name);
            //button.setBackgroundColor(Color.parseColor("#84B88E"));
            button.setTextColor(Color.parseColor("#3160FC"));
            button.setLayoutParams(new LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(new subtopicListener());
            layout.addView(button);
        }
                
        
    }

}
