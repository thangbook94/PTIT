package nhom7.thh.meomeonote;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Note;

public class ReminderService extends Service {
    MediaPlayer mediaPlayer;

    public ReminderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_anh_hao_cove);
        mediaPlayer.start();
//        Toast.makeText(getApplicationContext(), "hihihihi", Toast.LENGTH_LONG).show();
        Log.v("ac", "ab");
        int id = intent.getIntExtra("id", -1);
        Log.v("service", id + "");
        DbHelper dbHelper = new DbHelper(this);
        Note note = dbHelper.getNoteById(id);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(note.getTitle())
                        .setContentText(note.getContent());

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = startId + "";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    startId + "",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        Intent resultIntent = new Intent(this, NoteDetailActivity.class);
        resultIntent.putExtra("id", note.getId());
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        notificationManager.notify(startId, mBuilder.build());

        return START_NOT_STICKY;
    }
}
