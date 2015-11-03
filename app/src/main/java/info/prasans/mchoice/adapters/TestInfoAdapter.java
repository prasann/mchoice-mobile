package info.prasans.mchoice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import info.prasans.mchoice.R;
import info.prasans.mchoice.data.TestInfo;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class TestInfoAdapter extends ArrayAdapter<TestInfo>{

    private List<TestInfo> items;
    private Context myContext;


    public TestInfoAdapter(Context context, int resource, List<TestInfo> testInfos) {
        super(context, resource, testInfos);
        this.items = testInfos;
        this.myContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) myContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.test_info, null);
        }

        TestInfo testInfo = items.get(position);
        if (testInfo != null) {
            TextView testName = (TextView) view.findViewById(R.id.list_test_name);
            TextView testCode = (TextView) view.findViewById(R.id.list_test_code);
            if (testCode != null) {
                testCode.setText("Test-Code: " + testInfo.getCode());
            }
            if (testName != null) {
                testName.setText(testInfo.getName());
            }
        }
        return view;
    }
}
