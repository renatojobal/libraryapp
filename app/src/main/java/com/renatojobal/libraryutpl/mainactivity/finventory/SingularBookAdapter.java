package com.renatojobal.libraryutpl.mainactivity.finventory;


import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemSingularBookBinding;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;

import java.util.List;

public class SingularBookAdapter   extends RecyclerView.Adapter<SingularBookAdapter.MyViewHolder> {



    // Attributes
    LiveData<List<DetailedResponse>> resultViewLiveData; // List of books




    /**
     * Constructor
     */
    public SingularBookAdapter(
            LiveData<List<DetailedResponse>> resultViewLiveData) {
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

        ItemSingularBookBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_singular_book, parent, false);


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
        DetailedResponse detailedResponse = getItem(position);

        // - replace the contents of the view with that element
        // holder.title.setText(sampleBook.getFkBookInfoModel());
        holder.bind(detailedResponse);

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
    public DetailedResponse getItem(int position){
        return resultViewLiveData.getValue().get(position);
    }



    /**
     * View holder class
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Using data binding
        ItemSingularBookBinding itemBinding;


        /**
         * Constructor
         * @param itemBinding binding instance
         */
        public MyViewHolder(ItemSingularBookBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        /**
         * Bind the item to the xml file
         */
        public void bind(DetailedResponse detailedResponse) {
            itemBinding.tag.setText(detailedResponse.getSingularBook().getTag());
            itemBinding.bookTitle.setText(detailedResponse.getBookInfo().getTitle());
            itemBinding.samplesNumber.setText(String.valueOf(detailedResponse.getBookInfo().getTotalStock()));
        }


    }


}
