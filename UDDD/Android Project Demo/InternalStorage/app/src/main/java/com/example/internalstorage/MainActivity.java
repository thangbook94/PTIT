package com.example.internalstorage;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            //
            final String TESTSTRING = new String("Hello Android N04, abcd");

           FileOutputStream fOut = openFileOutput("samplefile.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            // Write the string to the file
            osw.write(TESTSTRING);

            //ensure that everything is
             // really written out and close
            osw.flush();
            osw.close();




            //Read from file

            FileInputStream fIn = openFileInput("samplefile.txt");
            InputStreamReader isr = new InputStreamReader(fIn);

            /* Prepare a char-Array that will
             * hold the chars we read back in. */
            char[] inputBuffer = new char[TESTSTRING.length()];

            // Fill the Buffer with data from the file
            isr.read(inputBuffer);

            // Transform the chars to a String
            String readString = new String(inputBuffer);

            Toast.makeText(MainActivity.this,readString,Toast.LENGTH_SHORT).show();


        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();

        }







    }
}
