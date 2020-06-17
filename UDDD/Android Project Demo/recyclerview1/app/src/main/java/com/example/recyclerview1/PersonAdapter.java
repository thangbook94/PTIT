package com.example.recyclerview1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{


    public ArrayList<Person> people;
    public PersonAdapter (Context context,ArrayList<Person> list)
    {
        people=list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPref;
        TextView tvName,tvSurname;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName =itemView.findViewById(R.id.tvName);
            tvSurname=itemView.findViewById(R.id.tvSurName);
            ivPref=itemView.findViewById(R.id.ivPref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));


        viewHolder.tvName.setText(people.get(i).getName());
        viewHolder.tvSurname.setText(people.get(i).getSurName());


        if (people.get(i).getPreference().equals("bus"))
        {
            viewHolder.ivPref.setImageResource(R.drawable.bus);

        }
        else
        {
            viewHolder.ivPref.setImageResource(R.drawable.fly);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
