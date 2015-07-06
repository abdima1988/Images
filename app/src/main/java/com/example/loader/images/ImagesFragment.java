package com.example.loader.images;

import android.app.ActivityManager;
import android.content.Context;
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

import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitry on 03.07.2015.
 */

public class ImagesFragment extends Fragment {

    private static final int MAX_CHILD_COUNT = 24;

    private final String[] uris = {
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

    private List<String> listUris;

    private ImageAdapter mImageAdapter;
    private DisplayImageOptions displayImageOptions = null;

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
                ImageLoader.getInstance().clearMemoryCache();
                break;
            case R.id.action_clear_disk_cache:
                ImageLoader.getInstance().clearDiskCache();
                break;
            default:
                break;
        }

        mImageAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (!ImageLoader.getInstance().isInited()) {
            ImageLoader.getInstance().init(getImageLoaderConfiguration());
        }

        View rootView = inflater.inflate(R.layout.fragment_images, container, false);
        mImageAdapter = new ImageAdapter(getActivity(), listUris);
//                new ArrayAdapter<>(getActivity(), R.layout.list_item_text, R.id.list_item_text, urls);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_images);
        listView.setAdapter(mImageAdapter);

        return rootView;
    }
    /**
     File cacheDir = StorageUtils.getCacheDirectory(context);
     ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
     .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
     .diskCacheExtraOptions(480, 800, null)
     .taskExecutor(...)
     .taskExecutorForCachedImages(...)
     .threadPoolSize(3) // default
     .threadPriority(Thread.NORM_PRIORITY - 2) // default
     .tasksProcessingOrder(QueueProcessingType.FIFO) // default
     .denyCacheImageMultipleSizesInMemory()
     .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
     .memoryCacheSize(2 * 1024 * 1024)
     .memoryCacheSizePercentage(13) // default
     .diskCache(new UnlimitedDiscCache(cacheDir)) // default
     .diskCacheSize(50 * 1024 * 1024)
     .diskCacheFileCount(100)
     .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
     .imageDownloader(new BaseImageDownloader(context)) // default
     .imageDecoder(new BaseImageDecoder()) // default
     .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
     .writeDebugLogs()
     .build();
     **/
    public ImageLoaderConfiguration getImageLoaderConfiguration() {
        ImageLoaderConfiguration imageLoaderConfiguration;
        // default conf
//        imageLoaderConfiguration = ImageLoaderConfiguration.createDefault(getActivity().getApplicationContext());
        ActivityManager am = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = am.getMemoryClass();
        final int memoryCacheSize = 1024 * 1024 * memClass / 8;

        imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext())
                .memoryCache(new UsingFreqLimitedMemoryCache(memoryCacheSize)) // 2 Mb
//                .imageDownloader(new BaseImageDownloader(getActivity().getApplicationContext(), 5 * 1000, 30 * 1000))
                .denyCacheImageMultipleSizesInMemory()
                .defaultDisplayImageOptions(getDisplayImageOptions())
                .writeDebugLogs()
                .build();

        return imageLoaderConfiguration;
    }

    /**
     DisplayImageOptions options = new DisplayImageOptions.Builder()
     .showImageOnLoading(R.drawable.ic_stub) // resource or drawable
     .showImageForEmptyUri(R.drawable.ic_empty) // resource or drawable
     .showImageOnFail(R.drawable.ic_error) // resource or drawable
     .resetViewBeforeLoading(false)  // default
     .delayBeforeLoading(1000)
     .cacheInMemory(false) // default
     .cacheOnDisk(false) // default
     .preProcessor(...)
     .postProcessor(...)
     .extraForDownloader(...)
     .considerExifParams(false) // default
     .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
     .bitmapConfig(Bitmap.Config.ARGB_8888) // default
     .decodingOptions(...)
     .displayer(new SimpleBitmapDisplayer()) // default
     .handler(new Handler()) // default
     .build();
     **/
    public DisplayImageOptions getDisplayImageOptions() {
        DisplayImageOptions displayImageOptions = null;
        displayImageOptions = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.empty)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        return displayImageOptions;
    }
}
