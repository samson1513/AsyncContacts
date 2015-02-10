package com.example.AsyncContacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by samson on 04.02.2015.
 */
public class ContListAdapter extends BaseAdapter {

    private ArrayList<ContObj> mContacts;
    private LayoutInflater mLayoutInflater;

    public ContListAdapter(Context _context, ArrayList<ContObj> _contObjs){
        this.mContacts = _contObjs;
        this.mLayoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return mContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = mLayoutInflater.inflate(R.layout.item_list, null, false);

        TextView tvName = (TextView) itemView.findViewById(R.id.tvName);
        TextView tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);

        ContObj contactObject = mContacts.get(position);

        tvName.setText(contactObject.getmName());
        tvPhone.setText(contactObject.getmPhone());

        return itemView;
    }
}
