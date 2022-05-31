package com.example.fragmentrecyclerjava.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentrecyclerjava.Adapter.ContactAdapter;
import com.example.fragmentrecyclerjava.Model.Contact;
import com.example.fragmentrecyclerjava.R;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    FirstListener listener;
    static final String TAG=FirstFragment.class.toString();
    RecyclerView recyclerview;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first,container,false);
        initView(view);
        return view;
    }
    void initView (View view){
        recyclerview=view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(context,1));

        List<Contact> contacts=AddContct();
        refreshAdapter(contacts);
    }
    void refreshAdapter(List<Contact> contacts){
        ContactAdapter adapter=new ContactAdapter(contacts,this);
        recyclerview.setAdapter(adapter);
    }

    public void openDetail(Contact contact){
        Log.d("@@@","item is clicked "+contact.getIsm());

        listener.onFirstSend(contact.getIsm()+"\n\n"+contact.getFamiliya());
    }
    List<Contact> AddContct(){
        List<Contact> contacts=new ArrayList<>();
        for(int i=0; i<20; i++){
            contacts.add(new Contact("Otabek "+i,"Boboyev "+i));
        }
        return contacts;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FirstListener){
            listener=(FirstListener) context;
        }else{
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    public interface FirstListener{
        void onFirstSend(String str);
    }
}
