/*
 * Created by taehee28 on 2021. 3. 17
 * Last modified 21. 3. 17 오후 5:59
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> liveData;

    {
        liveData = new MutableLiveData<>();
    }

    public void resetData() {
        int random = (int) (Math.random() * 10);
        liveData.setValue(String.valueOf(random));
    }

    public MutableLiveData<String> getLiveData() {
        return liveData;
    }
}
