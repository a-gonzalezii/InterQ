package com.example.interq;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReviewTopicActivity extends ActionBarActivity{
    
    private String topic;
    
    private class ReviewSubTopicListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //create bundle send over which subtopic we are reviewing
            //start the ReviewParticularTopic
        }
        
    }
    
    
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_topic_activity);
        Bundle b = getIntent().getExtras();
        topic = b.getString("Topic");
     
        TextView heading = (TextView) findViewById(R.id.review_subtopic_heading); 
        heading.setText(topic+" : ");
        
        
        //May need to make this scroll-able
        
        /*
         * layout = (LinearLayout) findById
         * For (subtopic in topic){
         *   Button subtopicButton = new Button()
         *   ----adjust button and add id----
         *      setText
         *      setLayoutParams
         *      addListener
         *   layout.addView(Button)
         * 
         * 
         * 
         */
        
        
    }

}
