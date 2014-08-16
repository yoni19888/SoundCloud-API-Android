package com.soundcloud.http;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Simple Soundcloud API
 * Created by Yoni Gol on 16/08/2014.
 */

public class HttpRequest extends AsyncTask<String, String, String> {

    private IRequest listener;
    private boolean complete = false;

    public HttpRequest(IRequest listener)
    {
        try{
            this.listener = listener;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected String doInBackground(String... uri) {

        HttpClient httpclient = new DefaultHttpClient();
        String responseString = null;
        HttpResponse response;

        complete = false;

        try
        {
            response = httpclient.execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();

            if(statusLine.getStatusCode() == HttpStatus.SC_OK)
            {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            }
            else
            {
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        }
        catch (Exception e){
            e.printStackTrace();
            listener.onError(e);

            return null;
        }

        complete = true;

        return responseString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if(complete)
            listener.onRequestComplete(result);

    }

}