package com.renatojobal.libraryutpl.mainactivity.floan;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemLoanBinding;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder> {



    // Attributes
    LiveData<List<SampleBookModel>> resultViewLiveData; // List of loans


    /**
     * Constructor
     */
    public Adapter(
            LiveData<List<SampleBookModel>> resultViewLiveData) {
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

        ItemLoanBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_loan, parent, false);


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
        SampleBookModel sampleBookModel = getItem(position);

        // - replace the contents of the view with that element
        // holder.title.setText(sampleBook.getFkBookInfoModel());
        holder.bind(sampleBookModel);

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
    public SampleBookModel getItem(int position){
        return resultViewLiveData.getValue().get(position);
    }



    /**
     * View holder class
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Using data binding
        ItemLoanBinding itemBinding;


        /**
         * Constructor
         * @param itemBinding binding instance
         */
        public MyViewHolder(ItemLoanBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;

        }

        /**
         * Bind the item to the xml file
         */
        public void bind(SampleBookModel sampleBookModel) {
            // Bins data here
            itemBinding.book.setText(sampleBookModel.getBookInfoTitle());
            itemBinding.tag.setText(sampleBookModel.getTag());
            itemBinding.totalInternalLoans.setText(String.valueOf(sampleBookModel.getTotalInternalLoans()));
            itemBinding.totalExternalLoans.setText(String.valueOf(sampleBookModel.getTotalExternalLoans()));


        }


    }


}
