package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.AlphaAnimation;
        import android.view.animation.Animation;
        import android.widget.Button;

        import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button play;
    DatabaseHelper mydb;
    public  static  String reffer;
    private int row_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);

        Animation mAnimation = new AlphaAnimation(1, 0);
        mAnimation.setDuration(400);
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.REVERSE);
        play.startAnimation(mAnimation);

        mydb= new DatabaseHelper(this);



        try{
            Cursor res=mydb.chk_open();
            row_num=res.getCount();
        }
        catch(Exception e){
            row_num=0;
        }
        if(row_num>0){
            Cursor res1=mydb.get_reffer_id();
            reffer=res1.getString(1);
        }
        else {
            mydb.insert_1st_open("125245");
            Random random =new Random();
            int number = random.nextInt(999999);
            mydb.insert_reffer_id(String.valueOf(number));
            reffer=String.valueOf(number);







        }

    }

    public void play(View view) {
        Intent intent = new Intent(this,play.class);
        startActivity(intent);
    }

    public void refer(View view) {
        Intent intent = new Intent(this,refer.class);
       startActivity(intent);

    }
    public void demo(View view) {
        Intent intent = new Intent(this,demo.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure to close this ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
