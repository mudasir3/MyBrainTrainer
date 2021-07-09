package com.islamicappsworld.baby.smart.growth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Arrays;
import java.util.Random;

public class Addition extends AppCompatActivity {

    private AdRequest adRequest ;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private int random_no=0;

    //final private UnityAdsListener unityAdsListener = new UnityAdsListener();

    //private static final String AD_UNIT_ID = "ca-app-pub-3108631327704776/8089511694";
    ImageView imageview;
    int level,l1count=0,l2count=0,l3count=0;
    public  static int score=0,attempts=0;
    public  static  String recentactivity;
    String key;
    TextView timer,question,levelview,Score;
    int wordsanswers=0,wordslevel;
    int currentresult;
    String currentresultforwords;
    Button op1button,op2button,op3button,op4button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //banner add
        //ads();

        //adView = new AdView(this);
        ///adView.setAdSize(AdSize.BANNER);
        //adView.setAdUnitId(AD_UNIT_ID);
        //RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.admob);
        //layout1.addView(adView);

        //AdRequest adRequest = new AdRequest.Builder().build();
        //adView.loadAd(adRequest);

        //banner add
        //interstitial
        /*mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3108631327704776/9857888934");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();*/
        //interstitial

        //UnityAds.initialize(this, getString(R.string.unity_id), unityAdsListener);

        mAdView = (AdView) this.findViewById(R.id.adView);

        adRequest = new AdRequest.Builder()
                .addTestDevice("33BE2250B43518CCDA7DE426D04EE232").build();

        mAdView.loadAd(adRequest);

        random_no=getRandomNumberInRange(1,3);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.intersetial_ad_unit_id));
        mInterstitialAd.loadAd(adRequest);
        if (random_no == 1) {
            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    showInterstitial();
                }
            });
        } else if (random_no == 2) {
            //if (UnityAds.isReady("rewardedVideo")) { //Make sure a video is available & the placement is valid.
             //   UnityAds.show(this, "rewardedVideo");
           //}
        } /*else if (random_no==3){
            startAppAd.loadAd();
            startAppAd.showAd();
        }*/ else {
            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    showInterstitial();
                }
            });
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else {
                    rateApp(Addition.this);
                }
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //   .setAction("Action", null).show();
            }
        });
//setting up the UI
        imageview=(ImageView)findViewById(R.id.imageviewanswer);

        score=0;
        attempts=0;
        op1button=(Button)findViewById(R.id.option1);
        op2button=(Button)findViewById(R.id.option2);
        op3button=(Button)findViewById(R.id.option3);
        op4button=(Button)findViewById(R.id.option4);
        question=(TextView)findViewById(R.id.question);
        timer=(TextView)findViewById(R.id.timer);
        levelview=(TextView)findViewById(R.id.levelview);
        Score=(TextView)findViewById(R.id.score);
        level=1;
        levelview.setText("Level 1");
        Score.setText("Score = 0");

//setting operation
        Intent e=getIntent();
         key= e.getStringExtra("key");
        recentactivity=key;
