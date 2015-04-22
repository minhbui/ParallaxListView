package minh.bui.parallaxlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by minhbui on 22/04/15.
 */
public class DemoAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mItems;

    public DemoAdapter(Context context) {
        mContext = context;
        mItems = new String[200];
        for(int i = 0; i<mItems.length; i++) {
            mItems[i] = Integer.toString(i);
        }
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mItems[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(mItems[position]);

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }

}
