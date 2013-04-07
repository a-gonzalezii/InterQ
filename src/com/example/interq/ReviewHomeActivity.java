package com.example.interq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ReviewHomeActivity extends ActionBarActivity{

    private List<String> TOPICS;
    private Random rand;

    public class ReviewTopicListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), ReviewTopicActivity.class);
            Button b = (Button) v;
            String topic = (String) b.getText();
            if(topic.equals("Random")){
                topic = TOPICS.get(rand.nextInt(TOPICS.size()));
            }
            i.putExtra("Topic", topic);
            startActivity(i);            
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_home_activity);
        
        TOPICS = new ArrayList<String>();
        rand = new Random();
        
        TOPICS.add("Sorting");
        TOPICS.add("Data Structures");
        TOPICS.add("Graph Theory");
        TOPICS.add("Selected Topics");
        
        Button bTopic1 = (Button) findViewById(R.id.reviewtopic1);
        bTopic1.setOnClickListener(new ReviewTopicListener());
        
        Button bTopic2 = (Button) findViewById(R.id.reviewtopic2);
        bTopic2.setOnClickListener(new ReviewTopicListener());

        Button bTopic3 = (Button) findViewById(R.id.reviewtopic3);
        bTopic3.setOnClickListener(new ReviewTopicListener());
        /*
        Button bTopic4 = (Button) findViewById(R.id.reviewtopic4);
        bTopic4.setOnClickListener(new ReviewTopicListener());
        */
        Button bTopic5 = (Button) findViewById(R.id.reviewtopic5);
        bTopic5.setOnClickListener(new ReviewTopicListener());
        
        Button bTopicR = (Button) findViewById(R.id.reviewtopicRandom);
        bTopicR.setOnClickListener(new ReviewTopicListener());
    }
    
    
    
}
