package me.theaulait.espy;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by c4q-vanice on 8/15/15.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] mDataset;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mNameTextView;

        public ViewHolder(View v) {
            super(v);
            CardView cardView = (CardView) v.findViewById(R.id.card_view);
            mNameTextView = (TextView) cardView.findViewById(R.id.item_name);
        }
    }

    public Adapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venue, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mNameTextView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length; }
}