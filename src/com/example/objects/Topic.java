package com.example.objects;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Topic implements Parcelable {
//TODO: NEEDS TO BE STORABLE
    
    ArrayList<SubTopic> subtopics;
    ArrayList<Question> questions;
    
    
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        // TODO Auto-generated method stub
        
    }
    
}
