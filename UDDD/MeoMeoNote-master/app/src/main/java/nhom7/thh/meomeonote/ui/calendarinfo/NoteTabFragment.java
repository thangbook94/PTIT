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

import java.util.ArrayList;
import java.util.List;

import nhom7.thh.meomeonote.NoteDetailActivity;
import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.adapter.LineNoteAdapter;
import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Note;
import nhom7.thh.meomeonote.model.LineNote;
import nhom7.thh.meomeonote.util.Mapper;

public class NoteTabFragment extends Fragment {
    String date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_one, container, false);
        ListView listView = root.findViewById(R.id.noteFragmentListview);
        List<LineNote> lineNotes = new ArrayList<>();
        DbHelper dbHelper = new DbHelper(getContext());
        final List<Note> notes = dbHelper.getNodeByUserIdAndDate(9999, date);
        for (Note i : notes) {
            lineNotes.add(Mapper.mapNoteEntityToLineNote(i, getActivity()));
        }
        LineNoteAdapter lineNoteAdapter = new LineNoteAdapter(lineNotes, getActivity());
        listView.setAdapter(lineNoteAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), NoteDetailActivity.class);
                i.putExtra("note", notes.get(position));
                startActivityForResult(i, 0);
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(NoteTabFragment.this).attach(NoteTabFragment.this).commit();
    }

    public void setDate(String date) {
        this.date = date;
    }
}
