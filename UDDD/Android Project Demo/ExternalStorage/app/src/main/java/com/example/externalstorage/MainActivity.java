package com.example.externalstorage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView textViewStatus;

    File myExternalFile;
    private String filename = "MySampleFile.txt";
    private String filepath = "MyFileStorage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isExternalStorageAvailable())
        {
            Toast.makeText(MainActivity.this,"Storage Available",Toast.LENGTH_SHORT).show();
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
            try {
                FileOutputStream fos;
                fos = new FileOutputStream(myExternalFile);
                String textToWrite = "Write to External Storage N05";
                try {
                    fos.write(textToWrite.getBytes());
                    fos.close();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
            catch (FileNotFoundException fnf)
            {
                fnf.printStackTrace();
            }


            String myData = "";
            try {
                FileInputStream fis = new FileInputStream(myExternalFile);
                DataInputStream in = new DataInputStream(fis);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(in));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    myData = myData + strLine;
                }
                in.close();
                Toast.makeText(MainActivity.this,"data read:"+myData,Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (isExternalStorageReadOnly())
        {
            Toast.makeText(MainActivity.this,"Read Only",Toast.LENGTH_SHORT).show();
        }

    }


    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
