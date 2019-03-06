package com.example.myapplication103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StadiumAdapter extends ArrayAdapter<PlayGround> {


    private DatabaseReference mDatabase;

    public StadiumAdapter(Context context, ArrayList<PlayGround> playGrounds) {
        super(context, 0, playGrounds);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("stadium");

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PlayGround playGround = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stadium_view, parent, false);
        }

        TextView name, price, phone;
        ImageView edit, delete;


        name = (TextView) convertView.findViewById(R.id.stadium_name);
        price = (TextView) convertView.findViewById(R.id.product_price);
        phone = (TextView) convertView.findViewById(R.id.OPhone);

        name.setText(playGround.getName());
        price.setText("Price = " + playGround.getPrice());
        phone.setText("phone number : " + playGround.getPhone());


        return convertView;
    }
}













