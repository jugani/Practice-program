package com.tw.challenge;

import org.json.JSONArray;
import org.json.JSONObject;

public class StageThree {

        public JSONObject categoriesActiveProduct(JSONArray activeproducts, JSONObject categoryCountJson) {
            int n = activeproducts.length();


            for (int i = 0; i < n; i++) {
                JSONObject jsonObject = activeproducts.getJSONObject(i);
                categoryCountJson.put(jsonObject.getString("category"), 0);

            }

            System.out.println(categoryCountJson.toString());
            for (int i = 0; i < n; i++) {
                JSONObject jsonObject = activeproducts.getJSONObject(i);
                String category = jsonObject.getString("category");
                int count = categoryCountJson.getInt(category);
                categoryCountJson.put(category, ++count);

            }
            System.out.println("\t\t\t");
            System.out.println("Categorized json" + categoryCountJson.toString());
            System.out.println("\t\t\t");


               return categoryCountJson;
        }

    }

