package com.islamicappsworld.baby.smart.growth;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.islamicappsworld.baby.smart.growth.MainPage;
import com.islamicappsworld.baby.smart.growth.Score;

/**
 * Created by Apple on 7/28/2016.
 */
public class timerclass extends AsyncTask<String,String,String>{

    TextView t;
    Context c;
    ProgressBar p;
    public timerclass(Context context,TextView textView)
    {
     c=context;
        t=textView;

    }
    public timerclass(Context c,ProgressBar progressBar)
    {
        this.c=c;
        this.p=progressBar;
    }
    @Override
    protected String doInBackground(String... params) {

        if (params[0].equals("Timer")) {
            int i = 31;

            synchronized (this) {
                while (i > 0) {
                    try {
                        wait(1000);
                        publishProgress("timer",""+i+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i--;
                }
            }

            return "Time over";
        }else
            if (params[0].equals("Progressbar"))
            {

                synchronized (this)
                {
                    int j=0;
                    while(j<=100)
                    {

                        try {
                            wait(100);
                            publishProgress("progress",""+j+"");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        j+=1;
                    }

                }
                return "progress over";
            }
        return  null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String aVoid) {

        if (aVoid.equals("Time over")) {
            t.setText(aVoid);
            Intent n = new Intent(c, Score.class);
            c.startActivity(n);
        }else
            if (aVoid.equals("progress over"))
            {
              Intent e=new Intent(c,MainPage.class);
                c.startActivity(e);

            }


    }

    @Override
    protected void onProgressUpdate(String... values) {

        if (values[0].equals("timer")) {
            int n = Integer.parseInt(values[1]);
            t.setText("" + n + "");
        }else
            if (values[0].equals("progress"))
            {
             int value=Integer.parseInt(values[1]);
                p.setProgress(value);
            }
    }
}
