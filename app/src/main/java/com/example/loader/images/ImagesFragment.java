package com.example.loader.images;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitry on 03.07.2015.
 */

public class ImagesFragment extends Fragment {

    private final String[] uris_1 = {
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/bentley.png",
            "http://developer.android.com/auto/images/logos/auto/chevrolet.png",
            "http://developer.android.com/auto/images/logos/auto/chrysler.png",
            "http://developer.android.com/auto/images/logos/auto/dodge.png",
            "http://developer.android.com/auto/images/logos/auto/fiat.png",
            "http://developer.android.com/auto/images/logos/auto/ford.png",
            "http://developer.android.com/auto/images/logos/auto/honda.png",
            "http://developer.android.com/auto/images/logos/auto/hyundai.png",
            "http://developer.android.com/auto/images/logos/auto/infinity.png",
            "http://developer.android.com/auto/images/logos/auto/jeep.png",
            "http://developer.android.com/auto/images/logos/auto/kia.png",
            "http://developer.android.com/auto/images/logos/auto/maserati.png",
            "http://developer.android.com/auto/images/logos/auto/mazda.png",
            "http://developer.android.com/auto/images/logos/auto/mitsubishi.png",
            "http://developer.android.com/auto/images/logos/auto/nissan.png",
            "http://developer.android.com/auto/images/logos/auto/opel.png",
            "http://developer.android.com/auto/images/logos/auto/ram.png",
            "http://developer.android.com/auto/images/logos/auto/renault.png",
            "http://developer.android.com/auto/images/logos/auto/seat.png",
            "http://developer.android.com/auto/images/logos/auto/skoda.png",
            "http://developer.android.com/auto/images/logos/auto/subaru.png",
            "http://developer.android.com/auto/images/logos/auto/suzuki.png",
            "http://developer.android.com/auto/images/logos/auto/volkswagen.png",
            "http://developer.android.com/auto/images/logos/auto/volvo.png",
            "http://upload.wikimedia.org/wikipedia/commons/6/66/Big_size_chess_6759_CRI_08_2009_Langosta_Beach.jpg"
    };

    private final String[] uris = {
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png",
            "http://developer.android.com/auto/images/logos/auto/abarth.png",
            "http://developer.android.com/auto/images/logos/auto/acura.png",
            "http://developer.android.com/auto/images/logos/auto/alpharomeo.png",
            "http://developer.android.com/auto/images/logos/auto/audi.png"
    };

    private List<String> listUris;
    private ImageAdapter mImageAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        listUris = new ArrayList<>();
        listUris.addAll(Arrays.asList(uris));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_refresh, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_decrease:
                listUris.remove(listUris.size() - 1);
                break;
            case R.id.action_restore:
                listUris.clear();
                listUris.addAll(Arrays.asList(uris));
                break;
            case R.id.action_clear_memory_cache:
                //TODO clear memory cache if possible
                break;
            case R.id.action_clear_disk_cache:
                //TODO clear disk cache if possible
                break;
            default:
                break;
        }

        mImageAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_images, container, false);
        mImageAdapter = new ImageAdapter(getActivity(), listUris);
//                new ArrayAdapter<>(getActivity(), R.layout.list_item_text, R.id.list_item_text, urls);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_images);
        listView.setAdapter(mImageAdapter);

        return rootView;
    }

}
