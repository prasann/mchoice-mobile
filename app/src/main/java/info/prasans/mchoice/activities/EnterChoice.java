package info.prasans.mchoice.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import info.prasans.mchoice.R;
import info.prasans.mchoice.data.TestInfo;

import static info.prasans.mchoice.data.Constant.TEST_INFO_SERIALIZED;

public class EnterChoice extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_entry);

        String testInfoJson = getIntent().getExtras().getString(TEST_INFO_SERIALIZED);

        TestInfo testInfo = new Gson().fromJson(testInfoJson, TestInfo.class);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.choicesScreen);

        for (int i = 1; i <= testInfo.getCount(); i++) {
            LinearLayout radioLayout = (LinearLayout)
                    getLayoutInflater().inflate(R.layout.radio_group_layout, linearLayout, false);
            TextView questionNoView = (TextView) radioLayout.findViewById(R.id.q_no);
            questionNoView.setText(String.valueOf(i) + ".");
            linearLayout.addView(radioLayout);
        }
    }

}
