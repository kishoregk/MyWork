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
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by admin on 11/4/15.
 */
public class EmotionalSymptomsFragment extends Fragment {



    private RadioGroup radioGroup_irritability,radioGroup_sadness,radioGroup_more_emotional,radioGroup_nervousness;
    private HashMap<String,Integer> emotionalSymptoms;
    SymptomsCommunicationInterface symptomsCommunicationInterface;
    public EmotionalSymptomsFragment() {
    }

    public static Fragment newInstance(Context context) {
        EmotionalSymptomsFragment f = new EmotionalSymptomsFragment();
        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SymptomsCommunicationInterface) {
            symptomsCommunicationInterface = (SymptomsCommunicationInterface) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_symptoms_emotional, container, false);



        radioGroup_irritability=(RadioGroup)rootView.findViewById(R.id.radioGrp_irritability);
        radioGroup_sadness=(RadioGroup)rootView.findViewById(R.id.radioGrp_sadness);
        radioGroup_more_emotional=(RadioGroup)rootView.findViewById(R.id.radioGrp_more_emotional);
        radioGroup_nervousness=(RadioGroup)rootView.findViewById(R.id.radioGrp_nervousness);


        emotionalSymptoms=new HashMap<String,Integer>();

        //next Button Clicked
        Button nextSymptoms=(Button)rootView.findViewById(R.id.btn_next_symptoms);
        nextSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkIfAllSymptomsAreSelected())
                {
                    symptomsCommunicationInterface.emotionalSymptomsFragmentData(emotionalSymptoms);
                }
            }
        });

        return rootView;
    }
    private Boolean checkIfAllSymptomsAreSelected()
    {
        int totalYes=0,totalNo=0;

        //irritability
        if (radioGroup_irritability.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity(), " Please Select All Options ", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_irritability.getCheckedRadioButtonId()==R.id.rdBtn_no_irritability)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            emotionalSymptoms.put("Irritability",value);
        }

        //sadness
        if (radioGroup_sadness.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_sadness.getCheckedRadioButtonId()==R.id.rdBtn_no_sadness)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            emotionalSymptoms.put("Sadness",value);
        }


        //More Emotional
        if (radioGroup_more_emotional.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_more_emotional.getCheckedRadioButtonId()==R.id.rdBtn_no_more_emotional)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            emotionalSymptoms.put("MoreEmotional",value);
        }


        //nervousness
        if (radioGroup_nervousness.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_nervousness.getCheckedRadioButtonId()==R.id.rdBtn_no_nervousness)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            emotionalSymptoms.put("Nervousness",value);
        }



        emotionalSymptoms.put("TotalYes",totalYes);
        emotionalSymptoms.put("TotalNo",totalNo);
        emotionalSymptoms.put("Total_Emotional",totalYes+totalNo);

        return true;
    }



}
