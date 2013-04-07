package com.example.interq;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ForumHomeActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_home_activity);
        
        WebView webView = (WebView) findViewById(R.id.forumWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://rubinte.ch:8002/interq/login?next=%2Finterq%2Fforum");
        
    }
    
   /* 
    public JSONObject assembleCreateJSON(String message){
        JSONObject json = new JSONObject();
        try{
            json.put("timestamps", timeData);
            json.put("dataX", accDataX);
            json.put("dataY", accDataY);
            json.put("dataZ", accDataZ);
            json.put("msg", message);
        }catch (JSONException j){
            Log.w("Error", "Write Failed on " + message, j);
        }finally{
            return json;
        }
    }
    private class BGPost extends AsyncTask<String, Void, String>{
        private String whole;
        protected void onPostExecute(String result){
            WebView web = (WebView) findViewById(R.id.webview);
            web.loadUrl(result);
            }
        protected String doInBackground(String...jsons){
            whole = "";
            for(String json : jsons){
                try{
                    URL url = new URL("http://rubinte.ch/scribbles");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    try{
                        String msg = "data="+json;
                        conn.setDoOutput(true);
                        conn.setFixedLengthStreamingMode(msg.length());
                        OutputStream out = new BufferedOutputStream(conn.getOutputStream());
                        out.write(msg.getBytes());
                        out.flush();
                        BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuilder total = new StringBuilder();
                        String line;
                        while ((line = r.readLine()) != null) {
                            total.append(line);
                            }
                        whole = total.toString() ;
                        out.close();
                        r.close();
                        conn.disconnect();
                        }catch (Exception e){
                            
                        }
                    }catch (Exception e){
                        
                    }
                }
            return whole;
            }
        }
        //Call this via:
        try{

        new BGPost().execute(assembleScanJSON().toString());

        }catch (Exception e){

        }
        */
}
