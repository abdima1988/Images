package com.example.loader.images;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class ImagesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_images, new ImagesFragment()).commit();
        }
    }

}
