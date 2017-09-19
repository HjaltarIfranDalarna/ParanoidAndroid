package com.example.melchior.lab2android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.app.Activity;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button btControl;
    int randomValue;
    boolean flac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editText);
        btControl = (Button)findViewById(R.id.button);

        randomValue = (int)(Math.random()*100);
        flac = false;
    }

    public void onClick(View v)
    {
        if(etInput.getText().length() == 0)
        {
            tvInfo.setText(getResources().getText(R.string.error));
        }
        else
        {
            int userChoice = Integer.parseInt(etInput.getText().toString());
            if(userChoice>100 || userChoice<0)
            {
                tvInfo.setText(getResources().getText(R.string.error));
            }
            else
            {
                if(!flac)
                {
                    if(userChoice == randomValue)
                    {
                        flac = true;
                        tvInfo.setText(getResources().getString(R.string.hit));
                        btControl.setText(getResources().getString(R.string.play_more));
                    }
                    else if (userChoice > randomValue)
                    {
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    }
                    else if (userChoice < randomValue)
                    {
                        tvInfo.setText(getResources().getString(R.string.behind));
                    }
                }
                else
                {
                    randomValue  = (int)(Math.random()*100);
                    flac = false;
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                }
                etInput.setText("");
            }
        }
    }
}
