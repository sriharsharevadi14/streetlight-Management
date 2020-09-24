package com.example.smartstreet.Db;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBCon {
    public static DatabaseReference getRef(){
       return FirebaseDatabase.getInstance().getReference("SmartStreet");
    }


}