if (key.equals("Addition")) {
    startadditionlevel1();
}else
if (key.equals("Subtraction"))
{
    startsubtractionlevel1();
}else
if (key.equals("Multiplication"))
{
    startmultliplicationlevel1();
}else
if (key.equals("Devision"))
{
    startdevisionlevel1();
}else
if(key.equals("Alphabets"))
{
    startenglishtestlevel1();
}


        timerclass t = new timerclass(this, timer);
        t.execute("Timer");
        levelview.setText("Level = 1");

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void tick()
    {
        imageview.setImageResource(R.drawable.tick);
    }
    private void cross()
    {
        imageview.setImageResource(R.drawable.croos);
    }
    private void startenglishtestlevel1()
    {

        Score.setText("Score = "+score);
        String[] alphabets=new String[]
                {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] words=new String[]
                {
                        "Apple",
                        "Ball",
                        "Cat",
                        "Dog",
                        "Egg",
                        "Flag",
                        "Grapes",
                        "Home",
                        "Ink",
                        "Jungle",
                        "King",
                        "Lemon",
                        "Mother",
                        "Nose",
                        "Onion",
                        "Parents",
                        "Queen",
                        "Ring",
                        "Sister",
                        "Table",
                        "Urgent",
                        "Vain",
                        "Watch",
                        "XRay",
                        "Yummy",
                        "Zoo"

                };

               Random r=new Random();
               int n=r.nextInt(alphabets.length-0)+0;
        Log.d("alphabet at index", "" + n + "");
               String word=alphabets[n];
               question.setText(word+" for ?");
               String op1,op2,op3,op4;
              currentresultforwords=words[n];
        Log.d(""+currentresultforwords+"", "answer selected ");
             int v;
         do {

             v=r.nextInt(words.length-0)+0;
         }while (v==n);
               op2=words[v];
        int v1;
        do {

            v1=r.nextInt(words.length-0)+0;
        }while (v1==n||v1==v);
        op3=words[v1];

        int v2;
        do {

            v2=r.nextInt(words.length-0)+0;
        }while (v2==n||v2==v1||v2==v);
        op4=words[v2];

        String[] temparay=new String[]{currentresultforwords,op4,op3,op2};
        Arrays.sort(temparay);
        op1button.setText(""+temparay[0]+"");
        op2button.setText(""+temparay[3]+"");
        op3button.setText(""+temparay[1]+"");
        op4button.setText(""+temparay[2]+"");


    }


    private  void startmultliplicationlevel3()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 3");
        Random ran=new Random();
        int n1=ran.nextInt(10-5)+5;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(20-10)+10;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " * " + n2 + " = ? ");
        currentresult=n1*n2;
        String text=n1+" * "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(100-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(150-100)+100;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(250-160)+160;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[1]+"");
        op2button.setText(""+options[3]+"");
        op3button.setText(""+options[0]+"");
        op4button.setText("" + options[2] + "");





    }
    private  void startmutliplicationlevel2()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 2");
        Random ran=new Random();
        int n1=ran.nextInt(10-1)+10;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(5-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " * " + n2 + " = ? ");
        currentresult=n1*n2;
        String text=n1+" * "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1 = ran.nextInt(20 - 1) + 1;
        }while(op1==currentresult);

        do {
            op2 = ran.nextInt(40 - 10) + 10;
        }while (op2==currentresult);
        do {
            op3 = ran.nextInt(60 - 20) + 20;
        }while (op3==currentresult);

        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[0]+"");
        op2button.setText(""+options[2]+"");
        op3button.setText(""+options[1]+"");
        op4button.setText(""+options[3]+"");





    }
    private  void startmultliplicationlevel1()
    {

        Score.setText("Score =" + score);
        levelview.setText("Level 1");
        Random ran=new Random();
        int n1=ran.nextInt(5-1)+1;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(5-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " * " + n2 + " = ? ");
        currentresult=n1*n2;
        String text=n1+" * "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(20-10)+10;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(30-20)+20;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[3]+"");
        op2button.setText(""+options[0]+"");
        op3button.setText(""+options[2]+"");
        op4button.setText("" + options[1] + "");





    }

    private  void startsubtractionlevel3()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 3");
        Random ran=new Random();
        int n1=ran.nextInt(50-20)+20;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(30-10)+10;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " - " + n2 + " = ? ");
        currentresult=n1-n2;
        String text=n1+" - "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(20-10)+10;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(30-20)+20;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[1]+"");
        op2button.setText(""+options[3]+"");
        op3button.setText(""+options[0]+"");
        op4button.setText("" + options[2] + "");





    }
    private  void startsubtractionlevel2()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 2");
        Random ran=new Random();
        int n1=ran.nextInt(20-10)+10;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(9-1)+9;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " - " + n2 + " = ? ");
        currentresult=n1-n2;
        String text=n1+" - "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1 = ran.nextInt(10 - 1) + 1;
        }while(op1==currentresult);

        do {
            op2 = ran.nextInt(20 - 10) + 10;
        }while (op2==currentresult);
        do {
            op3 = ran.nextInt(30 - 20) + 20;
        }while (op3==currentresult);

        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[0]+"");
        op2button.setText(""+options[2]+"");
        op3button.setText(""+options[1]+"");
        op4button.setText(""+options[3]+"");





    }
    private  void startsubtractionlevel1()
    {

        Score.setText("Score =" + score);
        levelview.setText("Level 1");
        Random ran=new Random();
        int n1=ran.nextInt(10-1)+1;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(10-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " - " + n2 + " = ? ");
        currentresult=n1-n2;
        String text=n1+" - "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(20-10)+10;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(30-20)+20;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[3]+"");
        op2button.setText(""+options[0]+"");
        op3button.setText(""+options[2]+"");
        op4button.setText("" + options[1] + "");





    }
    private  void startadditionlevel3()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 3");
        Random ran=new Random();
        int n1=ran.nextInt(30-10)+10;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(20-10)+10;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " + " + n2 + " = ? ");
        currentresult=n1+n2;
        String text=n1+" + "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(20-10)+10;
        }while (op2==currentresult);
         do {
             op3=ran.nextInt(30-20)+20;
         }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[0]+"");
        op2button.setText(""+options[2]+"");
        op3button.setText(""+options[3]+"");
        op4button.setText("" + options[1] + "");





    }
    private  void startadditionlevel2()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 2");
        Random ran=new Random();
        int n1=ran.nextInt(20-10)+10;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(10-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " + " + n2 + " = ? ");
        currentresult=n1+n2;
        String text=n1+" + "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1 = ran.nextInt(10 - 1) + 1;
        }while(op1==currentresult);

            do {
               op2 = ran.nextInt(20 - 10) + 10;
            }while (op2==currentresult);
        do {
           op3 = ran.nextInt(30 - 20) + 20;
        }while (op3==currentresult);

        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[0]+"");
        op2button.setText(""+options[2]+"");
        op3button.setText(""+options[1]+"");
        op4button.setText(""+options[3]+"");





    }
    private  void startadditionlevel1()
    {

        Score.setText("Score ="+score);
        levelview.setText("Level 1");
        Random ran=new Random();
        int n1=ran.nextInt(10-1)+1;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(10-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " + " + n2 + " = ? ");
       currentresult=n1+n2;
        String text=n1+" + "+n2+" = ?";
       int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(20-10)+10;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(30-20)+20;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[3]+"");
        op2button.setText(""+options[0]+"");
        op3button.setText(""+options[2]+"");
        op4button.setText(""+options[1]+"");





    }

    private  void startdevisionlevel3()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 3");
        Random ran=new Random();
        int n1=ran.nextInt(100-10)+10;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(30-10)+10;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " / " + n2 + " = ? ");
        currentresult=n1/n2;
        String text=n1+" / "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(20-10)+10;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(30-20)+20;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[1]+"");
        op2button.setText(""+options[3]+"");
        op3button.setText(""+options[0]+"");
        op4button.setText("" + options[2] + "");





    }
    private  void startdevisionlevel2()
    {


        Score.setText("Score ="+score);
        levelview.setText("Level 2");
        Random ran=new Random();
        int n1=ran.nextInt(30-1)+1;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(10-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " / " + n2 + " = ? ");
        currentresult=n1/n2;
        String text=n1+" / "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1 = ran.nextInt(5 - 1) + 1;
        }while(op1==currentresult);

        do {
            op2 = ran.nextInt(8 - 5) + 5;
        }while (op2==currentresult);
        do {
            op3 = ran.nextInt(20 - 8) + 8;
        }while (op3==currentresult);

        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[0]+"");
        op2button.setText(""+options[2]+"");
        op3button.setText(""+options[1]+"");
        op4button.setText(""+options[3]+"");





    }
    private  void startdevisionlevel1()
    {

        Score.setText("Score ="+score);
        levelview.setText("Level 1");
        Random ran=new Random();
        int n1=ran.nextInt(10-5)+5;
        Log.e("r1=",+n1+" ");
        int n2=ran.nextInt(5-1)+1;
        Log.e("r3=",+n2+" ");
        question.setText("" + n1 + " / " + n2 + " = ? ");
        currentresult=n1/n2;
        String text=n1+" % "+n2+" = ?";
        int op1,op2,op3;
        do {
            op1=ran.nextInt(10-1)+1;
        }while (op1==currentresult);
        do {
            op2=ran.nextInt(10-5)+5;
        }while (op2==currentresult);
        do {
            op3=ran.nextInt(20-10)+10;
        }while (op3==currentresult);
        int[] options=new int[] {currentresult,op1,op2,op3};
        for(int i=0;i<options.length-1;i++)
        {
            for (int j=i+1;j<options.length;j++)
            {

                if(options[i]>options[j])
                {
                    int temp=options[i];
                    options[i]=options[j];
                    options[j]=temp;

                }
            }
        }
        op1button.setText(""+options[3]+"");
        op2button.setText(""+options[0]+"");
        op3button.setText(""+options[2]+"");
        op4button.setText(""+options[1]+"");





    }




    public  void option1click(View v)
    {

        attempts++;
        if(key.equals("Addition"))
        {
            Log.d("Addition", "detected");
            String text = op1button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                Log.d("answer", "correct");
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startadditionlevel2();
                        Log.d("sarting", "level2");
                    } else {
                        startadditionlevel1();
                        Log.d("starting", "level 1");
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startadditionlevel3();
                        Log.d("starting", " level3");
                    } else {
                        startadditionlevel2();
                        Log.d("starting", "level2");
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startadditionlevel3();
                    } else {
                        startadditionlevel3();
                        Log.d("starting", "level3");
                    }
                }


            } else {
                cross();
                if (level == 1) {
                    startadditionlevel1();
                    Log.d("starting", "level1");
                }else if (level == 2) {
                    startadditionlevel2();
                    Log.d("starting", "level2");
                } else if (level == 3)
                {
                    startadditionlevel3();
                    Log.d("starting", "level3");
                }
            }
        }else
        if (key.equals("Subtraction"))
        {
            String text = op1button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startsubtractionlevel2();
                    } else {
                        startsubtractionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startsubtractionlevel3();
                    } else {
                        startsubtractionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startsubtractionlevel3();
                    } else {
                        startsubtractionlevel3();
                    }
                }


            } else {
                cross();
                if (level == 1)
                    startsubtractionlevel1();
                else if (level == 2)
                    startsubtractionlevel2();
                else if (level == 3)
                   startsubtractionlevel3();
            }

        }else
        if(key.equals("Multiplication")){
            String text = op1button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
               tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                         startmutliplicationlevel2();
                    } else {
                        startmultliplicationlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startmultliplicationlevel3();
                    } else {
                        startmutliplicationlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                      startmultliplicationlevel3();
                    } else {
                    startmultliplicationlevel3();
                    }
                }


            } else {
             cross();
                if (level == 1)
                    startmultliplicationlevel1();
                else if (level == 2)
                    startmutliplicationlevel2();
                else if (level == 3)
                    startmultliplicationlevel3();
            }


        }else
            if (key.equals("Devision"))
            {

                String text = op1button.getText().toString();
                if (text.equals("" + currentresult + "")) {
                    score++;
                   tick();
                    if (level == 1) {
                        l1count++;
                        if (l1count == 2) {
                            level = 2;
                            startdevisionlevel2();
                        } else {
                            startdevisionlevel1();
                        }
                    } else if (level == 2) {
                        l2count++;
                        if (l2count == 3) {
                            level = 3;
                            startdevisionlevel3();
                        } else {
                            startdevisionlevel2();
                        }
                    } else if (level == 3) {
                        l3count++;
                        if (l3count == 5) {

                            startdevisionlevel3();
                        } else {
                            startdevisionlevel3();
                        }
                    }


                } else {
                    cross();
                    if (level == 1)
                        startdevisionlevel1();
                    else if (level == 2)
                        startdevisionlevel2();
                    else if (level == 3)
                        startdevisionlevel3();
                }



            }else
                if (key.equals("Alphabets"))
                {
                    String text=op1button.getText().toString();
                    if (currentresultforwords.equals(text)) {
                    score++;
                        startenglishtestlevel1();
                        tick();
                    }else
                    {
                        startenglishtestlevel1();
                    cross();
                    }


                }




    }
    public  void option2click(View v)
    {

        attempts++;
        if(key.equals("Addition")) {


            Log.d("Addition", "detected");
            String text = op2button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                Log.d("answer", "correct");
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startadditionlevel2();
                        Log.d("sarting", "level2");
                    } else {
                        startadditionlevel1();
                        Log.d("starting", "level 1");
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startadditionlevel3();
                        Log.d("starting", " level3");
                    } else {
                        startadditionlevel2();
                        Log.d("starting", "level2");
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startadditionlevel3();
                    } else {
                        startadditionlevel3();
                        Log.d("starting", "level3");
                    }
                }


            } else {
                cross();
                if (level == 1) {
                    startadditionlevel1();
                    Log.d("starting", "level1");
                }else if (level == 2) {
                    startadditionlevel2();
                    Log.d("starting", "level2");
                } else if (level == 3)
                {
                    startadditionlevel3();
                    Log.d("starting", "level3");
                }
            }
        }else
        if (key.equals("Subtraction"))
        {
            String text = op2button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startsubtractionlevel2();
                    } else {
                        startsubtractionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startsubtractionlevel3();
                    } else {
                        startadditionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startsubtractionlevel3();
                    } else {
                        startsubtractionlevel3();
                    }
                }


            } else {
               cross();
                if (level == 1)
                    startsubtractionlevel1();
                else if (level == 2)
                    startsubtractionlevel2();
                else if (level == 3)
                    startsubtractionlevel3();
            }

        }else
        if(key.equals("Multiplication")){
            String text = op2button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startmutliplicationlevel2();
                    } else {
                        startmultliplicationlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startmultliplicationlevel3();
                    } else {
                        startmutliplicationlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startmultliplicationlevel3();

                    } else {
                        startmultliplicationlevel3();
                    }
                }


            } else {
               cross();
                if (level == 1)
                    startmultliplicationlevel1();
                else if (level == 2)
                    startmutliplicationlevel2();
                else if (level == 3)
                    startmultliplicationlevel3();
            }


        }else
        if (key.equals("Devision"))
        {

            String text = op2button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startdevisionlevel2();
                    } else {
                        startdevisionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startdevisionlevel3();
                    } else {
                        startdevisionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startdevisionlevel3();
                    } else {
                        startdevisionlevel3();
                    }
                }


            } else {
               cross();
                if (level == 1)
                    startdevisionlevel1();
                else if (level == 2)
                    startdevisionlevel2();
                else if (level == 3)
                    startdevisionlevel3();
            }



        }else
        if (key.equals("Alphabets"))
        {
            String text=op2button.getText().toString();
            if (currentresultforwords.equals(text)) {
                score++;
                startenglishtestlevel1();
                tick();
            }else
            {
                startenglishtestlevel1();
                cross();
            }


        }

    }
    public  void option3click(View v)
    {


        attempts++;
        if(key.equals("Addition")) {


            Log.d("Addition", "detected");
            String text = op3button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                Log.d("answer", "correct");
               tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startadditionlevel2();
                        Log.d("sarting", "level2");
                    } else {
                        startadditionlevel1();
                        Log.d("starting", "level 1");
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startadditionlevel3();
                        Log.d("starting", " level3");
                    } else {
                        startadditionlevel2();
                        Log.d("starting", "level2");
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                    startadditionlevel3();
                    } else {
                        startadditionlevel3();
                        Log.d("starting", "level3");
                    }
                }


            } else {
               cross();
                if (level == 1) {
                    startadditionlevel1();
                    Log.d("starting", "level1");
                }else if (level == 2) {
                    startadditionlevel2();
                    Log.d("starting", "level2");
                } else if (level == 3)
                {
                    startadditionlevel3();
                    Log.d("starting", "level3");
                }
            }        }else
        if (key.equals("Subtraction"))
        {
            String text = op3button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startsubtractionlevel2();
                    } else {
                        startsubtractionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startsubtractionlevel3();
                    } else {
                        startadditionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                    startsubtractionlevel3();
                    } else {
                        startsubtractionlevel3();
                    }
                }


            } else {
               cross();
                if (level == 1)
                    startsubtractionlevel1();
                else if (level == 2)
                    startsubtractionlevel2();
                else if (level == 3)
                    startsubtractionlevel3();
            }

        }else
        if(key.equals("Multiplication")){
            String text = op3button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
               tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startmutliplicationlevel2();
                    } else {
                        startmultliplicationlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startmultliplicationlevel3();
                    } else {
                        startmutliplicationlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                       startmultliplicationlevel3();
                    } else {
                        startmultliplicationlevel3();
                    }
                }


            } else {
                cross();
                if (level == 1)
                    startmultliplicationlevel1();
                else if (level == 2)
                    startmutliplicationlevel2();
                else if (level == 3)
                    startmultliplicationlevel3();
            }


        }else
        if (key.equals("Devision"))
        {

            String text = op3button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startdevisionlevel2();
                    } else {
                        startdevisionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startdevisionlevel3();
                    } else {
                        startdevisionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startdevisionlevel3();
                    } else {
                        startdevisionlevel3();
                    }
                }


            } else {
                cross();
                if (level == 1)
                    startdevisionlevel1();
                else if (level == 2)
                    startdevisionlevel2();
                else if (level == 3)
                    startdevisionlevel3();
            }



        }else
        if (key.equals("Alphabets"))
        {
            String text=op3button.getText().toString();
            if (currentresultforwords.equals(text)) {
                score++;
                startenglishtestlevel1();
                tick();
            }else
            {
                startenglishtestlevel1();
                cross();
            }


        }
    }
    public  void option4click(View v) {


        attempts++;
        if(key.equals("Addition")) {


            Log.d("Addition", "detected");
            String text = op4button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                Log.d("answer", "correct");
               tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startadditionlevel2();
                        Log.d("sarting", "level2");
                    } else {
                        startadditionlevel1();
                        Log.d("starting", "level 1");
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startadditionlevel3();
                        Log.d("starting", " level3");
                    } else {
                        startadditionlevel2();
                        Log.d("starting", "level2");
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startadditionlevel3();
                    } else {
                        startadditionlevel3();
                        Log.d("starting", "level3");
                    }
                }


            } else {
               cross();
                if (level == 1) {
                    startadditionlevel1();
                    Log.d("starting", "level1");
                }else if (level == 2) {
                    startadditionlevel2();
                    Log.d("starting", "level2");
                } else if (level == 3)
                {
                    startadditionlevel3();
                    Log.d("starting", "level3");
                }
            }        }else
        if (key.equals("Subtraction"))
        {
            String text = op4button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
               tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startsubtractionlevel2();
                    } else {
                        startsubtractionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startsubtractionlevel3();
                    } else {
                        startsubtractionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                       startsubtractionlevel3();
                    } else {
                        startsubtractionlevel3();
                    }
                }


            } else {
              cross();
                if (level == 1)
                    startsubtractionlevel1();
                else if (level == 2)
                    startsubtractionlevel2();
                else if (level == 3)
                    startsubtractionlevel3();
            }

        }else
        if(key.equals("Multiplication")){
            String text = op4button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
                tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startmutliplicationlevel2();
                    } else {
                        startmultliplicationlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startmultliplicationlevel3();
                    } else {
                        startmutliplicationlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startmultliplicationlevel3();
                    } else {
                        startmultliplicationlevel3();
                    }
                }


            } else {
               cross();
                if (level == 1)
                    startmultliplicationlevel1();
                else if (level == 2)
                    startmutliplicationlevel2();
                else if (level == 3)
                    startmultliplicationlevel3();
            }


        }else
        if (key.equals("Devision"))
        {

            String text = op4button.getText().toString();
            if (text.equals("" + currentresult + "")) {
                score++;
               tick();
                if (level == 1) {
                    l1count++;
                    if (l1count == 2) {
                        level = 2;
                        startdevisionlevel2();
                    } else {
                        startdevisionlevel1();
                    }
                } else if (level == 2) {
                    l2count++;
                    if (l2count == 3) {
                        level = 3;
                        startdevisionlevel3();
                    } else {
                        startdevisionlevel2();
                    }
                } else if (level == 3) {
                    l3count++;
                    if (l3count == 5) {
                        startdevisionlevel3();
                    } else {
                        startdevisionlevel3();
                    }
                }


            } else {
               cross();
                if (level == 1)
                    startdevisionlevel1();
                else if (level == 2)
                    startdevisionlevel2();
                else if (level == 3)
                    startdevisionlevel3();
            }



        }else
        if (key.equals("Alphabets"))
        {
            String text=op4button.getText().toString();
            if (currentresultforwords.equals(text)) {
                score++;
                startenglishtestlevel1();
                tick();
            }else
            {
                startenglishtestlevel1();
                cross();
            }


        }

    }
    public static void rateApp(Activity activity)
    {Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }}

    /*private void requestNewInterstitial() {

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }*/

    protected void onDestroy() {

        if (mAdView != null) {
            mAdView.destroy();
        }

        super.onDestroy();
    }

    @Override
    protected void onPause() {

        if (mAdView != null) {
            mAdView.pause();
        }

        super.onPause();
    }

}
