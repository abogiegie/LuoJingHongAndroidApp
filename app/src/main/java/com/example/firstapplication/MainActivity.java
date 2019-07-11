package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;
    private Switch switchPart;
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
        constraintLayout = findViewById(R.id.background);

        //button
        final ColorStateList buttonTextColor = button.getTextColors();
        //textView
        final ColorStateList textViewColor = textView.getTextColors();
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
                if(!(temp == res.getString(R.string.edit_blank) || temp == "")){
                    textView.setText(temp);
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
                }
            }
        });
    }
}
