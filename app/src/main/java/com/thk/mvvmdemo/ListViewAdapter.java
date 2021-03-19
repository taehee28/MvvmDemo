/*
 * Created by taehee28 on 2021. 3. 18
 * Last modified 21. 3. 18 오후 6:01
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.thk.mvvmdemo.databinding.ItemListCellBinding;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ListAdapter<User, ListViewAdapter.CardViewHolder> {

    protected ListViewAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        private ItemListCellBinding binder;

        public CardViewHolder(@NonNull ItemListCellBinding binder) {
            super(binder.getRoot());
            this.binder = binder;

        }

        public void bind(User user) {
            binder.tvText.setText(user.getUserName());
            binder.tvUserNum.setText(user.getUserNum());
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListCellBinding binder = ItemListCellBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new CardViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
