package com.example.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {


    ListItemClicked activity;

    public interface ListItemClicked
    {
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity= (ListItemClicked) context;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Part 1
      /*  ArrayList<String> data= new ArrayList<String>();
        data.add("Data item 1");
        data.add("Data item 2");
        data.add("Item 3");
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));


       */
        //Part2
        String [] data;
        data =getResources().getStringArray(R.array.pieces);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data));


        if (this.getActivity().findViewById(R.id.layout_land)!=null) {
            activity.onItemSelected(0);
        }


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        activity.onItemSelected(position);

    }
}
