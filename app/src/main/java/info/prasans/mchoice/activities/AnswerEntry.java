package info.prasans.mchoice.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import info.prasans.mchoice.R;
import info.prasans.mchoice.data.TestInfo;

import static info.prasans.mchoice.data.Constant.TEST_INFO_SERIALIZED;

public class AnswerEntry extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_entry);

        String testInfoJson = getIntent().getExtras().getString(TEST_INFO_SERIALIZED);

        TestInfo testInfo = new Gson().fromJson(testInfoJson, TestInfo.class);

        TextView testNameLabel = (TextView) findViewById(R.id.testNameLabel);
        testNameLabel.setText(testInfoJson);
    }
}
