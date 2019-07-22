package com.marchengraffiti.architecture.androidarchitecture.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marchengraffiti.architecture.androidarchitecture.R;

public class MVCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC Activity");
    }

    public static Intent getINtent(Context context){
        return new Intent(context, MVCActivity.class);
    }
}
