package pindro.pindro.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pindro.pindro.R;
import pindro.pindro.helpers.ImageResizer;

/**
 * Created by jeff on 9/23/14.
 */
public class RecentPinAdapter extends BaseAdapter {
    private Activity mContext;
    private ImageResizer mImageResizer;

    public RecentPinAdapter(Activity c, ImageResizer imageResizer) {
        mContext = c;
        mImageResizer = imageResizer;
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
        protected LinearLayout pinAttendees;
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
            viewHolder.pinAttendees = (LinearLayout) view.findViewById(R.id.recent_pin_attendee_list);
            view.setTag(viewHolder);

        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        mImageResizer.loadImage(mThumbIds[position], holder.pinImage);
        while (holder.pinAttendees.getChildCount() < 8) {
            ImageView image = new ImageView(mContext);
            image.setImageResource(R.drawable.circle_blue);
            int size = mContext.getResources().getDimensionPixelSize(R.dimen.pin_profile_radius);
            image.setLayoutParams(new LinearLayout.LayoutParams(size, size, 0));
            holder.pinAttendees.addView(image);
            View blankView = new View(mContext);
            blankView.setLayoutParams(new LinearLayout.LayoutParams(1, 1, 1));
            holder.pinAttendees.addView(blankView);
        }

//        holder.pinImage.setImageBitmap(getRoundCornerBitmap(decodeSampledBitmapFromResource(mContext.getResources(),mThumbIds[position], holder.pinImage.getWidth(), holder.pinImage.getHeight()), 3));
        holder.pinName.setText("Awesome event " + position);

        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1
    };
}
