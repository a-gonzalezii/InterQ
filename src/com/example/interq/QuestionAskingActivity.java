package com.example.interq;

import java.util.ArrayList;
import java.util.Random;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
    ArrayList<Integer> questions;
    
    
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_asking_activity);
    
        TextView TOPIC = (TextView) findViewById(R.id.question_asking_topic);
        TextView TITLE = (TextView) findViewById(R.id.question_asking_title);
        Button NEXT = (Button) findViewById(R.id.question_asking_next_button);
        TextView DESCRIPTION = (TextView) findViewById(R.id.question_asking_description);
        LinearLayout SUBLAYOUT = (LinearLayout) findViewById(R.id.question_asking_submission_fill_in);
        EditText SUBFIELD = (EditText) findViewById(R.id.question_asking_submission_field);
        Button HIDEBUTTON = (Button) findViewById(R.id.question_asking_hide_button);
        TextView HINT = (TextView) findViewById(R.id.question_asking_hint);
        
        Bundle b = getIntent().getExtras();
        topic = b.getString("topic");
        
        TOPIC.setText(topic);
        
        db = DatabaseHandler.getInstance(this).getReadableDatabase();
        
        String cmd = "SELECT * FROM questions WHERE topic=?";
        Cursor data = db.rawQuery(cmd,new String[] {topic});
        
        for(data.move(0);data.moveToNext();data.isAfterLast()){
            questions.add(data.getInt(data.getColumnIndex("id")));
        }
        
        data.move(r.nextInt(data.getCount()));
        String title = data.getString(data.getColumnIndex("title"));
        TITLE.setText(title);
        
        String description = data.getString(data.getColumnIndex("description"));
        DESCRIPTION.setText(description);
        
        String hint = data.getString(data.getColumnIndex("hint"));
        HINT.setText(hint);
        
        String type = data.getString(data.getColumnIndex("type"));
        if(type.equals("coding")){
            //TODO: ALTER TO MAKE THE BOX BIGGER
        }
        
        
    }
    public class HideListener implements OnClickListener{

        private Integer STATE = 0;
        private String hintStr;
        
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Button HIDEBUTTON = (Button) findViewById(R.id.question_asking_hide_button);
            TextView HINT = (TextView) findViewById(R.id.question_asking_hint);
            hintStr = HINT.getText().toString();
            
            switch(STATE){
            case 0:
                HIDEBUTTON.setText("Show Answer");
                HINT.setVisibility(View.VISIBLE);
                STATE = 1;
                break;
            case 1:
                HIDEBUTTON.setText("Hide Hint");
                //TODO: hint.setText(ANSWER)
                STATE = 2;
                break;
            default:
                HIDEBUTTON.setText("Show Hint");
                HINT.setVisibility(View.GONE);
                HINT.setText(hintStr);
                STATE = 0;
                
            }
            
        }
        
        
    }
    
    //TODO: generate next
    //TODO: generate the button to look at review section
    //TODO: generate answer generation

}
