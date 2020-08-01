package nhom7.thh.meomeonote;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import nhom7.thh.meomeonote.adapter.TabAdapter;
import nhom7.thh.meomeonote.ui.calendarinfo.ChecklistTabFragment;
import nhom7.thh.meomeonote.ui.calendarinfo.NoteTabFragment;

public class CalendarInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_info);
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        Intent intent = getIntent();
        final String date = intent.getStringExtra("date");
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        NoteTabFragment noteTabFragment = new NoteTabFragment();
        noteTabFragment.setDate(date);
        adapter.addFragment(noteTabFragment, "Note");
        ChecklistTabFragment checklistTabFragment = new ChecklistTabFragment();
        checklistTabFragment.setDate(date);
        adapter.addFragment(checklistTabFragment, "Checklist");
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }
}