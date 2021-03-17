/*
 * Created by taehee28 on 2021. 3. 17
 * Last modified 21. 3. 17 오후 5:18
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.util.Log;

import com.thk.mvvmdemo.databinding.ActivityMainBinding;

// View

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private final String TAG = "thkang";
    private ActivityMainBinding binder;

    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        viewModel = new MyViewModel();
        viewModel.getLiveData().observe(this, s -> binder.textView.setText(s));


        binder.btnDo.setOnClickListener(v -> viewModel.resetData());
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }
}