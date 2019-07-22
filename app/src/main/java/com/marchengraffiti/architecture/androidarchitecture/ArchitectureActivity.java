package com.marchengraffiti.architecture.androidarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.marchengraffiti.architecture.androidarchitecture.mvc.MVCActivity;
import com.marchengraffiti.architecture.androidarchitecture.mvp.MVPActivity;
import com.marchengraffiti.architecture.androidarchitecture.mvvm.MVVMActivity;

public class ArchitectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC(View view){
        startActivity(MVCActivity.getINtent(this));
    }

    public void onMVP(View view){
        startActivity(MVPActivity.getINtent(this));
    }

    public void onMVVM(View view){
        startActivity(MVVMActivity.getINtent(this));
    }

}
