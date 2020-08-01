package nhom7.thh.meomeonote.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import nhom7.thh.meomeonote.R;

public class GridViewICatIconAdapter extends BaseAdapter {
    List<Integer> imageViews;
    Activity activity;

    public GridViewICatIconAdapter(List<Integer> imageViews, Activity activity) {
        this.imageViews = imageViews;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public Object getItem(int position) {
        return imageViews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.gridview_cat_icon_item, null);
        ImageView catAvt = convertView.findViewById(R.id.gridview_item_avt);
        catAvt.setImageResource(imageViews.get(position));
        return convertView;
    }
}
