package com.example.weavingspider.weavingspider;

import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amit Saharan on 26/08/17.
 */

public class CustomStringRequest extends StringRequest {

    protected HashMap<String,String> HEADERS = new HashMap<>();

    public CustomStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public CustomStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    public Map<String,String> getHeaders(){
        HEADERS.put("Authentication-Method","headers");
        HEADERS.put("Device","Android");
        return HEADERS;
    }
}
