package com.renatojobal.libraryutpl.mainactivity.fnotification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemLoanBinding;
import com.renatojobal.libraryutpl.databinding.ItemNotificationBinding;
import com.renatojobal.libraryutpl.mainactivity.floan.LoanAdapter;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.NotificationModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    // Attributes
    LiveData<List<DetailedResponse>> notificationsList;


    /**
     * Constructor
     * @param notificationsList
     */
    public NotificationAdapter(LiveData<List<DetailedResponse>> notificationsList) {
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
        return notificationsList.getValue().indexOf(position);
    }


    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return size of the list
     */
    @Override
    public int getItemCount() {
        return notificationsList.getValue().size();
    }

    /**
     * Search the item
     * @param position of the item
     * @return the item instance
     */
    public DetailedResponse getItem(int position){
        return notificationsList.getValue().get(position);
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
            itemBinding.setNotification(detailedResponse.getNotificationInfo());

            itemBinding.book.setText(detailedResponse.getBookInfo().getTitle());
            itemBinding.tag.setText(detailedResponse.getSingularBookInfo().getTag());

        }
    }
}
