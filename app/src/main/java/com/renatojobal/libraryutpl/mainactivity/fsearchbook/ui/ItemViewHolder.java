package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ItemSampleBookBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    // Using data binding
    ItemSampleBookBinding itemBinding;

    // Ui elements

    public TextView title;
    public TextView author;

    public ItemViewHolder(ItemSampleBookBinding itemBinding) {
        /** Constructor */
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;

        title = itemView.findViewById(R.id.title);
        author = itemView.findViewById(R.id.author);

    }





}
