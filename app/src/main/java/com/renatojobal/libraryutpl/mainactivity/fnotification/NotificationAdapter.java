package com.renatojobal.libraryutpl.mainactivity.fnotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemNotificationBinding;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    // Attributes
    ArrayList<DetailedResponse> notificationsList;


    // Filters
    Boolean notReturned = true;
    Boolean incorrectPosition = true;


    /**
     * Constructor
     * @param notificationsList
     */
    public NotificationAdapter(ArrayList notificationsList) {
        this.notificationsList = notificationsList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ItemNotificationBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_notification, parent, false);


        // Return the view holder with the elements attached
        MyViewHolder viewHolder = new MyViewHolder(binding);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        DetailedResponse internalLoan = getItem(position);

        // - replace the contents of the view with that element
        // holder.title.setText(sampleBook.getFkBookInfoModel());
        holder.bind(internalLoan);
    }

    /**
     * Search the item
     * @param position of the item
     * @return the item id
     */
    @Override
    public long getItemId(int position) {
        return notificationsList.indexOf(position);
    }


    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return size of the list
     */
    @Override
    public int getItemCount() {
        return notificationsList.size();
    }

    /**
     * Search the item
     * @param position of the item
     * @return the item instance
     */
    public DetailedResponse getItem(int position){
        return notificationsList.get(position);
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Using data binding
        ItemNotificationBinding itemBinding;


        /**
         * Constructor
         * @param itemBinding binding instance
         */
        public MyViewHolder(ItemNotificationBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;

        }

        /**
         * Bind the item to the xml file
         */
        public void bind(DetailedResponse detailedResponse) {



            Picasso.get()
                    .load(detailedResponse.getBookInfo().getBookImage())
                    .fit()
                    .into(itemBinding.bookCoverPage);

            itemBinding.setNotification(detailedResponse.getNotification());

            itemBinding.book.setText(detailedResponse.getBookInfo().getTitle());
            itemBinding.tag.setText(detailedResponse.getSingularBook().getTag());
            itemBinding.location.setText(detailedResponse.getActualShelf().getLocation());

        }
    }
}
