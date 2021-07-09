package com.islamicappsworld.baby.smart.growth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainPage extends AppCompatActivity {
    //private AdView adView;
    //InterstitialAd mInterstitialAd;
    //private static final String AD_UNIT_ID = "ca-app-pub-3108631327704776/8089511694";

    listadapter myadapter;
    ArrayAdapter<String> adapter;
    ListView myview;
    int[] images={R.drawable.plus,R.drawable.minus,R.drawable.multiplication,R.drawable.division2,R.drawable.abc};
    String[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //banner add
        //ads();
        //adView = new AdView(this);
       //adView.setAdSize(AdSize.BANNER);
        //adView.setAdUnitId(AD_UNIT_ID);
        //RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.admob);
        //.addView(adView);

        //AdRequest adRequest = new AdRequest.Builder().build();
        //adView.loadAd(adRequest);
        //banner add
        //interstitial
        //mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3108631327704776/9857888934");
       // mInterstitialAd.setAdListener(new AdListener() {
           // @Override
           // public void onAdClosed() {
           //     requestNewInterstitial();
          //  }
        //});

       // requestNewInterstitial();
        //interstitial

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View view) {
                //if (mInterstitialAd.isLoaded()) {
                 //   mInterstitialAd.show();
               // }
                //else {
                //    rateApp(MainPage.this);
               // }

              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                   //     .setAction("Action", null).show();
         //   }
       // });


        list=getResources().getStringArray(R.array.options);
        myview=(ListView)findViewById(R.id.listView);
        myadapter=new listadapter(getApplicationContext(),R.layout.listviwlayout);
        myview.setAdapter(myadapter);
        int i=0;
        for(String text:list)
        {
            dataproviderforlistview t=new dataproviderforlistview(images[i],list[i]);
            myadapter.add(t);
            i++;
        }


        myview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent e=new Intent(getApplicationContext(),startwindow.class);
                if(position==0)
                {
                    e.putExtra("key","Addition");
                }else
                    if (position==1)
                    {
                        e.putExtra("key","Subtraction");
                    }else
                        if (position==2)
                        {
                            e.putExtra("key","Multiplication");
                        }else
                            if (position==3)
                            {
                                e.putExtra("key","Devision");
                            }else
                                if (position==4)
                                {
                                    e.putExtra("key","Alphabets");
                                }
                startActivity(e);


            }
        });



    }
    /*public static void rateApp(Activity activity)
    {Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }}*/
    /*private void requestNewInterstitial() {

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }*/
}
