package healthcare.sajeel.com.healthcare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import healthcare.sajeel.com.healthcare.R;
import healthcare.sajeel.com.healthcare.model.Appointments;

public class AppointmentsAdapter extends BaseAdapter {
    private final Context mContext;
    private final Appointments[] appointments;

    /**
     * @param context Context
     * @param appointments
     */
    public AppointmentsAdapter(Context context, Appointments[] appointments) {
        this.mContext = context;
        this.appointments = appointments;
    }

    /**
     * Get count of the list
     * @return int
     */
    @Override
    public int getCount() {
      return appointments.length;
    }

    /**
     * Retrieve item/club id
     * @param position int
     * @return long
     */
    @Override
    public long getItemId(int position) {
      return 0;
    }

    /**
     * Get item
     * @param position int
     * @return null
     */
    @Override
    public Object getItem(int position) {
      return null;
    }

    /**
     * Append all the items with in the listview to render it on the screen
     * @param position int
     * @param convertView View
     * @param parent ViewGroup
     * @return View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Appointments appointment = appointments[position];

        /* View holder pattern */
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.fragment_appointments, null);

            final TextView itemId = (TextView)convertView.findViewById(R.id.item_id);
            final TextView itemTitle = (TextView)convertView.findViewById(R.id.item_title);
            final TextView itemAddress = (TextView)convertView.findViewById(R.id.item_address);
            final TextView itemTiming = (TextView)convertView.findViewById(R.id.item_timing);
            final ImageView itemPicture = (ImageView)convertView.findViewById(R.id.item_picture);
            final ImageView itemLogo = (ImageView)convertView.findViewById(R.id.item_logo);

            final ViewHolder viewHolder = new ViewHolder(itemId, itemTitle, itemAddress, itemTiming, itemPicture, itemLogo);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();
        viewHolder.itemId.setText(appointment.getId());
        viewHolder.itemTitle.setText(appointment.getTitle());
        viewHolder.itemAddress.setText(appointment.getAddress());
        viewHolder.itemTiming.setText(appointment.getTiming());

        Picasso.with(mContext).load(appointment.getPicture()).into(viewHolder.itemPicture);
        Picasso.with(mContext).load(appointment.getLogo()).into(viewHolder.itemLogo);

        return convertView;
    }

    private class ViewHolder {
        private final TextView itemId;
        private final TextView itemTitle;
        private final TextView itemAddress;
        private final TextView itemTiming;
        private final ImageView itemPicture;
        private final ImageView itemLogo;

        /**
         * @param itemId int
         * @param itemTitle String
         * @param itemAddress String
         * @param itemTiming String
         * @param itemPicture
         * @param itemLogo
         */
        public ViewHolder(TextView itemId, TextView itemTitle, TextView itemAddress, TextView itemTiming, ImageView itemPicture, ImageView itemLogo) {
            this.itemId = itemId;
            this.itemTitle = itemTitle;
            this.itemAddress = itemAddress;
            this.itemTiming = itemTiming;
            this.itemPicture = itemPicture;
            this.itemLogo = itemLogo;
        }
    }
}