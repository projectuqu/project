package com.example.myapplication103;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    ArrayList<PlayGround> playGrounds;
    ListView StadiumsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        StadiumsList=(ListView) findViewById(R.id.PlayGround_list);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("stadium");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playGrounds = new ArrayList<>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    PlayGround playGround = postSnapshot.getValue(PlayGround.class);
                    playGrounds.add(playGround);
                }

                StadiumAdapter adapter = new StadiumAdapter(HomeActivity.this, playGrounds);


                StadiumsList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    public void add_stadium(View view)
    {
        Intent addStadiumIntent =new Intent(HomeActivity.this,AddStadiumActivity.class);
        startActivity(addStadiumIntent);
    }
}