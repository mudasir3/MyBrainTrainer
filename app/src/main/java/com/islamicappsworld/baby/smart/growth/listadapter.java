package com.islamicappsworld.baby.smart.growth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.islamicappsworld.baby.smart.growth.R;
import com.islamicappsworld.baby.smart.growth.dataproviderforlistview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 7/30/2016.
 */
public class listadapter extends ArrayAdapter {

    List l=new ArrayList();
    @Override
    public void add(Object object) {
        super.add(object);
        l.add(object);
    }

    @Override
    public int getCount() {
        return this.l.size();
    }

    @Override
    public Object getItem(int position) {
        return this.l.get(position);
    }
    static class Datahandler
    {
        ImageView image;TextView title;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        Datahandler handler;
        if (convertView==null)
        {

            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.listviwlayout,parent,false);
            handler=new Datahandler();
            handler.image=(ImageView)row.findViewById(R.id.imageView);
            handler.title=(TextView)row.findViewById(R.id.eachitem);
            row.setTag(handler);

        }
        else
        {

            handler=(Datahandler)row.getTag();
        }

        dataproviderforlistview provider=(dataproviderforlistview)this.getItem(position);
        handler.image.setImageResource(provider.getImagesresourse());
        handler.title.setText(provider.getTitlesresourse());


        return row;
    }

    public listadapter(Context context, int resource) {
        super(context, resource);

    }
}
