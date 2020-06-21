package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemSampleBookBinding;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;

import java.util.List;

public class SamplesBookLiveDataListAdapter
        extends RecyclerView.Adapter<SamplesBookLiveDataListAdapter.MyViewHolder> {

    /**
     * Recycler View Adapter
     * @param parent
     * @param viewType
     * @param sampleBookLiveData List of books
     * @return
     */

    // Attributes
    LiveData<List<BookFull>> resultViewLiveData;



    // Provide a suitable constructor (depends on the kind of data set)
    public SamplesBookLiveDataListAdapter(
            LiveData<List<BookFull>> resultViewLiveData) {
        /**
         * Constructor
         */

        this.resultViewLiveData = resultViewLiveData;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemSampleBookBinding binding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.item_sample_book, parent, false);


        // Return the view holder with the elements attached
        MyViewHolder viewHolder = new MyViewHolder(binding);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        BookFull resultView = getItem(position);

        // - replace the contents of the view with that element
//        holder.title.setText(sampleBook.getFkBookInfoModel());
        holder.bind(resultView);

    }

    @Override
    public long getItemId(int position) {
        return resultViewLiveData.getValue().indexOf(position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return resultViewLiveData.getValue().size();
    }

    public BookFull getItem(int position){
        return resultViewLiveData.getValue().get(position);
    }



    // View holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Using data binding
        ItemSampleBookBinding itemBinding;

        // Ui elements

        public TextView title;
        public TextView author;

        public MyViewHolder(ItemSampleBookBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);


        }


        public void bind(BookFull resultView) {
            itemBinding.setResultView(resultView);
        }


    }


}
