package com.example.interq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActionBarActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.:
                startActivity(new Intent(this,QuestionHomeActivity.class));
                break;
            case R.id.:
                startActivity(new Intent(this,ReviewHomeActivity.class));
                break;
            case R.id.:
                startActivity(new Intent(this,ForumHomeActivity.class));
                break;
            default:
                break;
        }
        
        return true;
    }*/
    
}
