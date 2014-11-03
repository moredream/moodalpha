package com.comfyard.moodalpha;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by moredream on 10/31/14.
 */
public class DetailFragment extends Fragment {
     TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View view =  super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.menu_detail_fragment, container, false);
        String menu = getArguments().getString("Menu");
        text= (TextView) view.findViewById(R.id.detail);
        text.setText(menu);
        return view;
    }
}
