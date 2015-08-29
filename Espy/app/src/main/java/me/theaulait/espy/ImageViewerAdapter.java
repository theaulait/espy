package me.theaulait.espy;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

public class ImageViewerAdapter extends PagerAdapter {

    private static final String TAG = ImageViewerAdapter.class.getSimpleName();
    protected List<Integer> mImageResources;
    protected LayoutInflater mInflater;
    protected Context mContext;

    public ImageViewerAdapter(Context context) {
        super();
        mContext = context;
        mInflater = LayoutInflater.from(context);

    }

    public void setImageResources(List<Integer> ImageResources) {
        mImageResources = ImageResources;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mImageResources != null) {
            return mImageResources.size();
        }
        return 0;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(R.layout.slided_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.StartupBackgroundImage);

        int slideImage = mImageResources.get(position);

        slideImageView.setImageResource(slideImage);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }
}

