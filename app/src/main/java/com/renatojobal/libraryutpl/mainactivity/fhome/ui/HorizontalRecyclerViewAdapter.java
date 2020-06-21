package com.renatojobal.libraryutpl.mainactivity.fhome.ui;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalViewHolder> {
    /**
     * This adapter would be for the horizontal list of books
     * @param parent
     * @param viewType
     * @return
     */

    // Data source
    LiveData<List<BookInfoModel>> list;


    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.getValue().size();
    }


    /**
     * View holder for each book
     */
    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
