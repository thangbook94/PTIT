package nhom7.thh.meomeonote.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.model.LineNote;
import nhom7.thh.meomeonote.util.BaseUtil;

public class LineNoteAdapter extends BaseAdapter {
    List<LineNote> lineNotes;
    Activity activity;

    public LineNoteAdapter(List<LineNote> lineNotes, Activity activity) {
        this.lineNotes = lineNotes;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return lineNotes.size();
    }

    @Override
    public Object getItem(int position) {
        return lineNotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.list_view_line_note, null);
        TextView title = convertView.findViewById(R.id.line_title);
        TextView shortContent = convertView.findViewById(R.id.line_short_content);
        TextView lastModified = convertView.findViewById(R.id.line_last_modified);
        ImageView catAvt = convertView.findViewById(R.id.line_cat_avt);
        ImageView reminderEnable = convertView.findViewById(R.id.line_reminder_enable);

        title.setText(lineNotes.get(position).getTitle());
        if (lineNotes.get(position).isLocked()) {
            shortContent.setText("****************************");
        } else {
            shortContent.setText(lineNotes.get(position).getShortContent());
        }
        lastModified.setText(lineNotes.get(position).getLastModified());
        catAvt.setImageResource(lineNotes.get(position).getCatAvt());
        reminderEnable.setVisibility(View.INVISIBLE);
        if (lineNotes.get(position).getTimer() != null
                && Calendar.getInstance().getTime().compareTo(BaseUtil.StringTimeToDate(lineNotes.get(position).getTimer())) <= 0) {
            reminderEnable.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}
