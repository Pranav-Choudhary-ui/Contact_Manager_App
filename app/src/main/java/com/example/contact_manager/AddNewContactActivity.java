package com.example.contact_manager;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.contact_manager.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private Contacts contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_contact);


        contacts = new Contacts();

        binding= DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_contact
        );


        // VIew Model
        MyViewModel myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);


        handler = new AddNewContactClickHandler(
                contacts,
                this,
                myViewModel
        );

        binding.setContact(contacts);
        binding.setClickHandler(handler);

    }
}