package com.example.interq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuestionHomeActivity extends ActionBarActivity{

    public class QuestionTopicListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), QuestionAskingActivity.class);
            Button b = (Button) v;
            //TODO: change this depending on how we store information for topics/archive
            String topic = (String) b.getText();
            i.putExtra("Topic", topic);
            startActivity(i);            
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_home_activity);
        
        Button bTopic1 = (Button) findViewById(R.id.questiontopic1);
        bTopic1.setOnClickListener(new QuestionTopicListener());
        
        Button bTopic2 = (Button) findViewById(R.id.questiontopic2);
        bTopic2.setOnClickListener(new QuestionTopicListener());

        Button bTopic3 = (Button) findViewById(R.id.questiontopic3);
        bTopic3.setOnClickListener(new QuestionTopicListener());
        /*
        Button bTopic4 = (Button) findViewById(R.id.questiontopic4);
        bTopic4.setOnClickListener(new QuestionTopicListener());
        */
        Button bTopic5 = (Button) findViewById(R.id.questiontopic5);
        bTopic5.setOnClickListener(new QuestionTopicListener());
        
        Button bTopicR = (Button) findViewById(R.id.questiontopicRandom);
        bTopicR.setOnClickListener(new QuestionTopicListener());
    }
    
}
