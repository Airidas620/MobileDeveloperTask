package com.example.android.mobiledevelopertask.models;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.android.mobiledevelopertask.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JSONData {
    private String[] urls;
    private int[] urlDigits;

    /**
     * Resolves JSON data in a given file
     * @param application
     */
    public JSONData(@NonNull Application application) {
        InputStream jsonInputStream = application.getResources().openRawResource(R.raw.dog_urls);

        BufferedReader streamReader = new BufferedReader(new InputStreamReader(jsonInputStream, StandardCharsets.UTF_8));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr = "";
        JSONArray jsonArray = null;

        try {
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            //Get JSON array from StringBuilder
            jsonArray = new JSONObject(responseStrBuilder.toString()).getJSONArray("urls");

            urls = new String[jsonArray.length()];
            urlDigits = new int[jsonArray.length()];

            //Write JSON array data to string and int arrays
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    urls[i] = jsonArray.get(i).toString();
                    urlDigits[i] = urlDigitsSum(urls[i]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | JSONException ignored) {
    }

    }

    /**
     * Calculates the sum of digits at the end of URL
     * @param url - URL as string
     * @return - sum of the URL digits
     */
    static int urlDigitsSum(String url){
        int digitSum = 0;
        String urlEndPath = url.substring(url.lastIndexOf("/")+1);
        for(char c : urlEndPath.toCharArray()) {
            if(Character.isDigit(c)){
                digitSum+=Character.getNumericValue(c);
            }

        }
        return digitSum;
    }

    public String[] getUrls() {
        return urls;
    }

    public int[] getUrlDigits() {
        return urlDigits;
    }

}
