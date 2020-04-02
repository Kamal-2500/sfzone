package com.example.sfzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login2Activity extends AppCompatActivity {

    //private static String url_login = "http://172.16.15.6/SFZone_App/login.php";

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView forgotpasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        forgotpasswordTextView=(TextView) findViewById(R.id.forgotpasswordTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = usernameEditText.getText().toString().trim();
                final String password = usernameEditText.getText().toString().trim();

                login();
               /* if (!username.isEmpty() || !password.isEmpty()){
                    login();
                }else {
                    usernameEditText.setError("Please Enter Username");
                    passwordEditText.setError("Please Enter Password");
                }*/

                //Intent homescreenIntent = new Intent(getApplicationContext(),ActivityforHomeScreen.class);
                //startActivity(homescreenIntent);
            }
        });


        forgotpasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotpasswordIntent = new Intent(getApplicationContext(),ForgotPasswordActivity.class);
                startActivity(forgotpasswordIntent);
            }
        });
    }

    public void login(){
        StringRequest request= new StringRequest(Request.Method.POST, "http://192.168.43.188/Rashid/rlogin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")){
                            Intent homescreenIntent = new Intent(getApplicationContext(),ActivityforHomeScreen.class);
                            startActivity(homescreenIntent);

                        }else {
                            //Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_SHORT).show();
                            Intent homescreenIntent = new Intent(getApplicationContext(),ActivityforHomeScreen.class);
                            startActivity(homescreenIntent);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Intent homescreenIntent = new Intent(getApplicationContext(),ActivityforHomeScreen.class);
                startActivity(homescreenIntent);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("username",usernameEditText.getText().toString());
                params.put("password",passwordEditText.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);

    }

   /* private void login(final String username, final String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //String data = response.yourkey;
                            Log.d("JSON",response);
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")){
                                for (int i = 0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name").trim();
                                    Toast.makeText(Login2Activity.this,"Success Login. \nYour Name "+name,
                                            Toast.LENGTH_SHORT).show();

                                }
                                Intent homescreenIntent = new Intent(getApplicationContext(),ActivityforHomeScreen.class);
                                startActivity(homescreenIntent);

                            }
                            else
                            {
                                Toast.makeText(Login2Activity.this, "login error", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Login2Activity.this, "Error 1 "+e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Login2Activity.this, "Error 2 "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("email",username);
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/
}
