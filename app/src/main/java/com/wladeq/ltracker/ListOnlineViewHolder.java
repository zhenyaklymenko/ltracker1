package com.wladeq.ltracker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by VladyslavIgnatenko on 23.01.2018.
 */

public class ListOnlineViewHolder extends RecyclerView.ViewHolder {
    public TextView txtEmail;
    public ListOnlineViewHolder(View itemView) {
        super(itemView);
        txtEmail = (TextView) itemView.findViewById(R.id.txt_email);
    }
}
