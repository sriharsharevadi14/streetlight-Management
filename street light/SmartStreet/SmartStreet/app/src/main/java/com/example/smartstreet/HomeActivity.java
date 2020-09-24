package com.example.smartstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartstreet.Db.DBCon;
import com.example.smartstreet.Db.Mode;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
    Button auto_btn,rf_btn,app_btn,layout_btn;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auto_btn = (Button)findViewById(R.id.auto_btn);
        rf_btn = (Button)findViewById(R.id.rf_btn);
        app_btn = (Button)findViewById(R.id.app_btn);
        layout_btn = (Button)findViewById(R.id.layout_btn);
        databaseReference= DBCon.getRef().child("Mode").child("1");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Mode mode = dataSnapshot.getValue(Mode.class);
                if (mode!=null) {
                    if (mode.getMode().equalsIgnoreCase("auto")) {
                        auto_btn.setBackgroundColor(Color.BLUE);
                        rf_btn.setBackgroundColor(Color.DKGRAY);
                        app_btn.setBackgroundColor(Color.DKGRAY);
                        layout_btn.setEnabled(false);
                    } else if (mode.getMode().equalsIgnoreCase("rf")) {
                        auto_btn.setBackgroundColor(Color.DKGRAY);
                        rf_btn.setBackgroundColor(Color.BLUE);
                        app_btn.setBackgroundColor(Color.DKGRAY);
                        layout_btn.setEnabled(false);
                    }   if (mode.getMode().equalsIgnoreCase("app")) {
                        auto_btn.setBackgroundColor(Color.DKGRAY);
                        rf_btn.setBackgroundColor(Color.DKGRAY);
                        app_btn.setBackgroundColor(Color.BLUE);
                        layout_btn.setEnabled(true);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        auto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mode mode= new Mode();
                mode.setId("1");
                mode.setMode("auto");
                databaseReference.setValue(mode).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Automatic Mode Activated",Toast.LENGTH_LONG).show();
                        auto_btn.setBackgroundColor(Color.GREEN);
                        rf_btn.setBackgroundColor(Color.DKGRAY);
                        app_btn.setBackgroundColor(Color.DKGRAY);
                        layout_btn.setEnabled(false);
                    }
                });
            }
        });
        rf_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mode mode= new Mode();
                mode.setId("1");
                mode.setMode("rf");
                databaseReference.setValue(mode).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"RF Mode Activated",Toast.LENGTH_LONG).show();
                        auto_btn.setBackgroundColor(Color.DKGRAY);
                        rf_btn.setBackgroundColor(Color.GREEN);
                        app_btn.setBackgroundColor(Color.DKGRAY);
                        layout_btn.setEnabled(false);
                    }
                });
            }
        });

        app_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mode mode= new Mode();
                mode.setId("1");
                mode.setMode("app");
                databaseReference.setValue(mode).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Application Mode Activated",Toast.LENGTH_LONG).show();
                        auto_btn.setBackgroundColor(Color.DKGRAY);
                        rf_btn.setBackgroundColor(Color.DKGRAY);
                        app_btn.setBackgroundColor(Color.GREEN);
                        layout_btn.setEnabled(true);
                    }
                });
            }
        });
        layout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
