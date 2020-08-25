package com.renatojobal.libraryutpl.mainactivity.fhome.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemHomeBookBinding;
import com.renatojobal.libraryutpl.databinding.ItemHorizontalHomeListBinding;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

/**
 * This adapter would be for the horizontal list of books
 */
public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalViewHolder> {


    // Context
    Context context;

    // Data source
    List<BookInfoModel> list;



   RootRecyclerViewAdapter.ItemClickListener itemClickListener;

    /**
     * Constructor
     * @param context
     * @param horizontalList
     */
    public HorizontalRecyclerViewAdapter(Context context, List<BookInfoModel> horizontalList, RootRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.list = horizontalList;
        this.itemClickListener = itemClickListener;
    }



    /**
     * Create new views (invoked by the layout manager)
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemHomeBookBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_home_book, parent, false);


        // Return the view holder with the elements attached
       HorizontalRecyclerViewAdapter.HorizontalViewHolder viewHolder = new HorizontalRecyclerViewAdapter.HorizontalViewHolder(binding);

        return viewHolder;
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        // - get element from your data set at this position
        BookInfoModel bookInfoModel = getItem(position);

        // - replace the contents of the view with that element
        holder.bind(bookInfoModel, this.itemClickListener);
    }

    /**
     * Return the item from the data source
     * @param position
     * @return
     */
    private BookInfoModel getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    /**
     * View holder for each book
     */
    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        // Using with data binding
        ItemHomeBookBinding itemHomeBookBinding;

        /**
         * Constructor with bind data
         * @param binding
         */
        public HorizontalViewHolder(ItemHomeBookBinding binding) {
            super(binding.getRoot());
            this.itemHomeBookBinding = binding;

        }

        /**
         * Bind the list with each item
         * @param bookInfoModel
         */
        public void bind(BookInfoModel bookInfoModel, RootRecyclerViewAdapter.ItemClickListener itemClickListener) {
            itemHomeBookBinding.setBookInfoModel(bookInfoModel);

            itemHomeBookBinding.cardViewItemCoverPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClickListener(bookInfoModel.getBookInfoModelId());
                }
            });

        }


    }
}
