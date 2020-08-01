package nhom7.thh.meomeonote.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.ChecklistDetail;
import nhom7.thh.meomeonote.util.BaseUtil;

public class ChecklistDetailAdapter extends BaseAdapter {
    List<ChecklistDetail> checklistDetailList;
    Activity activity;

    public ChecklistDetailAdapter(List<ChecklistDetail> checklistDetailList, Activity activity) {
        this.checklistDetailList = checklistDetailList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return checklistDetailList.size();
    }

    @Override
    public Object getItem(int position) {
        return checklistDetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.list_view_checklist_detail, null);
        TextView content = convertView.findViewById(R.id.checklistContent);
        String contentText = checklistDetailList.get(position).getContent() == null ? "null" : checklistDetailList.get(position).getContent();
        content.setText(contentText);
        content.setTextColor(Color.BLACK);
        TextView created = convertView.findViewById(R.id.checklistDatecreated);
        created.setText((checklistDetailList.get(position).getCreated().split("\\s+"))[1]);
        created.setTextColor(Color.RED);
        CheckBox checkBox = convertView.findViewById(R.id.checkBoxChecklist);
        if (1 == checklistDetailList.get(position).getStatus()) {
            checkBox.setChecked(false);
        } else if (checklistDetailList.get(position).getStatus() == 2) {
            checkBox.setChecked(true);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checklistDetailList.get(position).setStatus(2);
                } else {
                    checklistDetailList.get(position).setStatus(1);
                }
                new DbHelper(activity).updateChecklistDetail(checklistDetailList.get(position));
            }
        });
        content.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ChecklistDetail checklistDetail = checklistDetailList.get(position);
                checklistDetail.setLast_modified(BaseUtil.getCurrentTime());
                checklistDetail.setDateRemove(BaseUtil.getCurrentTime());
                checklistDetail.setStatus(0);
                new DbHelper(activity).deleteChecklistDetail(checklistDetail);
                activity.recreate();
                return true;
            }
        });
        return convertView;
    }
}
