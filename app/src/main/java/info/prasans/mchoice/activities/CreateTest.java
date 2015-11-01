package info.prasans.mchoice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.google.gson.Gson;

import info.prasans.mchoice.R;
import info.prasans.mchoice.data.TestInfo;

import static info.prasans.mchoice.data.Constant.*;

public class CreateTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_test);

        setNegativeScorePicker();
        setPositiveScorePicker();

        submit();
    }

    private void setPositiveScorePicker() {
        NumberPicker correctScore = (NumberPicker) findViewById(R.id.correctScore);
        correctScore.setMinValue(0);
        correctScore.setMaxValue(10);
    }

    private void setNegativeScorePicker() {
        NumberPicker wrongScore = (NumberPicker) findViewById(R.id.wrongScore);
        wrongScore.setMinValue(0);
        wrongScore.setMaxValue(NEGATIVE_MAX - NEGATIVE_MIN);
        wrongScore.setValue(NEGATIVE_MAX - NEGATIVE_MIN);

        wrongScore.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return Integer.toString(value + NEGATIVE_MIN);
            }
        });
    }

    private void submit() {
        Button submitBtn = (Button) findViewById(R.id.done);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestInfo testInfo = new TestInfo(getStringVal(R.id.testName),
                        getStringVal(R.id.testCode), getIntVal(R.id.testCount));
                testInfo.setWrongScore(getNegativeScoreVal());
                testInfo.setCorrectScore(((NumberPicker) findViewById(R.id.correctScore)).getValue());
                String serializedTestInfo = new Gson().toJson(testInfo);

                Intent nextIntent = new Intent(CreateTest.this, EnterChoice.class);
                nextIntent.putExtra(TEST_INFO_SERIALIZED, serializedTestInfo);
                CreateTest.this.startActivity(nextIntent);
            }
        });
    }

    private int getNegativeScoreVal() {
        int valFromPicker = ((NumberPicker) findViewById(R.id.wrongScore)).getValue();
        return valFromPicker + NEGATIVE_MIN;
    }

    private String getStringVal(int id) {
        return ((EditText) findViewById(id)).getText().toString();
    }

    private int getIntVal(int id) {
        return Integer.valueOf(getStringVal(id));
    }

}
