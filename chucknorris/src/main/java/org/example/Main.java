package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String urlstring ="https://api.chucknorris.io/jokes/random";
        URL url= null;
        try {
             url =new URL(urlstring);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection connection = null;
        try {
             connection =  (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            System.out.print("incorrect url");
        }
        int response = 0;
        try {
             response =connection.getResponseCode();
        } catch (Exception e) {
            System.out.print("no response");
        }
        BufferedReader in = null;
    if(response == 200){
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (Exception e) {
           System.out.print("output no formed");
        }
        StringBuilder apidata = new StringBuilder();
  String read = null;
        while((read= in.readLine())!=null){
            apidata.append(read);
        }
        in.close();
        JSONObject jsonapi = new JSONObject(apidata.toString());
        System.out.print(jsonapi.toString());
    }
    else
    {
        System.out.print("API call failed");
    }
    }
}