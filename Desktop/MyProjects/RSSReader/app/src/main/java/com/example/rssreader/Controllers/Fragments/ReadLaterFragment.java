package com.example.rssreader.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rssreader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadLaterFragment extends Fragment {


    public ReadLaterFragment() {
        // Required empty public constructor
    }
    public static ReadLaterFragment newInstance () {
        return (new ReadLaterFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read_later, container, false);
    }

}
