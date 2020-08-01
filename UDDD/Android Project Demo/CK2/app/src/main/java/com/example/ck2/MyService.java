package com.example.ck2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
//        List<User> list = (new DbHelper(getApplicationContext())).getAllUser();
//        for (User u : list) {
//            if (u.getId() % 3 == 0) {
//                Toast.makeText(getApplicationContext(), "Chuc mung sinh nhat: " + u.getHoTen(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), (new Date()).toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (System.currentTimeMillis() % 10 == 0) {
            Toast.makeText(getApplicationContext(), System.currentTimeMillis() + "", Toast.LENGTH_SHORT).show();
        }
        return START_NOT_STICKY;
    }
}
