package nhom7.thh.meomeonote.ui.checklist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import nhom7.thh.meomeonote.ChecklistActivity;
import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.adapter.ChecklistAdapter;
import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Checklist;
import nhom7.thh.meomeonote.entity.ChecklistDetail;
import nhom7.thh.meomeonote.util.BaseUtil;

public class ChecklistFragment extends Fragment {

    View root;
    ListView listView;
    DbHelper dbHelper;
    List<Checklist> checklists;
    //    DbHelper dbHelper;
//    List<ChecklistDetail> checklistDetails;
//    ListView listChecklist;
//    View root;
//    Button button;
//    ChecklistDetailAdapter checklistDetailAdapter;
    private ChecklistViewModel checklistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checklistViewModel =
                ViewModelProviders.of(this).get(ChecklistViewModel.class);
        root = inflater.inflate(R.layout.fragment_checklist, container, false);
        listView = root.findViewById(R.id.listChecklist);
        dbHelper = new DbHelper(getContext());
        checklists = new ArrayList<>();
        checklists = dbHelper.getChecklistByUserId(9999);
        Log.v("size", checklists.size() + "");
        ChecklistAdapter checklistAdapter = new ChecklistAdapter(checklists, getActivity());
        listView.setAdapter(checklistAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Checklist c = checklists.get(position);
                c.setLast_modified(BaseUtil.getCurrentTime());
                dbHelper.deleteChecklist(c);
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(getActivity(), ChecklistActivity.class);
                intent.putExtra("checklist", checklists.get(position));
                startActivityForResult(intent, 0);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Checklist c = checklists.get(position);
                int idChecklist = c.getId();
                c.setStatus(0);
                List<ChecklistDetail> checklistDetails = dbHelper.getChecklistDetailByChecklistId(idChecklist);
                for (ChecklistDetail dt : checklistDetails) {
                    dt.setStatus(0);
                    dt.setDateRemove(BaseUtil.getCurrentTime());
                    dt.setLast_modified(BaseUtil.getCurrentTime());
                    dbHelper.updateChecklistDetail(dt);
                }
                dbHelper.deleteChecklist(c);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(ChecklistFragment.this).attach(ChecklistFragment.this).commit();
                return true;
            }
        });
        return root;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(ChecklistFragment.this).attach(ChecklistFragment.this).commit();
    }
    //        root = inflater.inflate(R.layout.fragment_checklist, container, false);
//        listChecklist = root.findViewById(R.id.listChecklist);
//        button = root.findViewById(R.id.addChecklistBtn);
//        checklistDetails = new ArrayList<>();
//        try {
//            dbHelper = new DbHelper(getActivity().getApplicationContext());
//            checklistDetails = dbHelper.getChecklistDetailByChecklist(9999);
//            Log.v("size", checklistDetails.size() + "");
//            checklistDetailAdapter = new ChecklistDetailAdapter(checklistDetails, getActivity());
//            listChecklist.setAdapter(checklistDetailAdapter);
//
//        } catch (Exception e) {
//            Log.v("error", e.toString());
//        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                LayoutInflater inflaterPw = getLayoutInflater();
//                View v = inflaterPw.inflate(R.layout.dialog_add_checklist, null);
//                builder.setView(v);
//                final EditText content = v.findViewById(R.id.add_checklist_edt);
//                Button ok = v.findViewById(R.id.add_checklist_ok_btn);
//                Button cancel = v.findViewById(R.id.add_checklist_cancel_btn);
//                TextView name = v.findViewById(R.id.textView2);
//                name.setText("Add checklist");
//                final AlertDialog dialog = builder.create();
//                ok.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (content.getText().toString() != null) {
//                            ChecklistDetail c = new ChecklistDetail();
//                            c.setStatus(1);
//                            c.setChecklist_id(9999);
//                            c.setContent(content.getText().toString());
//                            c.setCreated(BaseUtil.getCurrentTime());
//                            c.setLast_modified(BaseUtil.getCurrentTime());
//                            dbHelper.addChecklistDetail(c);
//                            FragmentTransaction ft = getFragmentManager().beginTransaction();
//                            ft.detach(ChecklistFragment.this).attach(ChecklistFragment.this).commit();
//                        } else {
//                            Toast.makeText(getContext(), "No content", Toast.LENGTH_LONG).show();
//                        }
//                        dialog.cancel();
//                    }
//                });
//                cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(getContext(), "Cancel", Toast.LENGTH_LONG).show();
//                        dialog.cancel();
//                    }
//                });
//                dialog.show();
//                dialog.getWindow().setLayout(700, 700);
//            }
//        });
//        listChecklist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                ChecklistDetail c = checklistDetails.get(position);
//                c.setDateRemove(BaseUtil.getCurrentTime());
//                dbHelper.deleteChecklistDetail(c);
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.detach(ChecklistFragment.this).attach(ChecklistFragment.this).commit();
//                return true;
//            }
//        });
//        listChecklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                LayoutInflater inflaterPw = getLayoutInflater();
//                View v = inflaterPw.inflate(R.layout.dialog_add_checklist, null);
//                builder.setView(v);
//                final EditText content = v.findViewById(R.id.add_checklist_edt);
//                content.setText(checklistDetails.get(position).getContent());
//                Button ok = v.findViewById(R.id.add_checklist_ok_btn);
//                Button cancel = v.findViewById(R.id.add_checklist_cancel_btn);
//                TextView name = v.findViewById(R.id.textView2);
//                name.setText("Modify checklist");
//                final AlertDialog dialog = builder.create();
//                ok.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (content.getText().toString() != null) {
//                            ChecklistDetail c = checklistDetails.get(position);
//                            c.setContent(content.getText().toString());
//                            dbHelper.updateChecklistDetail(c);
//                            FragmentTransaction ft = getFragmentManager().beginTransaction();
//                            ft.detach(ChecklistFragment.this).attach(ChecklistFragment.this).commit();
//                        } else {
//                            Toast.makeText(getContext(), "No content", Toast.LENGTH_LONG).show();
//                        }
//                        dialog.cancel();
//                    }
//                });
//                cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(getContext(), "Cancel", Toast.LENGTH_LONG).show();
//                        dialog.cancel();
//                    }
//                });
//                dialog.show();
//                dialog.getWindow().setLayout(700, 700);
//            }
//        });
//
//        return root;

}