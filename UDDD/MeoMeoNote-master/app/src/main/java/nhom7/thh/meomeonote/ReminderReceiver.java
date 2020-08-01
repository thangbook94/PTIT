package nhom7.thh.meomeonote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent i = new Intent(context, ReminderService.class);
//        Toast.makeText(context, "haaaaa", Toast.LENGTH_LONG).show();
        int id = intent.getIntExtra("id", -1);
        Log.v("receiver", id + "");
        i.putExtra("id", id);
        context.startService(i);
    }
}
