package com.example.interq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ReviewHomeActivity extends ActionBarActivity{


    public class ReviewTopicListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), ReviewTopicActivity.class);
            Button b = (Button) v;
            //TODO: change this depending on how we store information for topics/archive
            String topic = (String) b.getText();
            //TODO: IF TOPIC = RANDOM RANDOMLY CHOOSE NEW TOPIC
            i.putExtra("Topic", topic);
            startActivity(i);            
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_home_activity);
        
        Button bTopic1 = (Button) findViewById(R.id.reviewtopic1);
        bTopic1.setOnClickListener(new ReviewTopicListener());
        
        Button bTopic2 = (Button) findViewById(R.id.reviewtopic2);
        bTopic2.setOnClickListener(new ReviewTopicListener());

        Button bTopic3 = (Button) findViewById(R.id.reviewtopic3);
        bTopic3.setOnClickListener(new ReviewTopicListener());
        
        Button bTopic4 = (Button) findViewById(R.id.reviewtopic4);
        bTopic4.setOnClickListener(new ReviewTopicListener());
        
        Button bTopic5 = (Button) findViewById(R.id.reviewtopic5);
        bTopic5.setOnClickListener(new ReviewTopicListener());
        
        Button bTopicR = (Button) findViewById(R.id.reviewtopicRandom);
        bTopicR.setOnClickListener(new ReviewTopicListener());
    }
    
    
    
}
