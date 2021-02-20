package com.example.ecommrrcewebsite.PhoneLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ecommrrcewebsite.EmailLoginRegister.EmailLoginActivity;
import com.example.ecommrrcewebsite.MainActivity;
import com.example.ecommrrcewebsite.R;

public class PhoneRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_register);
        ////////hide status bar start////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ////////hide status bar end////////
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(PhoneRegisterActivity.this,PhoneLoginActivity.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
    }

    public void backToMainPage(View view) {
        Intent intent = new Intent(PhoneRegisterActivity.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(this);
        finish();

    }
}