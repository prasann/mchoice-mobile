package info.prasans.mchoice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import java.sql.SQLException;

import info.prasans.mchoice.R;
import info.prasans.mchoice.data.DatabaseHelper;
import info.prasans.mchoice.data.TestInfo;

import static info.prasans.mchoice.data.Constant.TEST_INFO_SERIALIZED;

public class EnterChoice extends OrmLiteBaseActivity<DatabaseHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_entry);

        String testInfoJson = getIntent().getExtras().getString(TEST_INFO_SERIALIZED);

        final TestInfo testInfo = new Gson().fromJson(testInfoJson, TestInfo.class);

        final LinearLayout choicesScreenLayout = (LinearLayout) findViewById(R.id.choicesScreen);

        assembleRadioButton(testInfo, choicesScreenLayout);

        Button submitBtn = (Button) findViewById(R.id.submit_choices);

        View.OnClickListener saveChoicesInfo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder answerBuilder = new StringBuilder();
                int count = choicesScreenLayout.getChildCount();
                for (int i = 0; i < count; i++) {
                    LinearLayout radioGroupLayout = (LinearLayout) choicesScreenLayout.getChildAt(i);
                    RadioGroup radioGroup = (RadioGroup) radioGroupLayout.findViewById(R.id.radio_grp);
                    RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                    if (radioButton != null) {
                        answerBuilder.append(String.valueOf(radioButton.getText()).trim());
                    }
                }
                testInfo.setAnswerString(answerBuilder.toString());
                createTestInfo(testInfo);
                Intent nextIntent = new Intent(EnterChoice.this, HomeActivity.class);
                EnterChoice.this.startActivity(nextIntent);

            }
        };

        submitBtn.setOnClickListener(saveChoicesInfo);
    }

    private void createTestInfo(TestInfo testInfo) {
        try {
            getHelper().getTestInfoDao().create(testInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void assembleRadioButton(TestInfo testInfo, LinearLayout choicesScreenLayout) {
        for (int i = 1; i <= testInfo.getCount(); i++) {
            LinearLayout radioLayout = (LinearLayout)
                    getLayoutInflater().inflate(R.layout.radio_group_layout, choicesScreenLayout, false);
            TextView questionNoView = (TextView) radioLayout.findViewById(R.id.q_no);
            questionNoView.setText(String.valueOf(i) + ".");
            choicesScreenLayout.addView(radioLayout);
        }
    }
}
