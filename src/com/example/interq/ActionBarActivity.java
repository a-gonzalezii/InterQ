package com.example.interq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActionBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.home_tab:
            startActivity(new Intent(this, MainActivity.class));
            break;
        case R.id.questions_tab:
            startActivity(new Intent(this, QuestionHomeActivity.class));
            break;
        case R.id.review_tab:
            startActivity(new Intent(this, ReviewHomeActivity.class));
            break;
        case R.id.forum_tab:
            startActivity(new Intent(this, ForumHomeActivity.class));
            break;
        default:
            break;
        }

        return true;
    }

}
