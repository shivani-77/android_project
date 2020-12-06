package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference ref;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Event");


    }
    protected void onStart() {

        super.onStart();
        FirebaseRecyclerAdapter<event,holder>firebaseRecyclerAdapter=
            new FirebaseRecyclerAdapter<event, holder> (
                event.class,
                R.layout.data,
                holder.class,
                ref
        ){

                @Override
                protected void populateViewHolder(holder holder, event event, int i) {
                    holder.setView(getApplicationContext(),event.getEventDetail(),event.getEventId(),event.getEventImage(),event.getEventName());

                }
            };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
}
}