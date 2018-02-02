package com.lakshay.tictaktoe;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int c=0;
    int [] x={0,0,0,0,0,0,0,0,0};
    int [][] winning = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void start (View view){
        ImageView m1 = (ImageView) view;
        int m=0;
        int t = Integer.parseInt(m1.getTag().toString());
        if(x[t-1]==0) {
            if (c == 0) {
                m1.setImageResource(R.drawable.tictaktoex);
                m = 1;
                c=1;
            } else {
                m1.setImageResource(R.drawable.tictaktoeo);
                m = 2;
                c=0;
            }
            x[t - 1] = m;
            m1.animate().alpha(1f).setDuration(1000);
            LinearLayout layout = (LinearLayout) findViewById(R.id.popup);
            TextView text = (TextView) findViewById(R.id.winnermessage);
            for(int i=0;i<8;i++)
            {
                if((x[winning[i][0]]==x[winning[i][1]]) && (x[winning[i][1]]==x[winning[i][2]]) && (x[winning[i][0]]!=0));
                {
                    if(x[winning[i][0]]==1)
                    {
                        System.out.println("Player 1 wins!");
                        text.setText("Player 1 wins!");
                        layout.setVisibility(View.VISIBLE);
                    }
                    else if(x[winning[i][0]]==2) {
                        System.out.println("Player 2 wins!");
                        text.setText("Player 2 wins!");
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
            int flag=0;
            for(int i=0;i<9;i++)
            {
                if(x[i]==0)
                    flag=1;
            }
            if(flag==0) {
                System.out.println("Its A Draw!");
                text.setText("Its A Draw!");
                layout.setVisibility(View.VISIBLE);
            }
        }
    }
    public void playagain(View view){

        LinearLayout layout = (LinearLayout) findViewById(R.id.popup);
        layout.setVisibility(View.INVISIBLE);
        c=0;
        for(int i=0;i<x.length;i++)
        {
            x[i]=0;
        }
        LinearLayout l1 = (LinearLayout) findViewById(R.id.XRow1);
        LinearLayout l2 = (LinearLayout) findViewById(R.id.XRow2);
        LinearLayout l3 = (LinearLayout) findViewById(R.id.XRow3);
        for(int i=0;i<l1.getChildCount();i++)
        {
            ((ImageView) l1.getChildAt(i)).setImageResource(0);
        }
        for(int i=0;i<l2.getChildCount();i++)
        {
            ((ImageView) l2.getChildAt(i)).setImageResource(0);
        }
        for(int i=0;i<l3.getChildCount();i++)
        {
            ((ImageView) l3.getChildAt(i)).setImageResource(0);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
