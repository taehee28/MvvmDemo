/*
 * Created by taehee28 on 2021. 3. 19
 * Last modified 21. 3. 19 오후 2:10
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import static android.content.ContentValues.TAG;

public class ListDiffUtil extends DiffUtil.ItemCallback<User> {
    @Override
    public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return oldItem.getUserId().equals(newItem.getUserId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        boolean result = (oldItem.getUserName().equals(newItem.getUserName())) && (oldItem.getUserNum().equals(newItem.getUserNum()));
        return result;
    }
}
