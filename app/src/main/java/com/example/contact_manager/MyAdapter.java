package com.example.contact_manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact_manager.databinding.ContactListBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contact;

    public MyAdapter(ArrayList<Contacts> contact) {
        this.contact = contact;
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        private ContactListBinding contactListBinding;

        public ContactViewHolder(@NonNull ContactListBinding contactListBinding) {
            super(contactListBinding.getRoot());
            this.contactListBinding = contactListBinding;
        }
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListBinding contactListBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.contact_list,
                        parent,
                        false
                );

        return new ContactViewHolder(contactListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts currentContact  = contact.get(position);

        holder.contactListBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {
        if (contact != null){
            return contact.size();
        }else {
            return 0;
        }
    }

    public void setContact(ArrayList<Contacts> contact) {
        this.contact = contact;
        notifyDataSetChanged();
    }
}
