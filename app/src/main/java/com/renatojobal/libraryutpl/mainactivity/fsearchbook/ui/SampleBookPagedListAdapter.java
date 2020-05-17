package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

public class SampleBookPagedListAdapter
        extends PagedListAdapter<SampleBookModel, SampleBookPagedListAdapter.SampleBookViewHolder> {
    /**
     * Sample book list adapter
     */

    Context context;

    protected SampleBookPagedListAdapter(Context context){
        /** Constructor */
        super(DIFF_CALLBACK);
        this.context = context;
    }

    class SampleBookViewHolder extends RecyclerView.ViewHolder{

        public SampleBookViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void bindTo(SampleBookModel sampleBookModel){
            TextView tv_title = itemView.findViewById(R.id.title);
            TextView tv_location = itemView.findViewById(R.id.location);

            tv_title.setText("Librito tag: "+sampleBookModel.getTag());
            tv_location.setText("Prueba");
        }

    }

    @NonNull
    @Override
    public SampleBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * This method will be used to attach the card view of notification to the list view.
         * */
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_sample_book, parent, false);

        return new SampleBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleBookViewHolder holder,
                                 int position) {
        SampleBookModel sampleBookModel = getItem(position);

        // Note that "concert" can be null if it's a placeholder.
        holder.bindTo(sampleBookModel);
    }

    private static DiffUtil.ItemCallback<SampleBookModel> DIFF_CALLBACK
            = new DiffUtil.ItemCallback<SampleBookModel>() {

        @Override
        public boolean areItemsTheSame(SampleBookModel oldItem, SampleBookModel newItem) {
            // The ID property identifies when items are the same.
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(SampleBookModel oldItem, SampleBookModel newItem) {
            // Don't use the "==" operator here. Either implement and use .equals(),
            // or write custom data comparison logic here.
            return oldItem.equals(newItem);
        }
    };



}
