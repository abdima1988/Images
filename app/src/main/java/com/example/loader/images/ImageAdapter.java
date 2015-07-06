package com.example.loader.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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
//        options = ImageLoaderConfiguration.defaultDisplayImageOptions();
//        options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.ic_stub)
//                .showImageForEmptyUri(R.drawable.ic_empty)
//                .showImageOnFail(R.drawable.ic_error)
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .considerExifParams(true)
//                .displayer(new RoundedBitmapDisplayer(20)).build();
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
        Picasso.with(context)
                .load(uris.get(position))
                .into(image);
//        ImageLoader.getInstance().displayImage(uris.get(position), image);


        return view;
    }
}
