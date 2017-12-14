package com.example.weavingspider.weavingspider;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitkumar on 15/12/17.
 */

class Survey implements Parcelable {
    public String name;
    public ArrayList<Question> questions;

    public static final Parcelable.Creator<Survey> CREATOR
            = new Parcelable.Creator<Survey>() {
        public Survey createFromParcel(Parcel in) {
            return new Survey(in);
        }

        public Survey[] newArray(int size) {
            return new Survey[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(questions.size());
        for(int j=0;j<questions.size();j++){
            Question question = questions.get(j);
            parcel.writeString(question.text);
        }
    }

    private Survey (Parcel parcel) {
        questions = new ArrayList<>();
        name = parcel.readString();
        int questionCount = parcel.readInt();
        for(int i =0; i< questionCount; i++){
            String text;
            text = parcel.readString();
            questions.add(new Question(text));
        }
    }
}
