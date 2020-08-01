package nhom7.thh.meomeonote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import nhom7.thh.meomeonote.dbhelper.DbHelper;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences = getSharedPreferences("bt1", MODE_PRIVATE);
        boolean isInit = sharedPreferences.getBoolean("init", true);
        if (isInit) {
            DbHelper dbHelper = new DbHelper(this);
            dbHelper.addCat("snowball", "Snowball", 1);
            dbHelper.addCat("shadow", "Shadow", 1);
            dbHelper.addCat("ms_fortune", "Ms. Fortune", 0);
            dbHelper.addCat("bengal_jack", "Bengal Jack", 1);
            dbHelper.addCat("bob_the_cat", "Bob The Cat", 1);
            dbHelper.addCat("chair", "Chairman meow", 1);
            dbHelper.addCat("great", "Ramses the Great", 1);
            dbHelper.addCat("guy", "Guy Furry", 1);
            dbHelper.addCat("hermeowne", "Hermeowne", 1);
            dbHelper.addCat("jeeves", "Jeeves", 0);
            dbHelper.addCat("joe_dimeowgio", "Joe DiMeowgio", 0);
            dbHelper.addCat("kathmandu", "Kathmandu", 1);
            dbHelper.addCat("meow", "Lady Meow-Meow", 0);
            dbHelper.addCat("meowgi", "Mr. Meowgi", 1);
            dbHelper.addCat("princess", "Princess", 0);
            dbHelper.addCat("pumpkin", "Pumpkin", 0);
            dbHelper.addCat("saint", "Saint Purrtrick", 0);
            dbHelper.addCat("sapphire", "Sapphire", 0);
            dbHelper.addCat("sassy_fran", "Sassy Fran", 0);
            dbHelper.addCat("senor_don_gato", "Senor Don Gato", 1);
            dbHelper.addCat("tubbs", "Tubbs", 1);
            dbHelper.addCat("whiskers", "Conductor Whiskers", 0);
            dbHelper.addCat("whiteshadow", "Whiteshadow", 1);
            dbHelper.addCat("xerxes", "Xerxes IX", 1);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("init", false);
            editor.apply();
        }

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(1000);  //Delay of 3 seconds
                } catch (Exception e) {
                    Log.v("error", e.toString());
                } finally {
                    Intent i = new Intent(Splash.this,
                            MainActivity.class);
//                    Intent i = new Intent(Splash.this,
//                            TestTimePicker.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}