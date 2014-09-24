package pindro.pindro.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import pindro.pindro.R;

/**
 * Created by jeff on 9/23/14.
 */
public class RecentPinAdapter extends BaseAdapter {
    private Activity mContext;

    public RecentPinAdapter(Activity c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHolder {
        protected ImageView pinImage;
        protected TextView pinName;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            LayoutInflater inflater = mContext.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_recent_pin, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.pinImage = (ImageView) view.findViewById(R.id.recent_pin_image);
            viewHolder.pinName = (TextView) view.findViewById(R.id.recent_pin_name);
            view.setTag(viewHolder);

        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.pinImage.setImageResource(mThumbIds[position]);
        holder.pinName.setText("Awesome event " + position);

        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };
}
