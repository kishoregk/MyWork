package mywork.com.mywork;

/**
 * Created by admin on 11/4/15.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;


public class CognitiveSymptomsFragment extends Fragment {


    private  RadioGroup radioGroup_feeling_mentally_foggy,radioGroup_feeling_slowed_down,radioGroup_difficulty_concentrating,radioGroup_difficulty_remembering;
    private HashMap<String,Integer> cognitiveSymptoms;
    SymptomsCommunicationInterface symptomsCommunicationInterface;
    public CognitiveSymptomsFragment() {
    }

    public static Fragment newInstance(Context context) {
        CognitiveSymptomsFragment f = new CognitiveSymptomsFragment();
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

        View rootView=inflater.inflate(R.layout.fragment_symptoms_cognitive, container, false);



        radioGroup_feeling_mentally_foggy=(RadioGroup)rootView.findViewById(R.id.radioGrp_feeling_foggy);
        radioGroup_feeling_slowed_down=(RadioGroup)rootView.findViewById(R.id.radioGrp_feeling_slowed_down);
        radioGroup_difficulty_concentrating=(RadioGroup)rootView.findViewById(R.id.radioGrp_difficulty_concentrating);
        radioGroup_difficulty_remembering=(RadioGroup)rootView.findViewById(R.id.radioGrp_difficulty_remembering);


        cognitiveSymptoms=new HashMap<String,Integer>();

        //next Button Clicked
        Button nextSymptoms=(Button)rootView.findViewById(R.id.btn_next_symptoms);
        nextSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkIfAllSymptomsAreSelected())
                {
                    symptomsCommunicationInterface.CognitiveSymptomsFragmentData(cognitiveSymptoms);
                }
            }
        });

        return rootView;
    }
    private Boolean checkIfAllSymptomsAreSelected()
    {
        int totalYes=0,totalNo=0;

        //headache
        if (radioGroup_feeling_mentally_foggy.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_feeling_mentally_foggy.getCheckedRadioButtonId()==R.id.rdBtn_no_foggy)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            cognitiveSymptoms.put("FeelingFoggy",value);
        }

        //nausea
        if (radioGroup_feeling_slowed_down.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_feeling_slowed_down.getCheckedRadioButtonId()==R.id.rdBtn_no_slowed)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            cognitiveSymptoms.put("FeelingSlowedDown",value);
        }


        //difficulty concentrating
        if (radioGroup_difficulty_concentrating.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_difficulty_concentrating.getCheckedRadioButtonId()==R.id.rdBtn_no_difficulty_concentrating)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            cognitiveSymptoms.put("DifficultyConcentrating",value);
        }


        //difficulty remembering
        if (radioGroup_difficulty_remembering.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_difficulty_remembering.getCheckedRadioButtonId()==R.id.rdBtn_no_difficulty_remembering)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            cognitiveSymptoms.put("DifficultyRemembering",value);
        }



        cognitiveSymptoms.put("TotalYes",totalYes);
        cognitiveSymptoms.put("TotalNo",totalNo);
        cognitiveSymptoms.put("Total_Cognitive",totalYes+totalNo);

        return true;
    }



}
