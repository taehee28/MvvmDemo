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
import androidx.lifecycle.ViewModelProvider;

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

//        viewModel = new MyViewModel();
        // 단순히 new 키워드로 생성하는 것은 의미가 없고, HolderFragment에 의해 관리되게끔 하려면 ViewModelProvider를 통해서 생성해야 함
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getLiveItemList().observe(this, strings -> Log.d(TAG, "Observe: liveItemList changed " + strings.toString()));

        binder.btnDo.setOnClickListener(view -> viewModel.changeItemList());
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }
}