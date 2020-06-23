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

/**
 * Adapter for the recycler view
 */
public class SamplesBookLiveDataListAdapter
        extends RecyclerView.Adapter<SamplesBookLiveDataListAdapter.MyViewHolder> {



    // Attributes
    LiveData<List<BookFull>> resultViewLiveData; // List of books



    /**
     * Constructor
     */
    public SamplesBookLiveDataListAdapter(
            LiveData<List<BookFull>> resultViewLiveData) {
        // Provide a suitable constructor (depends on the kind of data set)
        this.resultViewLiveData = resultViewLiveData;
    }

    /**
     * Create new views (invoked by the layout manager)
     * @param parent Parent that provides the context
     * @param viewType not used
     * @return
     */
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


    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder MyViewHolder instance
     * @param position position of the element
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        BookFull resultView = getItem(position);

        // - replace the contents of the view with that element
        // holder.title.setText(sampleBook.getFkBookInfoModel());
        holder.bind(resultView);

    }

    /**
     * Search the item
     * @param position of the item
     * @return the item id
     */
    @Override
    public long getItemId(int position) {
        return resultViewLiveData.getValue().indexOf(position);
    }


    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return size of the list
     */
    @Override
    public int getItemCount() {
        return resultViewLiveData.getValue().size();
    }

    /**
     * Search the item
     * @param position of the item
     * @return the item instance
     */
    public BookFull getItem(int position){
        return resultViewLiveData.getValue().get(position);
    }



    /**
     * View holder class
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Using data binding
        ItemSampleBookBinding itemBinding;

        /**
         * Constructor
         * @param itemBinding binding instance
         */
        public MyViewHolder(ItemSampleBookBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;

        }

        /**
         * Bind the item to the xml file
         * @param resultView
         */
        public void bind(BookFull resultView) {
            itemBinding.setResultView(resultView);
        }


    }


}
