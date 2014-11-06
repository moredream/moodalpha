package com.comfyard.moodalpha.custom;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.comfyard.moodalpha.R;

/**
 * Created by moredream on 11/6/14.
 */
public class FragmentTwo extends Fragment {
    private ImageView ivIcon;
    private TextView tvItemName;

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public FragmentTwo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_two, container, false);
        ivIcon = (ImageView) view.findViewById(R.id.frag2_icon);
        tvItemName = (TextView) view.findViewById(R.id.frag2_text);

        tvItemName.setText(getArguments().getString(ITEM_NAME));
        ivIcon.setImageDrawable(view.getResources().getDrawable(
                getArguments().getInt(IMAGE_RESOURCE_ID)));

        return view;
    }
}