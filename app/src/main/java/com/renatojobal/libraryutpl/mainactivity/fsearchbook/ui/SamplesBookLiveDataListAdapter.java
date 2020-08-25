package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import android.view.LayoutInflater;
import android.view.View;
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

import timber.log.Timber;

/**
 * Adapter for the recycler view
 */
public class SamplesBookLiveDataListAdapter
        extends RecyclerView.Adapter<SamplesBookLiveDataListAdapter.MyViewHolder> {



    // Attributes
    LiveData<List<BookFull>> resultViewLiveData; // List of books

    // Item click listener
    public static interface ItemClickListener{

        void onClickListener(int bookInfoId);
    }

    ItemClickListener itemClickListener;

    /**
     * Constructor
     */
    public SamplesBookLiveDataListAdapter(
            LiveData<List<BookFull>> resultViewLiveData,
            ItemClickListener itemClickListener) {
        // Provide a suitable constructor (depends on the kind of data set)
        this.resultViewLiveData = resultViewLiveData;
        this.itemClickListener = itemClickListener;
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
        MyViewHolder viewHolder = new MyViewHolder(binding, itemClickListener);
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

        // Item click listener
        ItemClickListener itemClickListener;

        /**
         * Constructor
         * @param itemBinding binding instance
         */
        public MyViewHolder(ItemSampleBookBinding itemBinding, ItemClickListener itemClickListener) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            this.itemClickListener = itemClickListener;
        }

        /**
         * Bind the item to the xml file
         * @param resultView
         */
        public void bind(BookFull resultView) {
            itemBinding.setResultView(resultView);

            // Set on click listener to navigate to the detailed book info
            itemBinding.cardViewSampleBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Timber.d("On item click listener");
                    itemClickListener.onClickListener(resultView.bookInfo.getBookInfoModelId());
                }
            });


        }


    }


}
