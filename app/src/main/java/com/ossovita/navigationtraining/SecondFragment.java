package com.ossovita.navigationtraining;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {
        
    Button second_fragment_button;
    private int myAge = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        second_fragment_button = view.findViewById(R.id.second_fragment_button);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()!=null){
            myAge= SecondFragmentArgs.fromBundle(savedInstanceState).getAge();
            System.out.println("myAge: " + myAge);
        }



        second_fragment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections directions = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
                Navigation.findNavController(view).navigate(directions);
            }
        });


    }
}