package com.example.himanshu.testapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by himanshu on 26/4/17.
 */

public class HttpService extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... url) {
        try {
            URL httpUrl = new URL(url[0]);
            HttpURLConnection httpConnection = (HttpURLConnection) httpUrl.openConnection();
            InputStream in = new BufferedInputStream(httpConnection.getInputStream());
            String text = readStream(in);
            Log.i("HttpService", text);
            return text;
        } catch (Exception e) {
            System.out.print(e);
        }
        return "";
    }

    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is), 1000);
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }
}
