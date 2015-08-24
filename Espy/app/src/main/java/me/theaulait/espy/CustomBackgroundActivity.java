package me.theaulait.espy;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class CustomBackgroundActivity extends FragmentActivity {
    protected ViewPager backgroundImagePager = null;
    protected List<Integer> imageSlides;
    protected ImageViewerAdapter imageViewerAdapter;
    protected int currentBackgroundIndex = 0;
    protected Handler handler;
    Timer swipeTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        backgroundImagePager = (ViewPager) findViewById(R.id.background_image_pager);
        imageViewerAdapter = new ImageViewerAdapter(this);
        backgroundImagePager.setAdapter(imageViewerAdapter);

        imageSlides = new ArrayList<>();
        imageSlides.add(R.drawable.oysterbargrandcentral);
        imageSlides.add(R.drawable.devicion);
        imageSlides.add(R.drawable.venice_1);
        imageSlides.add(R.drawable.venice_2);
        imageSlides.add(R.drawable.venice_3);

        imageViewerAdapter.setImageResources(imageSlides);

         handler = new Handler();
    }

    @Override
    public void onResume() {
        super.onResume();
        startSlidingBackgroundImages();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (swipeTimer != null) {
            swipeTimer.cancel();
        }
    }

    protected void startSlidingBackgroundImages() {
        if (imageSlides.size() > 0) {

            final Runnable slideBackgroundImage = new Runnable() {
                public void run() {
                    if (currentBackgroundIndex == imageSlides.size() - 1) {
                        currentBackgroundIndex = 0;
                    }
                    backgroundImagePager.setCurrentItem(currentBackgroundIndex++, true);
                }
            };

            swipeTimer = new Timer();
            swipeTimer.schedule(new TimerTask() {

                @Override
                public void run() {
                    handler.post(slideBackgroundImage);
                }
            }, 1000, 3000);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_custom_background, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
