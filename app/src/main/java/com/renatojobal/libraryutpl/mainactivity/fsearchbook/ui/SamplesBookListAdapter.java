package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;

public class SamplesBookListAdapter
        extends RecyclerView.Adapter<SamplesBookListAdapter.ViewHolder> {

    /**
     * Recycler View Adapter
     * @param parent
     * @param viewType
     * @param sampleBookLiveData List of books
     * @return
     */

    // Attributes
    Context context;
    LiveData<List<SampleBookModel>> sampleBookLiveData;

    public SamplesBookListAdapter(Context context, LiveData<List<SampleBookModel>> sampleBookLiveData) {
        /**
         * Constructor
         */
        this.context = context;
        this.sampleBookLiveData = sampleBookLiveData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
