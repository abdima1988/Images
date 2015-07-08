package com.example.loader.images;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

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
        SimpleDraweeView image;
        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_drawee, parent, false);
            image = (SimpleDraweeView) view.findViewById(R.id.list_item_drawee_image);
            view.setTag(image);
        } else {
            image = (SimpleDraweeView) view.getTag();
        }
        //TODO load image
//        GenericDraweeHierarchyBuilder builder =
//                new GenericDraweeHierarchyBuilder(context.getResources());
//        GenericDraweeHierarchy hierarchy = builder
//                .setFadeDuration(50)
////                .setProgressBarImage(new ProgressBarDrawable())
//                .build();
//        image.setHierarchy(hierarchy);
        image.setImageURI(Uri.parse(uris.get(position)));

        return view;
    }
}
