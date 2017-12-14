package com.example.weavingspider.weavingspider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitkumar on 15/12/17.
 */

class AnswerResponse {
    public ArrayList<Survey> surveys;

    AnswerResponse(){
        this.surveys = new ArrayList<>();
    }

    AnswerResponse(ArrayList<Survey> surveys){
        this.surveys = surveys;
    }
}
