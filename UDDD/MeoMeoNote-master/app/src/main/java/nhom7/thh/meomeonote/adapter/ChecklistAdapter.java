package nhom7.thh.meomeonote.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Checklist;

public class ChecklistAdapter extends BaseAdapter {
    List<Checklist> checklists;
    Activity activity;

    public ChecklistAdapter(List<Checklist> checklists, Activity activity) {
        this.checklists = checklists;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return checklists.size();
    }

    @Override
    public Object getItem(int position) {
        return checklists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.list_view_checklist, null);
        TextView title = convertView.findViewById(R.id.checklist_title);
        TextView number = convertView.findViewById(R.id.numberChecklistUndone);
        int num = new DbHelper(activity).getChecklistDetailUndoneByChecklistId(checklists.get(position).getId());
        int sum = new DbHelper(activity).getChecklistDetailByChecklistId(checklists.get(position).getId()).size();
        if (num != 0) {
            number.setTextColor(Color.RED);
        }
        number.setText((sum - num) + "/" + sum);
        TextView lastModified = convertView.findViewById(R.id.checklist_created);
        title.setText(checklists.get(position).getTitle());
        lastModified.setText(checklists.get(position).getLast_modified().split("\\s+")[1]);
        return convertView;
    }
}
