package nhom7.thh.meomeonote;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.dto.User;
import nhom7.thh.meomeonote.entity.Note;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Sync extends AppCompatActivity {
    EditText u;
    EditText p;
    Button log;
    String host = "https://1a5768b222bf.ngrok.io";
    String spSyncId;
    String spSyncU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        final TextView id = findViewById(R.id.sync_id);

        final Button account = findViewById(R.id.sync_account);
        final Button push = findViewById(R.id.sync_push);
        final Button pull = findViewById(R.id.sync_pull);

        final SharedPreferences sharedPreferences = getSharedPreferences("bt1", MODE_PRIVATE);
        spSyncId = sharedPreferences.getString("sync_id", null);
        spSyncU = sharedPreferences.getString("sync_u", null);
        if (spSyncId != null) {
            id.setTextColor(getResources().getColor(R.color.add_button_cat_foot_background));
            id.setText("Hello, " + spSyncU);
            account.setText("Change Account");

            push.setEnabled(true);
            pull.setEnabled(true);
        }

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Sync.this);
                LayoutInflater layoutInflater = Sync.this.getLayoutInflater();
                View v1 = layoutInflater.inflate(R.layout.dialog_login, null);
                builder.setView(v1);
                u = v1.findViewById(R.id.sync_u);
                p = v1.findViewById(R.id.sync_p);
                log = v1.findViewById(R.id.sync_log);

                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                log.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        OkHttpClient client = new OkHttpClient();
                        RequestBody body;

                        try {
                            String username = u.getText().toString().trim();
                            String password = p.getText().toString().trim();
                            if (!username.isEmpty() && !password.isEmpty()) {
                                body = RequestBody.create(MediaType.parse("application/json"),
                                        new ObjectMapper().writeValueAsString(new User(username, password)));
                                Request request = new Request.Builder().post(body)
                                        .url(host + "/log")
                                        .build();
                                client.newCall(request).enqueue(new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        Log.e("Error", "Network Error" + e);
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {

                                        final String json = response.body().string();
                                        Log.v("xxx", json);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (json.startsWith("Tunnel")) {
                                                    Toast.makeText(Sync.this, "Can't connect to server.", Toast.LENGTH_LONG).show();
                                                } else if (!json.equals("-1")) {
                                                    spSyncId = json;
                                                    spSyncU = u.getText().toString().trim();
                                                    id.setText("Hello, " + spSyncU);
                                                    id.setTextColor(getResources().getColor(R.color.add_button_cat_foot_background));
                                                    account.setText("Change Account");


                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    editor.putString("sync_id", spSyncId);
                                                    editor.putString("sync_u", spSyncU);
                                                    editor.apply();

                                                    push.setEnabled(true);
                                                    pull.setEnabled(true);
                                                    Toast.makeText(Sync.this, "Success!", Toast.LENGTH_LONG).show();
                                                    alertDialog.cancel();
                                                } else {
                                                    Toast.makeText(Sync.this, "Access denied!", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    }
                                });
                            } else {
                                Toast.makeText(Sync.this, "Please enter account info!", Toast.LENGTH_LONG).show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        });

        pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OkHttpClient client = new OkHttpClient();
                RequestBody body;

                Integer trueId = Integer.parseInt(spSyncId);
                Log.v("trueId", trueId + "");
                Request request = new Request.Builder()
                        .url(host + "/pull?id=" + trueId)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("Error", "Network Error");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        final String json = response.body().string();
                        Log.v("xxx", json);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (json.startsWith("Tunnel")) {
                                    Toast.makeText(Sync.this, "Can't connect to server.", Toast.LENGTH_LONG).show();
                                } else {
                                    if (json.equals("[]")) {
                                        Toast.makeText(Sync.this, "No data from server!", Toast.LENGTH_LONG).show();
                                    } else {
                                        Note[] notes = new Note[0];
                                        try {
                                            notes = new ObjectMapper().readValue(json, Note[].class);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        DbHelper dbHelper = new DbHelper(Sync.this);
                                        for (Note i : notes) {
                                            i.setUserId(9999);
                                            dbHelper.addNote(i);
                                        }
                                        Toast.makeText(Sync.this, "Get from server success!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });
                    }
                });

            }
        });

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OkHttpClient client = new OkHttpClient();
                RequestBody body;

                try {
                    DbHelper dbHelper = new DbHelper(Sync.this);
                    List<Note> notes = dbHelper.getNodeByUserId(9999);
                    Integer trueId = Integer.parseInt(spSyncId);
                    Log.v("trueId", trueId + "");
                    for (Note i : notes) {
                        i.setId(0);
                        i.setUserId(trueId);
                    }
                    body = RequestBody.create(MediaType.parse("application/json"),
                            new ObjectMapper().writeValueAsString(notes));
                    Request request = new Request.Builder().post(body)
                            .url(host + "/push")
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e("Error", "Network Error");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                            final String json = response.body().string();
//                            Log.v("xxx", json);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.v("xxx", json);
                                    if (json.startsWith("Tunnel")) {
                                        Toast.makeText(Sync.this, "Can't connect to server.", Toast.LENGTH_LONG).show();
                                    } else if (json.equals("ok"))
                                        Toast.makeText(Sync.this, "Save to Server success!", Toast.LENGTH_LONG);
                                    else
                                        Toast.makeText(Sync.this, "Save to Server failed!", Toast.LENGTH_LONG);
                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}