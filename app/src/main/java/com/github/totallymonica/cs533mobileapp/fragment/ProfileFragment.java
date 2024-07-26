package com.github.totallymonica.cs533mobileapp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.totallymonica.cs533mobileapp.R;
import com.github.totallymonica.cs533mobileapp.activity.MainActivity;
import com.github.totallymonica.cs533mobileapp.data.AccountsDatabaseHelper;
import com.github.totallymonica.cs533mobileapp.model.User;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    User user;

    public ProfileFragment() {
        // Required empty public constructor
    }
    public ProfileFragment(User nuser){
        this.user = nuser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("User Profile");

        TextView profile_name = view.findViewById(R.id.profile_name);
        TextView profile_email = view.findViewById(R.id.profile_email);
        TextView profile_number = view.findViewById(R.id.profile_number);
        TextView profile_address = view.findViewById(R.id.profile_address);

        if (user != null){
            //do something
            profile_name.setText(user.getName());
            profile_email.setText(user.getEmail());
            profile_number.setText(user.getMobile());
            profile_address.setText("an Address");
            
        }
    }
}
