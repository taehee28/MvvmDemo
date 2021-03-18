/*
 * Created by taehee28 on 2021. 3. 18
 * Last modified 21. 3. 18 오후 6:01
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ListAdapter<List<String>, ListViewAdapter.CardViewHolder> {

    // TODO: 2021-03-18 List<String>으로 써주는게 맞나 아니면 String으로만 적어줘야하는지 까먹음 ㅎ

    protected ListViewAdapter(@NonNull DiffUtil.ItemCallback<List<String>> diffCallback) {
        super(diffCallback);
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

    }
}
