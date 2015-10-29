package info.prasans.mchoice.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;

import info.prasans.mchoice.R;

public class CreateTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_test);

        NumberPicker wrongScore = (NumberPicker) findViewById(R.id.wrongScore);
        wrongScore.setMinValue(0);
        wrongScore.setMaxValue(10);

        NumberPicker correctScore = (NumberPicker) findViewById(R.id.correctScore);
        correctScore.setMinValue(0);
        correctScore.setMaxValue(10);
    }
}
