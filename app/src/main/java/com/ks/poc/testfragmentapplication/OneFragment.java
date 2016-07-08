package com.ks.poc.testfragmentapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Krit on 7/6/2016.
 */
public class OneFragment extends Fragment {

    public EditText ev;
    public TextView tv;
    private CompoundClass testObj;
    private TextView txtObj;
    private String strtext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Toast.makeText(getActivity(), "OneFragment onCreateView", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.one_view, container, false);
        ev = (EditText) view.findViewById(R.id.editText1);
        tv = (TextView) view.findViewById(R.id.textViewOne);
        txtObj = (TextView) view.findViewById(R.id.txtTestObj);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (tv != null)
//            tv.setText("onResume");
    }

    public void displayObject() {
        if (txtObj != null)
            txtObj.setText("");
        if ((txtObj != null) && (this.testObj != null))
            txtObj.setText(this.testObj.toMultiLineString());
    }

    public CompoundClass getTestObj() {
        return testObj;
    }

    public void setTestObj(CompoundClass testObj) {
        this.testObj = testObj;
        displayObject();
    }
}

