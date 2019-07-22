package com.marchengraffiti.architecture.androidarchitecture.mvvm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marchengraffiti.architecture.androidarchitecture.R;
import com.marchengraffiti.architecture.androidarchitecture.mvc.MVCActivity;

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        setTitle("MVVM Activity");

    }

    public static Intent getIntent(Context context){
        return new Intent(context, MVCActivity.class);
    }
}
