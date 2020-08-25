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
import com.renatojobal.libraryutpl.databinding.ItemHorizontalHomeListBinding;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui.SamplesBookLiveDataListAdapter;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;


/**
 *  This Recycler view will be the adapter for all the nested recycler views
 *
 */
public class RootRecyclerViewAdapter extends RecyclerView.Adapter<RootRecyclerViewAdapter.RootViewHolder> {


    // Data source   (List of lists)
    LiveData<List<List<BookInfoModel>>> lists;

    // We need the context her for pass it forward the horizontal recycler view
    Context context;


    // Item click listener
    public static interface ItemClickListener{

        void onClickListener(int bookInfoId);
    }

    ItemClickListener itemClickListener;

    /**
     * Constructor
     */
    public RootRecyclerViewAdapter(Context context, LiveData<List<List<BookInfoModel>>> lists,
                                   ItemClickListener itemClickListener) {
        this.context = context;
        this.lists = lists;
        this.itemClickListener = itemClickListener;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public RootViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemHorizontalHomeListBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_horizontal_home_list, parent, false);


        // Return the view holder with the elements attached
        RootViewHolder viewHolder = new RootViewHolder(binding);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull RootViewHolder holder, int position) {
        // - get element from your data set at this position
        List<BookInfoModel> horizontalList = getItem(position);

        // - replace the contents of the view with that element
        holder.bind(horizontalList, this.itemClickListener);

    }

    /**
     * Method to know the position of a list
     * @param position of the list
     * @return
     */
    private List<BookInfoModel> getItem(int position) {
        return this.lists.getValue().get(position);
    }

    @Override
    public int getItemCount() {
        return this.lists.getValue().size();
    }


    /**
     * View holder for each horizontal list of books
     */
    public class RootViewHolder extends RecyclerView.ViewHolder {
        // Using data binding
        ItemHorizontalHomeListBinding itemBinding;

        public RootViewHolder(@NonNull ItemHorizontalHomeListBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }


        // Bind the list with the horizontal recycler view
        public void bind(List<BookInfoModel> horizontalList, ItemClickListener itemClickListener) {
            // Layout manager
            LinearLayoutManager horizontalLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

            itemBinding.recyclerViewHorizontal.setLayoutManager(horizontalLinearLayoutManager);

            HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(context, horizontalList, itemClickListener);

            itemBinding.recyclerViewHorizontal.setAdapter(horizontalRecyclerViewAdapter);
        }
    }
}
