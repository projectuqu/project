package com.example.myapplication103;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

    public class AddStadiumActivity extends AppCompatActivity {

        private DatabaseReference mDatabase;

        TextInputEditText name,price,phone;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_stadium_activity);

            name=(TextInputEditText) findViewById(R.id.add_name);
            price=(TextInputEditText)findViewById(R.id.add_price);
            phone=(TextInputEditText)findViewById(R.id.add_phone);


            mDatabase = FirebaseDatabase.getInstance().getReference();

        }


        public void add (View view)
        {
            String nameText,priceText,phoneText;

            nameText =name.getText().toString();
            priceText =price.getText().toString();
            phoneText =phone.getText().toString();

            if(nameText.isEmpty()||nameText.equals(" "))
            {
                name.setError("Fill here please !");
                return;
            }

            if(priceText.isEmpty()||priceText.equals(" "))
            {
                price.setError("Fill here please !");
                return;
            }

            if(phoneText.isEmpty()||phoneText.equals(" "))
            {
                phone.setError("Fill here please !");
                return;
            }

            PlayGround playGround =new PlayGround(nameText , priceText , phoneText);

            String key = mDatabase.child("stadium").push().getKey();
            playGround.setId(key);

            mDatabase.child("stadium").child(key).setValue(playGround);

            name.setText("");
            price.setText("");
            phone.setText("");


        }
    }
