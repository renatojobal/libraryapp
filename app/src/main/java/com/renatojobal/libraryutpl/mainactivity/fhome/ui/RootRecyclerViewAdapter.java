package com.renatojobal.libraryutpl.mainactivity.fhome.ui;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RootRecyclerViewAdapter extends RecyclerView.Adapter<RootRecyclerViewAdapter.RootViewHolder> {
    /**
     * This Recycler view will be the adapter for all the nested recycler views
     * @param parent
     * @param viewType
     * @return
     */



    @NonNull
    @Override
    public RootViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RootViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    /**
     * View holder for each horizontal list of books
     */
    public class RootViewHolder extends RecyclerView.ViewHolder {


        public RootViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
