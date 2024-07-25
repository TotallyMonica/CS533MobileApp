package com.github.totallymonica.cs533mobileapp.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.totallymonica.cs533mobileapp.data.AccountsDatabaseHelper;
import com.google.gson.Gson;
import com.github.totallymonica.cs533mobileapp.R;
import com.github.totallymonica.cs533mobileapp.activity.LoginRegisterActivity;
import com.github.totallymonica.cs533mobileapp.activity.MainActivity;
import com.github.totallymonica.cs533mobileapp.model.User;
import com.github.totallymonica.cs533mobileapp.util.CustomToast;
import com.github.totallymonica.cs533mobileapp.util.Utils;
import com.github.totallymonica.cs533mobileapp.util.localstorage.LocalStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CS533 Mobile App
 * https://github.com/TotallyMonica/CS533MobileApp
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
public class SignUp_Fragment extends Fragment implements OnClickListener {
    private static View view;
    private static EditText fullName, emailId, mobileNumber,
            password;
    private static TextView login;
    private static Button signUpButton;
    private static CheckBox terms_conditions;
    ProgressDialog progressDialog;
    User user;
    LocalStorage localStorage;
    Gson gson;

    public SignUp_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_layout, container, false);
        initViews();
        setListeners();
        return view;
    }

    // Initialize all views
    private void initViews() {
        fullName = view.findViewById(R.id.fullName);
        emailId = view.findViewById(R.id.userEmailId);
        mobileNumber = view.findViewById(R.id.mobileNumber);

        password = view.findViewById(R.id.password);
        signUpButton = view.findViewById(R.id.signUpBtn);
        login = view.findViewById(R.id.already_user);
        terms_conditions = view.findViewById(R.id.terms_conditions);
        progressDialog = new ProgressDialog(getContext());

        // Setting text selector over textviews
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            login.setTextColor(csl);
            terms_conditions.setTextColor(csl);
        } catch (Exception e) {
        }
    }

    // Set Listeners
    private void setListeners() {
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:

                // Call checkValidation method
                checkValidation();
                break;

            case R.id.already_user:

                // Replace login fragment
                new LoginRegisterActivity().replaceLoginFragment();
                break;
        }

    }

    // Check Validation Method
    private void checkValidation() {
        // Get all edit text texts
        String getFullName = fullName.getText().toString();
        String getEmailId = emailId.getText().toString();
        String getMobileNumber = mobileNumber.getText().toString();
        String getPassword = password.getText().toString();
        // Pattern match for email id
        Pattern p = Pattern.compile(Utils.regEx);
        Matcher m = p.matcher(getEmailId);


        if (getFullName.length() == 0) {
            fullName.setError("Enter Your Name");
            fullName.requestFocus();
        } else if (getEmailId.length() == 0) {
            emailId.setError("Enter Your Email");
            emailId.requestFocus();
        } else if (!m.find()) {
            emailId.setError("Enter Correct Email");
            emailId.requestFocus();
        } else if (getMobileNumber.length() == 0) {
            mobileNumber.setError("Enter Your Mobile Number");
            mobileNumber.requestFocus();
        } else if (getPassword.length() == 0) {
            password.setError("Enter Password");
            password.requestFocus();
        } else if (getPassword.length() < 6) {
            password.setError("Enter 6 digit Password");
            password.requestFocus();
        } else if (!terms_conditions.isChecked()) {
            new CustomToast().Show_Toast(getActivity(), view,
                    "Accept Term & Conditions");
        } else {
            user = new User(getFullName, getEmailId, getMobileNumber, getPassword);
            AccountsDatabaseHelper dbHelper = new AccountsDatabaseHelper(getContext());
            dbHelper.addOne(user);

            progressDialog.setMessage("Registering Data....");
            progressDialog.show();
            Handler mHand = new Handler();
            mHand.postDelayed(new Runnable() {

                @Override
                public void run() {
                    progressDialog.dismiss();
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                    getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }
            }, 5000);
        }
    }
}
