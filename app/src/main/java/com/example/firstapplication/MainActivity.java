package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button button;
    private TextView textView;
    private EditText editText;
    private Switch switchPart;
    private SeekBar seekBar;
    private ConstraintLayout constraintLayout;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();
        button = findViewById(R.id.confirm_button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        switchPart = findViewById(R.id.switchPart);
        seekBar = findViewById(R.id.seekBar);
        constraintLayout = findViewById(R.id.background);

        //button
        final ColorStateList buttonTextColor = button.getTextColors();
        //textView
        final ColorStateList textViewColor = textView.getTextColors();
        final float textSize = textView.getTextSize();
        //editText
        final ColorStateList editTextColor = editText.getTextColors();
        //switch
        final ColorStateList switchColor = switchPart.getTextColors();

        final int buttonBackgroundColor = res.getColor(R.color.buttonBackground);
        final int backgroundColor = Color.WHITE;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editText.getText().toString();
                if(!temp.equals(res.getString(R.string.edit_blank))){
                    textView.setText(temp);
                    Log.d(TAG, "sendText: " + temp);
                }
            }
        });

        switchPart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    constraintLayout.setBackgroundColor(res.getColor(R.color.colorDarkGray));
                    button.setTextColor(res.getColor((R.color.textInDark)));
                    button.setBackgroundColor(res.getColor(R.color.darkButton));
                    textView.setTextColor(res.getColor((R.color.textInDark)));
                    editText.setTextColor(res.getColor((R.color.textInDark)));
                    switchPart.setTextColor(res.getColor((R.color.textInDark)));
                    Toast toast = Toast.makeText(MainActivity.this, "启动夜间模式", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.d(TAG, "Night");
                }
                else{
                    constraintLayout.setBackgroundColor(backgroundColor);
                    button.setTextColor(buttonTextColor);
                    button.setBackgroundColor(buttonBackgroundColor);
                    textView.setTextColor(textViewColor);
                    editText.setTextColor(editTextColor);
                    switchPart.setTextColor(switchColor);
                    Toast toast = Toast.makeText(MainActivity.this, "启动白天模式", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Log.d(TAG, "Default");
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float temp = (float)progress/(float)seekBar.getMax();
                Log.d(TAG, "textSize: " + (temp * textSize));
                textView.setTextSize(temp * textSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
