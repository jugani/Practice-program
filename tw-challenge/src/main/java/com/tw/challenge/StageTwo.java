package com.tw.challenge;

import org.json.JSONArray;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StageTwo {

   public JSONArray getActiveProductCount(String input){

       JSONArray proucts= new JSONArray(input);

       JSONArray activeproducts= new JSONArray();

       //System.out.println("Printing active products "+proucts);


       int n = proucts.length() - 1;


       int count = 0;


       while (n >= 0) {
           org.json.JSONObject jsonObject = proucts.getJSONObject(n);
           String startDate = (String) jsonObject.get("startDate");
           Object endDate1 = jsonObject.get("endDate");
           String endDate = null;
           if (!org.json.JSONObject.NULL.equals(endDate1)) {
               endDate = (String) endDate1;
           }

           if (endDate != null) {
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               LocalDate localendDate = LocalDate.parse(endDate, formatter);
               LocalDate localStartDate = LocalDate.parse(startDate, formatter);
               int compareToEnd = LocalDate.now().compareTo(localendDate);
               int compareToStart = LocalDate.now().compareTo(localStartDate);
               if (compareToEnd < 0 && compareToStart >= 0) {
                   count++;
                   activeproducts.put(jsonObject);

               }
           } else {
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               LocalDate localStartDate = LocalDate.parse(startDate, formatter);
               int compareToStart = LocalDate.now().compareTo(localStartDate);
               if (compareToStart >= 0) {
                   count++;
                   activeproducts.put(jsonObject);

               }
           }
           n--;
       }



       return activeproducts;
   }


    public org.json.JSONObject getActiveProductCount(JSONArray activeproducts){
        org.json.JSONObject count= new org.json.JSONObject();
        int n=activeproducts.length();
        count.put("count", n);
       return  count;
    }
}
