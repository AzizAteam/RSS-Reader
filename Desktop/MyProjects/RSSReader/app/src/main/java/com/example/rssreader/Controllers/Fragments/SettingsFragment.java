package com.example.rssreader.Controllers.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rssreader.Auth.ProfileActivity;
import com.example.rssreader.Controllers.Activities.MainActivity;
import com.example.rssreader.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    @BindView(R.id.profile_button)
    Button profileButton;
    @BindView(R.id.log_out_button)
    Button logOutButton;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        return (new SettingsFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.profile_button)
    public void onClickProfileButton() {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        startActivity(intent);
    }

    private void signOutUserFromFirebase() {
        AuthUI.getInstance()
                .signOut(getContext())
                .addOnSuccessListener(getActivity(), this.updateUIAfterRESTRequestsCompleted());
    }


    @OnClick(R.id.log_out_button)
    public void onClickLogOutButton() {
        this.signOutUserFromFirebase();
    }

    private OnSuccessListener<Void> updateUIAfterRESTRequestsCompleted() {
        return new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                getActivity().finish();
            }
        };
    }
}
