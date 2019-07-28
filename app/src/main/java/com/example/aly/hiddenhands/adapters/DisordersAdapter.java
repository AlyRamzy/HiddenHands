package com.example.aly.hiddenhands.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aly.hiddenhands.DataStructures.Disorders;
import com.example.aly.hiddenhands.R;

import org.w3c.dom.Text;

import java.util.List;

public class DisordersAdapter extends ArrayAdapter<Disorders>{

    public DisordersAdapter(@NonNull Context context,  @NonNull List<Disorders> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null) {
            view= LayoutInflater.from(getContext()).inflate(R.layout.disorder_item_list,parent,false);
        }

        Disorders Current = getItem(position);

        TextView DisorderName = (TextView) view.findViewById(R.id.disorder);
        DisorderName.setText(Current.getName());

        ImageView DisorderIcon = (ImageView) view.findViewById(R.id.icon);
        DisorderIcon.setImageResource(Current.getIconID());

        return view;
    }
}
