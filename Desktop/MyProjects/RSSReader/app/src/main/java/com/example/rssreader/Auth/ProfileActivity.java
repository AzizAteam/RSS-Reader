package com.example.rssreader.Auth;

import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rssreader.Controllers.Activities.SignInActivity;
import com.example.rssreader.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {


    @BindView(R.id.profile_activity_imageview_profile)
     ImageView imageViewProfile;

    @BindView(R.id.profile_activity_edit_text_username)
    TextInputEditText textInputEditTextUsername;

    @BindView(R.id.profile_activity_text_view_email)
    TextView textViewEmail;

    @BindView(R.id.profile_activity_progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        updateUIWhenCreating();
    }


    private void updateUIWhenCreating(){

        if (FirebaseAuth.getInstance().getCurrentUser() != null){

            //Get picture URL from Firebase
            if (FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl() != null) {

                Glide.with(this)
                        .load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl())
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageViewProfile);
            }

            //Get email & username from Firebase
            String email = TextUtils.isEmpty(FirebaseAuth.getInstance().getCurrentUser().getEmail()) ? getString(R.string.info_no_email_found) : FirebaseAuth.getInstance().getCurrentUser().getEmail();
            String username = TextUtils.isEmpty(FirebaseAuth.getInstance().getCurrentUser().getDisplayName()) ? getString(R.string.info_no_username_found) : FirebaseAuth.getInstance().getCurrentUser().getDisplayName();

            //Update views with data
            this.textInputEditTextUsername.setText(username);
            this.textViewEmail.setText(email);
        }
    }
    public int getFragmentLayout() { return R.layout.activity_profile; }

    @OnClick(R.id.profile_activity_button_update)
    public void onClickUpdateButton() { }



}
