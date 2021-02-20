package com.example.ecommrrcewebsite.EmailLoginRegister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ecommrrcewebsite.MainActivity;
import com.example.ecommrrcewebsite.R;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EmailRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText TextEmail,TextPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialogue;
    public static final String URL_REGISTER ="http://192.168.0.104:8080/Android/v1/registerUser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        TextEmail= (EditText) findViewById(R.id.TextEmail);
        TextPassword= (EditText) findViewById(R.id.TextPassword);
        buttonRegister=(Button) findViewById(R.id.buttonRegister) ;
        progressDialogue = new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);

        ////////hide status bar start////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ////////hide status bar end////////
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(EmailRegisterActivity.this, EmailLoginActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeLeft(this);
        finish();
    }

    public void backToMainPage(View view) {
        Intent intent = new Intent(EmailRegisterActivity.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(this);
        finish();

    }

    private void registerUser(){
       final String email = TextEmail.getText().toString().trim();
       final String password = TextPassword.getText().toString().trim();
       progressDialogue.setMessage(" registering ");
       progressDialogue.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialogue.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject (response);
                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialogue.hide();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                return params;

            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    @Override
    public void onClick(View view) {
       if(view == buttonRegister)
       {registerUser();}

    }


}