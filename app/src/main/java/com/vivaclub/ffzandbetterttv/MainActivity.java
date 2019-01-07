package com.vivaclub.ffzandbetterttv;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;


// 6x0udfh1ugiitkya8xwrtm8mn4oh4e
// witch Chat OAuth Password Generator   oauth:2stfhsarzgqqyv3dwnw14vilefkyo8
public class MainActivity extends AppCompatActivity {
    private static String nick;
    private static String username;
    private static String realName;
    private static PrintWriter out;
    private static Scanner in;
    private static BufferedReader in1;
    String currentUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button LoginBtn = findViewById(R.id.loginbtn);
        EditText ChannelName = findViewById(R.id.joinChannel);
        SharedPreferences loadToken = getSharedPreferences(Constant.SAVE_FILE_NAME,Context.MODE_PRIVATE);
        String Token = loadToken.getString("Token","");
        if(Token.equals("")) {
            LoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        } else{
            User user = new User(Token,MainActivity.this);
            LoginBtn.setText(user.getNickname());
           // ChannelName.setVisibility(View.VISIBLE);
        }



        //User user = new User();
        //ConnectToIrc connect = new ConnectToIrc(6667);
        // connect.start();



    }

}








