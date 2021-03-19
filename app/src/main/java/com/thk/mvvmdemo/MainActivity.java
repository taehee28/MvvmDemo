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
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.thk.mvvmdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// View

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private final String TAG = "thkang";
    private ActivityMainBinding binder;

    private MyViewModel viewModel;

    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());


        listViewAdapter = new ListViewAdapter(new ListDiffUtil());
        binder.listView.setLayoutManager(new LinearLayoutManager(this));
        binder.listView.setAdapter(listViewAdapter);

        // TODO: 2021-03-19 observe로 넘어오는 바뀐 데이터의 참조가 계속 일치해서 submit 해도 변경된걸 알아차리지 못함

        // 단순히 new 키워드로 생성하는 것은 의미가 없고, HolderFragment에 의해 관리되게끔 하려면 ViewModelProvider를 통해서 생성해야 함
//        viewModel = new MyViewModel();
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getLiveItemList().observe(this, users -> {
            Log.d(TAG, "observe: liveData changed -> " + users.toString());
            Log.d(TAG, "observe: current list -> " + listViewAdapter.getCurrentList());
            listViewAdapter.submitList(new ArrayList<>(users), () -> Log.d(TAG, "observe: submit done -> " + listViewAdapter.getCurrentList().toString()));
        });



        binder.btnDo.setOnClickListener(view -> viewModel.changeItemList());
//        binder.btnDo.setOnClickListener(view -> {
//            int random = (int) (Math.random() * 10);
//            listViewAdapter.submitList(Arrays.asList(String.valueOf(random), "2", "3"));
//        });

    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }
}