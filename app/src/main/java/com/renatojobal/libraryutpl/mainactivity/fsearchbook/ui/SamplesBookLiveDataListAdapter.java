package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;

public class SamplesBookLiveDataListAdapter
        extends RecyclerView.Adapter<SamplesBookLiveDataListAdapter.ViewHolder> {

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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Ui elements
        public TextView title;
        public TextView author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);


        }
    }

    // Provide a suitable constructor (depends on the kind of data set)
    public SamplesBookLiveDataListAdapter(
            Context context,
            LiveData<List<SampleBookModel>> sampleBookLiveData) {
        /**
         * Constructor
         */
        this.context = context;
        this.sampleBookLiveData = sampleBookLiveData;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_sample_book, parent, false);

        // Return the view holder with the elements attached
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        SampleBookModel sampleBook = getItem(position);


        holder.author.setText(sampleBook.getTag());

    }

    @Override
    public long getItemId(int position) {
        return sampleBookLiveData.getValue().indexOf(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sampleBookLiveData.getValue().size();
    }

    public SampleBookModel getItem(int position){
        return sampleBookLiveData.getValue().get(position);
    }

}
