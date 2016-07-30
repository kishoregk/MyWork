package mywork.com.mywork;

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

/**
 * A placeholder fragment containing a simple view.
 */
public class PhysicalSymptomsFragment extends Fragment {


    private  RadioGroup radioGroup_headache,radioGroup_nausea,radioGroup_vomiting,radioGroup_visualProblem,radioGroup_numbness;
    private HashMap<String,Integer> physicalSymptoms;
    SymptomsCommunicationInterface symptomsCommunicationInterface;
    public PhysicalSymptomsFragment() {
    }

    public static Fragment newInstance(Context context) {
        PhysicalSymptomsFragment f = new PhysicalSymptomsFragment();
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

        View rootView=inflater.inflate(R.layout.fragment_symptoms_physical, container, false);



        radioGroup_headache=(RadioGroup)rootView.findViewById(R.id.radioGrp_headache);
        radioGroup_nausea=(RadioGroup)rootView.findViewById(R.id.radioGrp_nausea);
        radioGroup_vomiting=(RadioGroup)rootView.findViewById(R.id.radioGrp_vomiting);
        radioGroup_visualProblem=(RadioGroup)rootView.findViewById(R.id.radioGrp_visualProblem);
        radioGroup_numbness=(RadioGroup)rootView.findViewById(R.id.radioGrp_numbness);

        physicalSymptoms=new HashMap<String,Integer>();

        //next Button Clicked
        Button nextSymptoms=(Button)rootView.findViewById(R.id.btn_next_symptoms);
        nextSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkIfAllSymptomsAreSelected())
                {
                    symptomsCommunicationInterface.physicalSymptomsFragmentData(physicalSymptoms);
                }
            }
        });

        return rootView;
    }
    private Boolean checkIfAllSymptomsAreSelected()
    {
        int totalYes=0,totalNo=0;

        //headache
        if (radioGroup_headache.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_headache.getCheckedRadioButtonId()==R.id.rdBtn_no_headache)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            physicalSymptoms.put("Headache",value);
        }

        //nausea
        if (radioGroup_nausea.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_nausea.getCheckedRadioButtonId()==R.id.rdBtn_no_nausea)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            physicalSymptoms.put("Nausea",value);
        }


        //vomiting
        if (radioGroup_vomiting.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_vomiting.getCheckedRadioButtonId()==R.id.rdBtn_no_vomiting)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            physicalSymptoms.put("Vomiting",value);
        }


        //visual Problem
        if (radioGroup_visualProblem.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_visualProblem.getCheckedRadioButtonId()==R.id.rdBtn_no_visualProblem)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            physicalSymptoms.put("VisualProblem",value);
        }


        //numbness
        if (radioGroup_numbness.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_numbness.getCheckedRadioButtonId()==R.id.rdBtn_no_numbness)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            physicalSymptoms.put("Numbness",value);
        }

        physicalSymptoms.put("TotalYes",totalYes);
        physicalSymptoms.put("TotalNo",totalNo);
        physicalSymptoms.put("Total_Physical",totalYes+totalNo);

        return true;
    }



}
