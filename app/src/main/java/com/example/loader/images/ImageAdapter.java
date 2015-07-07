package com.example.loader.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Dmitry on 06.07.2015.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> uris;

    public ImageAdapter(Context context, List<String> uris) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.uris = uris;
    }

    @Override
    public int getCount() {
        return uris.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ImageView image;
        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_image, parent, false);
            image = (ImageView) view.findViewById(R.id.list_item_image);
            view.setTag(image);
        } else {
            image = (ImageView) view.getTag();
        }
        //TODO load image

        return view;
    }
}
