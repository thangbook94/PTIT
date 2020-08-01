package nhom7.thh.meomeonote.ui.calendarinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import nhom7.thh.meomeonote.ChecklistActivity;
import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.adapter.ChecklistAdapter;
import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Checklist;
import nhom7.thh.meomeonote.util.BaseUtil;

public class ChecklistTabFragment extends Fragment {
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_two, container, false);
        ListView listChecklist = root.findViewById(R.id.checklistFragmentListview);
        final DbHelper dbHelper = new DbHelper(getContext());
        final List<Checklist> checklist = dbHelper.getChecklistByUserIdAndDate(9999, date);
        ChecklistAdapter checklistAdapter = new ChecklistAdapter(checklist, getActivity());
        listChecklist.setAdapter(checklistAdapter);
        listChecklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(getActivity(), ChecklistActivity.class);
                intent.putExtra("checklist", checklist.get(position));
                startActivityForResult(intent, 0);

            }
        });
        listChecklist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Checklist c = checklist.get(position);
                c.setLast_modified(BaseUtil.getCurrentTime());
                dbHelper.deleteChecklist(c);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(ChecklistTabFragment.this).attach(ChecklistTabFragment.this).commit();
                return true;
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(ChecklistTabFragment.this).attach(ChecklistTabFragment.this).commit();
    }
}
