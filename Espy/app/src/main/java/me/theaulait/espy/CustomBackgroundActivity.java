package me.theaulait.espy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class CustomBackgroundActivity extends FragmentActivity {

//    private final TimerTask splashScreenFinished = new TimerTask() {
//        @Override
//        public void run() {
//            Intent splash = new Intent(CustomBackgroundActivity.this, MainActivity.class);
//            // We set these flags so the user cannot return to the SplashScreen
//            splash.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(splash);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView background= (ImageView)findViewById(R.id.instructionPage);
        AnimationDrawable frameAnimation =    (AnimationDrawable)background.getDrawable();
        frameAnimation.setCallback(background);
        frameAnimation.setVisible(true, true);
        frameAnimation.start();
//
//       final ViewPager splashViewPager = (ViewPager) findViewById(R.id.instructionPage);
//                        splashViewPager.setBackgroundResource(R.drawable.splash);
//
//        // We load the slide animation and apply it to the ImageView
//        Animation slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
//        splashViewPager.startAnimation(slide);

        // We use a Timer to schedule a TimerTask for 10 seconds in the future!
    //   Timer timer = new Timer();
    //    timer.schedule(this.splashScreenFinished, 10000);
    }

//    private CustomBackground mCustomBackgroundAdapter;
//    private ImageView mViewPager;
//    private Timer swipeTimer;
//    protected int currentPage;
//    private SharedPreferences.Editor editor;
//    int [] backgroundImage = {R.drawable.devicion, R.drawable.oysterbargrandcentral};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.instruction);
//
//        editor =  getApplicationContext().getSharedPreferences("Status", Context.MODE_PRIVATE).edit();
//
//        mCustomBackgroundAdapter = new CustomBackground(getApplicationContext(), backgroundImage);
//        mViewPager = (ViewPager) findViewById(R.id.instructionPage);
//        mViewPager.setAdapter(mCustomBackgroundAdapter);
//        mViewPager.beginFakeDrag();
//    }
//
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        final Activity activity = this;
//
//        swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (currentPage == mCustomBackgroundAdapter.getCount()) {
//                            currentPage = 0;
//                        }
//                        mViewPager.setCurrentItem(currentPage++, true);
//                    }
//                });
//            }
//        }, 1000, 5000);
//    }
//
//
//
//    public void onPause() {
//        super.onPause();
//        swipeTimer.cancel();
//    }

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
