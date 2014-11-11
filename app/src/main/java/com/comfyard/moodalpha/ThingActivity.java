package com.comfyard.moodalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ThingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thing);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.thing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        Intent intent;


        // Handle action buttons
        switch(item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.action_moods:
                intent = new Intent(this, MoodActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_things:
                intent = new Intent(this, ThingActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_main   :
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_settings:
                //Settings
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
