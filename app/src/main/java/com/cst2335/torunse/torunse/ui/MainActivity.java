package com.cst2335.torunse.torunse.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.cst2335.torunse.torunse.data.MainViewModel;
import androidx.lifecycle.ViewModelProvider;
import algonquin.cst2335.li000848.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());


        model.editString.observe(this, s -> variableBinding.textview.setText("Your edit text has: " + s));

        variableBinding.button.setOnClickListener(click -> {
            String newText = variableBinding.myedittext.getText().toString();
            model.editString.postValue(newText);
        });


        variableBinding.checkBoxCoffee.setOnCheckedChangeListener((buttonView, isChecked) -> model.drinksCoffee.postValue(isChecked));
        variableBinding.switchCoffee.setOnCheckedChangeListener((buttonView, isChecked) -> model.drinksCoffee.postValue(isChecked));
        variableBinding.radioButtonCoffee.setOnCheckedChangeListener((buttonView, isChecked) -> model.drinksCoffee.postValue(isChecked));

        model.drinksCoffee.observe(this, isChecked -> {
            variableBinding.checkBoxCoffee.setChecked(isChecked);
            variableBinding.switchCoffee.setChecked(isChecked);
            variableBinding.radioButtonCoffee.setChecked(isChecked);

            Toast.makeText(this, "The value is now: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        variableBinding.myImage.setOnClickListener(v -> {
            Toast.makeText(this, "Image clicked.", Toast.LENGTH_SHORT).show();

            int width = variableBinding.buttonImage.getWidth();
            int height = variableBinding.buttonImage.getHeight();
            Toast.makeText(this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });

        variableBinding.buttonImage.setOnClickListener(v -> {
            Toast.makeText(this, "ImageButton clicked.", Toast.LENGTH_SHORT).show();

            int width = variableBinding.buttonImage.getWidth();
            int height = variableBinding.buttonImage.getHeight();
            Toast.makeText(this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });
    }
}