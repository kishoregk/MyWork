package mywork.com.mywork;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by admin on 11/4/15.
 */
public class SymptomsSummaryFragment extends Fragment {

    private TextView txt_physical,txt_cognitive,txt_sleep,txt_emotional;
    private int total_physical,total_cognitive,total_emotional,total_sleep;

    public SymptomsSummaryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=this.getArguments();
        if (bundle != null) {
            total_physical = bundle.getInt("Physical", 0);
            total_cognitive = bundle.getInt("Cognitive", 0);
            total_emotional = bundle.getInt("Emotional", 0);
            total_sleep = bundle.getInt("Sleep", 0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_symptoms_summary, container, false);

        txt_physical=(TextView)rootView.findViewById(R.id.summary_physical);
        txt_cognitive=(TextView)rootView.findViewById(R.id.summary_cognitive);
        txt_sleep=(TextView)rootView.findViewById(R.id.summary_sleep);
        txt_emotional=(TextView)rootView.findViewById(R.id.summary_emotional);

        txt_physical.setText(" "+ total_physical);
        txt_cognitive.setText(" "+ total_cognitive);
        txt_emotional.setText(" "+ total_emotional);
        txt_sleep.setText(" "+ total_sleep);

        return rootView;
    }
}
