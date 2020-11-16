package com.techsajib.chinesehelper.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.techsajib.chinesehelper.HomePage;
import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class FirebasePost extends AppCompatActivity {

    //for widget
    private RecyclerView recyclerView;
    //for firebase
    private DatabaseReference myRef;
    //for variables
    private ArrayList<FirebaseData> messageList;
    //fro recycler adapter
    private RecyclerAdapter recyclerAdapter;
    //for context
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebase_post);

        recyclerView = findViewById(R.id.firebase_recylerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // for HSK1 Toolbar settings here
        Toolbar toolbar = findViewById(R.id.firebase_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for firebase section
        myRef = FirebaseDatabase.getInstance().getReference();

        //for Arraylist
        messageList = new ArrayList<>();

        //for clear Arraylist
        ClearAll();

        // get data method
        GetDataFromFirebase();

    }




    private void GetDataFromFirebase() {

        Query query = myRef.child("post");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    FirebaseData firebaseData = new FirebaseData();

                    firebaseData.setImage(snapshot.child("image").getValue().toString());
                    firebaseData.setTitle(snapshot.child("title").getValue().toString());
                    firebaseData.setDescription(snapshot.child("description").getValue().toString());

                    messageList.add(firebaseData);
                }

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), messageList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void ClearAll(){
        if (messageList != null){
            messageList.clear();

            if (recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }

        messageList = new ArrayList<>();
    }


}