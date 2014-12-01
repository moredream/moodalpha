package com.comfyard.moodalpha;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comfyard.moodalpha.authentication.AuthenticatorActivity;
import com.comfyard.moodalpha.member.MemberActivity;
import com.comfyard.moodalpha.menu.CustomDrawerAdapter;
import com.comfyard.moodalpha.menu.DrawerItem;
import com.comfyard.moodalpha.menu.FragmentOne;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    CustomDrawerAdapter adapter;

    List<DrawerItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Parse SDK Test
//        Parse.initialize(this, "q9ls8GDvd3AtGxZ5JHSrFxMbXomjxEpcJ7An5MQR", "0X26QK96Bem68Pfk2nyWQP4DguqvhKrLIHNQBx5E");
//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();

        dataList = new ArrayList<DrawerItem>();

        mTitle = mDrawerTitle = getTitle();
        //mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        /*
        set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mPlanetTitles));
        Add Drawer Item to dataList
        TODO: Change pre-define or xml.
        */
        dataList.add(new DrawerItem("Mood", R.drawable.ic_action_labels));
        dataList.add(new DrawerItem("MoodList", R.drawable.ic_action_labels));
        dataList.add(new DrawerItem("Login", R.drawable.ic_action_labels));
        dataList.add(new DrawerItem("Member", R.drawable.ic_action_group));
        dataList.add(new DrawerItem("My", R.drawable.ic_action_about));
        dataList.add(new DrawerItem("Settings", R.drawable.ic_action_settings));
        dataList.add(new DrawerItem("Things", R.drawable.ic_action_good));
        dataList.add(new DrawerItem("FullScreen", R.drawable.ic_action_gamepad));

        adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item, dataList);

        mDrawerList.setAdapter(adapter);


        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }



        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectMenuItem(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_moods).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        Intent intent;
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

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

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //selectItem(position);
            selectMenuItem(position);
        }
    }

    public void selectMenuItem(int position) {
        Intent intent;
        FragmentManager frgManager = getFragmentManager();


        Fragment fragment = null;
        Bundle args = new Bundle();

        switch (position) {
            case 0:
//                fragment = new MoodFragment();
//                frgManager.beginTransaction().replace(R.id.container, fragment).commit();
                fragment = new FragmentOne();
                args.putString(FragmentOne.ITEM_NAME, dataList.get(position)
                        .getItemName());
                args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(position)
                        .getImgResID());
                fragment.setArguments(args);
                frgManager = getFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();
                break;
            case 1:
                intent = new Intent(this, MoodActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, AuthenticatorActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, MemberActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, MyActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, ThingActivity.class);
                startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, FullscreenActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }



        mDrawerList.setItemChecked(position, true);
        setTitle(dataList.get(position).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}
