package com.example.interq;

import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionAskingActivity extends ActionBarActivity{

    private String topic;
    private SQLiteDatabase db;
    Random r = new Random();
    
    private TextView TOPIC;
    private TextView TITLE;
    private Button NEXT ;
    private TextView DESCRIPTION;
    private LinearLayout FILLINLAYOUT;
    private LinearLayout CODINGLAYOUT;
    private EditText FILLINFIELD;
    private EditText CODINGFIELD;
    private Button HINTBUTTON;
    private TextView HINT;
    private String ANSWER;
    private String HintStr;
    private Cursor data;
    
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_asking_activity);
        
        
        TOPIC = (TextView) findViewById(R.id.question_asking_topic);
        TITLE = (TextView) findViewById(R.id.question_asking_title);
        NEXT = (Button) findViewById(R.id.question_asking_next_button);
        DESCRIPTION = (TextView) findViewById(R.id.question_asking_description);
        FILLINLAYOUT = (LinearLayout) findViewById(R.id.question_asking_submission_fill_in);
        CODINGLAYOUT = (LinearLayout) findViewById(R.id.question_asking_submission_coding);
        FILLINFIELD = (EditText) findViewById(R.id.question_asking_submission_field);
        CODINGFIELD = (EditText) findViewById(R.id.question_asking_coding_field);
        HINTBUTTON = (Button) findViewById(R.id.question_asking_hint_button);
        HINT = (TextView) findViewById(R.id.question_asking_hint);
        
        
        
        Bundle b = getIntent().getExtras();
        topic = b.getString("topic");
        
        TOPIC.setText(topic);
        
        db = DatabaseHandler.getInstance(this).getReadableDatabase();
        
        String cmd = "SELECT * FROM questions WHERE topic=?";
        
        data = db.rawQuery(cmd,new String[] {Integer.toString(DatabaseHandler.getTopicId(db,topic))});
        
        int newI = r.nextInt(data.getCount())+1;
        Log.d("here","here");
        data.move(newI);
        initiate();
        
    }
    
    
    public class HintListener implements OnClickListener{

        private Integer STATE = 0;
        
        @Override
        public void onClick(View arg0) {
                 
            switch(STATE){
            case 0:
                HINTBUTTON.setText("Show Answer");
                HINT.setVisibility(View.VISIBLE);
                HINT.setText(HintStr);
                STATE = 1;
                break;
            case 1:
                HINTBUTTON.setText("Hide Hint");
                HINT.setText(ANSWER);
                Log.d("you should see", ANSWER+" right?");
                STATE = 2;
                break;
            default:
                HINTBUTTON.setText("Show Hint");
                HINT.setVisibility(View.GONE);
                STATE = 0;
                break;
                
            }
            
        }
        
        
    }
    
    public class NextListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            data.moveToNext();
            
            HINTBUTTON.setText("Show Hint");
            HINT.setVisibility(View.GONE);
            
            if(data.isAfterLast()){
                data.moveToFirst();
            }
            initiate();
            
        }
        
    }
    
    private void initiate(){       
        HINTBUTTON.setOnClickListener(new HintListener());
        NEXT.setOnClickListener(new NextListener());

        String title = data.getString(data.getColumnIndex("title"));
        TITLE.setText(title);

        String description = data.getString(data.getColumnIndex("description"));
        DESCRIPTION.setText(description);

        HintStr = data.getString(data.getColumnIndex("hint"));
        HINT.setText(HintStr);
        
        ANSWER = data.getString(data.getColumnIndex("answer"));
        

        String type = data.getString(data.getColumnIndex("type"));
        if(type.equals("coding")){
            FILLINLAYOUT.setVisibility(View.GONE);
            CODINGLAYOUT.setVisibility(View.VISIBLE);
        }
    }
    //TODO: generate next
    //TODO: generate the button to look at review section
    /* Intent i = new Intent(arg0.getContext(),ReviewTopicActivity.class);
    i.putExtra("Topic",topic);
    startActivity(i);*/
    //TODO: generate answer generation

}
