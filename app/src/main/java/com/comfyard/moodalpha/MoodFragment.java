package com.comfyard.moodalpha;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class MoodFragment extends Fragment {


    public MoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create some dummy data for the ListView.  Here's a sample weekly forecast
        String[] data = {
                "Wine",
                "Gather",
                "Food",
                "Sightseeing",
                "Music",
                "Drinking",
                "Shopping",
                "Club"
        };

        List<String> moodList = new ArrayList<String>(Arrays.asList(data));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_mood,
                R.id.list_item_mood_textview,
                moodList);

        View rootView = inflater.inflate(R.layout.fragment_mood, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_mood);
        listView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return rootView;
    }


}
