package algonquin.cst2335.li000848;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.Switch;
import android.view.animation.RotateAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.flagview);
        sw = findViewById(R.id.spin_switch);

        sw.setOnCheckedChangeListener((btn, isChecked) -> {
            if (isChecked)
            {
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                //The RotateAnimation( ) constructor says to rotate starting from 0 degrees to 360 degrees
                //around the middle of the flag ( 0.5 RELATIVE_TO_SELF)
                rotate.setDuration(5000);
                //The setDuration() says how long to complete a full circle (here 5000 milliseconds, or 5 seconds)
                rotate.setRepeatCount(Animation.INFINITE);
                //Can change it to 2 or 4 or whatever but the animation will stop when finished.
                rotate.setInterpolator(new LinearInterpolator());
                //The interpolator() just means that it's a constant spinning motion, not getting faster or slower (Linear)
                imgView.startAnimation(rotate);
            }
            else {
                imgView.clearAnimation();
            }
        });
    }



}