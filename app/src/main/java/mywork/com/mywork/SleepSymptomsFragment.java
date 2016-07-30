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
public class SleepSymptomsFragment extends Fragment {



    private RadioGroup radioGroup_drowsiness,radioGroup_sleep_less,radioGroup_sleep_more,radioGroup_sleep_trouble_sleeping;
    private HashMap<String,Integer> sleepSymptoms;
    SymptomsCommunicationInterface symptomsCommunicationInterface;
    public SleepSymptomsFragment() {
    }

    public static Fragment newInstance(Context context) {
        SleepSymptomsFragment f = new SleepSymptomsFragment();
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

        View rootView=inflater.inflate(R.layout.fragment_symptoms_sleep, container, false);



        radioGroup_drowsiness=(RadioGroup)rootView.findViewById(R.id.radioGrp_drowsiness);
        radioGroup_sleep_less=(RadioGroup)rootView.findViewById(R.id.radioGrp_sleep_less);
        radioGroup_sleep_more=(RadioGroup)rootView.findViewById(R.id.radioGrp_sleep_more);
        radioGroup_sleep_trouble_sleeping=(RadioGroup)rootView.findViewById(R.id.radioGrp_trouble_sleeping);


        sleepSymptoms=new HashMap<String,Integer>();

        //next Button Clicked
        Button nextSymptoms=(Button)rootView.findViewById(R.id.btn_next_symptoms);
        nextSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkIfAllSymptomsAreSelected())
                {
                    symptomsCommunicationInterface.SleepSymptomsFragmentData(sleepSymptoms);
                }
            }
        });

        return rootView;
    }
    private Boolean checkIfAllSymptomsAreSelected()
    {
        int totalYes=0,totalNo=0;

        //Drowsiness
        if (radioGroup_drowsiness.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity(), " Please Select All Options ", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_drowsiness.getCheckedRadioButtonId()==R.id.rdBtn_no_drowsiness)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            sleepSymptoms.put("Drowsiness",value);
        }

        //Sleep Less
        if (radioGroup_sleep_less.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_sleep_less.getCheckedRadioButtonId()==R.id.rdBtn_no_sleeping_lessthan_usual)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            sleepSymptoms.put("SleepLess",value);
        }


        //Sleep More
        if (radioGroup_sleep_more.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_sleep_more.getCheckedRadioButtonId()==R.id.rdBtn_no_sleeping_morethan_usual)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            sleepSymptoms.put("SleepMore",value);
        }


        //nervousness
        if (radioGroup_sleep_trouble_sleeping.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getActivity()," Please Select All Options ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            // one of the radio buttons is checked
            int value;
            if(radioGroup_sleep_trouble_sleeping.getCheckedRadioButtonId()==R.id.rdBtn_no_trouble_falling_asleep)
            {

                value=0;
                totalNo=totalNo+1;
            }
            else
            {

                value=1;
                totalYes=totalYes+1;
            }
            sleepSymptoms.put("TroubleSleeping",value);
        }



        sleepSymptoms.put("TotalYes",totalYes);
        sleepSymptoms.put("TotalNo",totalNo);
        sleepSymptoms.put("Total_Sleep",totalYes+totalNo);

        return true;
    }



}
