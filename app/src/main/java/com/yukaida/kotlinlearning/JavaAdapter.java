package com.yukaida.kotlinlearning;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author yukaida
 * @DATE 2020/12/9.
 */
public class JavaAdapter extends RecyclerView.Adapter<JavaAdapter.JavaHolder> {

    @NonNull
    @Override
    public JavaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        parent.getContext();
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull JavaHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class JavaHolder extends RecyclerView.ViewHolder {
        public JavaHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
