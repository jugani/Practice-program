package com.tw.challenge;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StageOne {



    public JSONObject getCount(String input) throws JSONException {
        JSONArray jsonarray = new JSONArray(input);
        int count=jsonarray.length();
        JSONObject output= new JSONObject();
        output.put("count", count);
       return output;
    }
}
