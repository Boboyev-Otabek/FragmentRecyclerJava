package com.example.fragmentrecyclerjava.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentrecyclerjava.Fragment.FirstFragment;
import com.example.fragmentrecyclerjava.MainActivity;
import com.example.fragmentrecyclerjava.Model.Contact;
import com.example.fragmentrecyclerjava.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Contact> contacts;
    FirstFragment activity;

    public ContactAdapter(List<Contact> contacts, FirstFragment activity) {

        this.contacts = contacts;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new Contactviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        if (holder instanceof Contactviewholder) {
            LinearLayout lay_click = ((Contactviewholder) holder).layout_id;
            TextView ism = ((Contactviewholder) holder).ism;
            TextView familiya = ((Contactviewholder) holder).familiya;
            ism.setText(contact.getIsm());
            familiya.setText(contact.getFamiliya());
            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.openDetail(contact);
                }
            });
        }

    }

    class Contactviewholder extends RecyclerView.ViewHolder {
        LinearLayout layout_id;
        TextView ism, familiya;
        View itemview;

        Contactviewholder(View view) {
            super(view);
            itemview = view;
            ism = itemview.findViewById(R.id.ism);
            familiya = itemview.findViewById(R.id.familiya);
            layout_id = itemview.findViewById(R.id.layout_id);
        }
    }
}
