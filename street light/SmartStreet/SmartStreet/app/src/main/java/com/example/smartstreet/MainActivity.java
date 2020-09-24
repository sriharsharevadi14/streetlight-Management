package com.example.smartstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartstreet.Db.DBCon;
import com.example.smartstreet.Db.Status;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    Button onAll, oneOnButton,twoOnButton,threeOnButton,fourOnButton,fiveOnButton;
    Button offAll, oneOffButton,twoOffButton,threeOffButton,fourOffButton,fiveOffButton;
    Status status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference= DBCon.getRef().child("Status").child("1");
        onAll = (Button)findViewById(R.id.onAll);
        oneOnButton = (Button)findViewById(R.id.oneOnButton);
        oneOffButton = (Button)findViewById(R.id.oneOffButton);
        twoOnButton = (Button)findViewById(R.id.twoOnButton);
        twoOffButton = (Button)findViewById(R.id.twoOffButton);
        threeOnButton = (Button)findViewById(R.id.threeOnButton);
        threeOffButton = (Button)findViewById(R.id.threeOffButton);
        fourOnButton = (Button)findViewById(R.id.fourOnButton);
        fourOffButton = (Button)findViewById(R.id.fourOffButton);
        fiveOnButton = (Button)findViewById(R.id.fiveOnButton);
        fiveOffButton = (Button)findViewById(R.id.fiveOffButton);
        offAll = (Button)findViewById(R.id.offAll);
        oneOnButton.setBackgroundColor(Color.DKGRAY);
        twoOnButton.setBackgroundColor(Color.DKGRAY);
        threeOnButton.setBackgroundColor(Color.DKGRAY);
        fourOnButton.setBackgroundColor(Color.DKGRAY);
        fiveOnButton.setBackgroundColor(Color.DKGRAY);
        oneOffButton.setBackgroundColor(Color.DKGRAY);
        twoOffButton.setBackgroundColor(Color.DKGRAY);
        threeOffButton.setBackgroundColor(Color.DKGRAY);
        fourOffButton.setBackgroundColor(Color.DKGRAY);
        fiveOffButton.setBackgroundColor(Color.DKGRAY);
        onAll.setBackgroundColor(Color.DKGRAY);
        offAll.setBackgroundColor(Color.DKGRAY);

        offAll = (Button)findViewById(R.id.offAll);
        status = new Status();
        status.setId("1");
        status.setOne("Off");
        status.setTwo("Off");
        status.setThree("Off");
        status.setFour("Off");
        status.setFive("Off");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Status status1 = dataSnapshot.getValue(Status.class);
                if (status1==null){
                    databaseReference.setValue(status);
                } else {
                    if (status1.getOne().equalsIgnoreCase("On")) {
                        oneOnButton.setBackgroundColor(Color.GREEN);
                        oneOffButton.setBackgroundColor(Color.DKGRAY);
                        offAll.setBackgroundColor(Color.DKGRAY);
                    } else if (status1.getOne().equalsIgnoreCase("Off")) {
                        oneOnButton.setBackgroundColor(Color.DKGRAY);
                        oneOffButton.setBackgroundColor(Color.RED);
                        onAll.setBackgroundColor(Color.DKGRAY);
                    }if (status1.getTwo().equalsIgnoreCase("On")) {
                        twoOnButton.setBackgroundColor(Color.GREEN);
                        twoOffButton.setBackgroundColor(Color.DKGRAY);
                        offAll.setBackgroundColor(Color.DKGRAY);
                    } else if (status1.getTwo().equalsIgnoreCase("Off")) {
                        twoOnButton.setBackgroundColor(Color.DKGRAY);
                        twoOffButton.setBackgroundColor(Color.RED);
                        onAll.setBackgroundColor(Color.DKGRAY);
                    }if (status1.getThree().equalsIgnoreCase("On")) {
                        threeOnButton.setBackgroundColor(Color.GREEN);
                        threeOffButton.setBackgroundColor(Color.DKGRAY);
                        offAll.setBackgroundColor(Color.DKGRAY);
                    } else if (status1.getThree().equalsIgnoreCase("Off")) {
                        threeOnButton.setBackgroundColor(Color.DKGRAY);
                        threeOffButton.setBackgroundColor(Color.RED);
                        onAll.setBackgroundColor(Color.DKGRAY);
                    }if (status1.getFour().equalsIgnoreCase("On")) {
                        fourOnButton.setBackgroundColor(Color.GREEN);
                        fourOffButton.setBackgroundColor(Color.DKGRAY);
                        offAll.setBackgroundColor(Color.DKGRAY);
                    } else if (status1.getFour().equalsIgnoreCase("Off")) {
                        fourOnButton.setBackgroundColor(Color.DKGRAY);
                        fourOffButton.setBackgroundColor(Color.RED);
                        onAll.setBackgroundColor(Color.DKGRAY);
                    }if (status1.getFive().equalsIgnoreCase("On")) {
                        fiveOnButton.setBackgroundColor(Color.GREEN);
                        fiveOffButton.setBackgroundColor(Color.DKGRAY);
                        offAll.setBackgroundColor(Color.DKGRAY);
                    } else if (status1.getFive().equalsIgnoreCase("Off")) {
                        fiveOnButton.setBackgroundColor(Color.DKGRAY);
                        fiveOffButton.setBackgroundColor(Color.RED);
                        onAll.setBackgroundColor(Color.DKGRAY);
                    }
                    if (status1.getOne().equalsIgnoreCase("On") && status1.getTwo().equalsIgnoreCase("On") && status1.getThree().equalsIgnoreCase("On") && status1.getFour().equalsIgnoreCase("On") && status1.getFive().equalsIgnoreCase("On")) {
                        onAll.setBackgroundColor(Color.GREEN);
                        offAll.setBackgroundColor(Color.DKGRAY);
                    }
                    if (status1.getOne().equalsIgnoreCase("Off") && status1.getTwo().equalsIgnoreCase("Off") && status1.getThree().equalsIgnoreCase("Off") && status1.getFour().equalsIgnoreCase("Off") && status1.getFive().equalsIgnoreCase("Off")) {
                        onAll.setBackgroundColor(Color.DKGRAY);
                        offAll.setBackgroundColor(Color.RED);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        onAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = new Status();
                status.setId("1");
                status.setOne("On");
                status.setTwo("On");
                status.setThree("On");
                status.setFour("On");
                status.setFive("On");
                databaseReference.setValue(status);
                oneOnButton.setBackgroundColor(Color.GREEN);
                twoOnButton.setBackgroundColor(Color.GREEN);
                threeOnButton.setBackgroundColor(Color.GREEN);
                fourOnButton.setBackgroundColor(Color.GREEN);
                fiveOnButton.setBackgroundColor(Color.GREEN);
                oneOffButton.setBackgroundColor(Color.DKGRAY);
                twoOffButton.setBackgroundColor(Color.DKGRAY);
                threeOffButton.setBackgroundColor(Color.DKGRAY);
                fourOffButton.setBackgroundColor(Color.DKGRAY);
                fiveOffButton.setBackgroundColor(Color.DKGRAY);
            }
        });

        oneOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("one").setValue("On");
                oneOnButton.setBackgroundColor(Color.GREEN);
                oneOffButton.setBackgroundColor(Color.DKGRAY);
            }
        });
        oneOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("one").setValue("Off");
                oneOnButton.setBackgroundColor(Color.DKGRAY);
                oneOffButton.setBackgroundColor(Color.RED);
            }
        });
        twoOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("two").setValue("On");
                twoOnButton.setBackgroundColor(Color.GREEN);
                twoOffButton.setBackgroundColor(Color.DKGRAY);
            }
        });
        twoOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("two").setValue("Off");
                twoOnButton.setBackgroundColor(Color.DKGRAY);
                twoOffButton.setBackgroundColor(Color.RED);
            }
        });
        threeOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("three").setValue("On");
                threeOnButton.setBackgroundColor(Color.GREEN);
                threeOffButton.setBackgroundColor(Color.DKGRAY);
            }
        });
        threeOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("three").setValue("Off");
                threeOnButton.setBackgroundColor(Color.DKGRAY);
                threeOffButton.setBackgroundColor(Color.RED);
            }
        });
        fourOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("four").setValue("On");
                fourOnButton.setBackgroundColor(Color.GREEN);
                fourOffButton.setBackgroundColor(Color.DKGRAY);
            }
        });
        fourOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("four").setValue("Off");
                fourOnButton.setBackgroundColor(Color.DKGRAY);
                fourOffButton.setBackgroundColor(Color.RED);
            }
        });
        fiveOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("five").setValue("On");
                fiveOnButton.setBackgroundColor(Color.GREEN);
                fiveOffButton.setBackgroundColor(Color.DKGRAY);
            }
        });
        fiveOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("five").setValue("Off");
                fiveOnButton.setBackgroundColor(Color.DKGRAY);
                fiveOffButton.setBackgroundColor(Color.RED);
            }
        });

        offAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = new Status();
                status.setId("1");
                status.setOne("Off");
                status.setTwo("Off");
                status.setThree("Off");
                status.setFour("Off");
                status.setFive("Off");
                databaseReference.setValue(status);
                oneOffButton.setBackgroundColor(Color.RED);
                twoOffButton.setBackgroundColor(Color.RED);
                threeOffButton.setBackgroundColor(Color.RED);
                fourOffButton.setBackgroundColor(Color.RED);
                fiveOffButton.setBackgroundColor(Color.RED);
                oneOnButton.setBackgroundColor(Color.DKGRAY);
                twoOnButton.setBackgroundColor(Color.DKGRAY);
                threeOnButton.setBackgroundColor(Color.DKGRAY);
                fourOnButton.setBackgroundColor(Color.DKGRAY);
                fiveOnButton.setBackgroundColor(Color.DKGRAY);
            }
        });
    }


}
