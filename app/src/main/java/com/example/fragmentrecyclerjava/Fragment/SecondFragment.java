package com.example.fragmentrecyclerjava.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentrecyclerjava.R;

public class SecondFragment extends Fragment {

    TextView txt_second;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second,container,false);
        txt_second=view.findViewById(R.id.txt_second);

        return view;
    }
  public   void updateSecondText(String str){
        txt_second.setText(str);
  }
}
