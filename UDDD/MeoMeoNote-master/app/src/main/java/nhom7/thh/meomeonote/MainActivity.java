package nhom7.thh.meomeonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Checklist;
import nhom7.thh.meomeonote.util.BaseUtil;

public class MainActivity extends AppCompatActivity {

    boolean flag;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);
        final FloatingActionButton fabNote = findViewById(R.id.fab_note);
        final FloatingActionButton fabChecklist = findViewById(R.id.fab_checklist);
        final TextView tvNote = findViewById(R.id.tvNote);
        final TextView tvChecklist = findViewById(R.id.tvChecklist);
        flag = true;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    fabNote.show();
                    tvNote.setVisibility(View.VISIBLE);
                    fabChecklist.show();
                    tvChecklist.setVisibility(View.VISIBLE);

                    fabNote.animate().translationY(-(fabChecklist.getCustomSize() + fab.getCustomSize()));
                    fabChecklist.animate().translationY(-(fab.getCustomSize()));

                    fab.animate().rotation(180f);
                    fab.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
                    flag = false;

                } else {
                    fabNote.hide();
                    tvNote.setVisibility(View.INVISIBLE);
                    fabChecklist.hide();
                    tvChecklist.setVisibility(View.INVISIBLE);

                    fabNote.animate().translationY(0);
                    fabChecklist.animate().translationY(0);

                    fab.animate().rotation(360f);
                    fab.setImageResource(R.drawable.ic_baseline_add_24);
                    flag = true;

                }
            }
        });
        fabNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, NoteDetailActivity.class), 0);
            }
        });
        fabChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checklist c = new Checklist();
                c.setUser_id(9999);
                c.setStatus(1);
                c.setCreated(BaseUtil.getCurrentTime());
                c.setLast_modified(BaseUtil.getCurrentTime());
                int checklistId = (int) new DbHelper(getApplicationContext()).addChecklist(c);
                Intent intent = new Intent(MainActivity.this, ChecklistActivity.class);
                intent.putExtra("checklistId", checklistId);
                startActivityForResult(intent, 0);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_checklist, R.id.nav_calendar, R.id.nav_cats, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_layout_header, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivityForResult(new Intent(this, Sync.class), 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recreate();

    }
}