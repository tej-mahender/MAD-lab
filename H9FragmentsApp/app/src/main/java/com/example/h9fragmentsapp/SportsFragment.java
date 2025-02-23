package com.example.h9fragmentsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class SportsFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;

    public SportsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        lv = view.findViewById(R.id.lv_fragment);
        lv.setOnItemClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        try {
            Toast.makeText(getContext(), lv.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            Bundle bun = new Bundle();
            bun.putInt("SelectedItemIndex", i);
            getParentFragmentManager().setFragmentResult("requestKey", bun);
        } catch (Exception ex) {
            Log.d("EXCEPTION", "onItemClick: " + ex.getMessage());
            Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}