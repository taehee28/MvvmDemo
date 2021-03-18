/*
 * Created by taehee28 on 2021. 3. 17
 * Last modified 21. 3. 17 오후 5:59
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyViewModel extends ViewModel {

    // LiveData에 있는 List를 변경해도 observe 콜백이 호출되지 않음
    // data list와 liveData를 따로 관리하던가, liveData를 상속받아 커스텀하던가 해야함
    private ArrayList<String> itemList = new ArrayList<>(Arrays.asList("1", "2", "3"));
    private MutableLiveData<List<String>> liveItemList;

    {
        liveItemList = new MutableLiveData<>(itemList);
    }

    public void changeItemList() {
        int random = (int) (Math.random() * 10);
        itemList.set(0, String.valueOf(random));
        liveItemList.setValue(itemList);
    }

    public MutableLiveData<List<String>> getLiveItemList() {
        return liveItemList;
    }
}
