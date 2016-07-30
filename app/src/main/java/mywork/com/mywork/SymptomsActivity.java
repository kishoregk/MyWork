package mywork.com.mywork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;

public class  SymptomsActivity extends AppCompatActivity implements SymptomsCommunicationInterface {

    private HashMap<String,Integer> physicalSymptomsResults,cognitiveSymptomsResults,emotionalSymptomsResults,sleepSymptomsResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptoms_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selectItem(0);
    }


    // Performing Fragment transactions
    private void selectItem(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            case 0:// physical symptoms
                // Create a new fragment
                Fragment physicalfragment = new PhysicalSymptomsFragment();
                Bundle physicalargs = new Bundle();
                physicalfragment.setArguments(physicalargs);
                // Insert the fragment by replacing any existing fragment

                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, physicalfragment)
                        .commit();
                break;

            case 1:// Cognitive symptoms
                // Create a new fragment
                Fragment cognitiveFragment = new CognitiveSymptomsFragment();
                Bundle cognitiveArgs = new Bundle();
                cognitiveFragment.setArguments(cognitiveArgs);

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, cognitiveFragment)
                        .commit();
                break;

            case 2:// Emotional symptoms
                // Create a new fragment
                Fragment emotionalFragment = new EmotionalSymptomsFragment();
                Bundle emotionalArgs = new Bundle();
                emotionalFragment.setArguments(emotionalArgs);

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, emotionalFragment)
                        .commit();
                break;

            case 3:// sleep symptoms
                // Create a new fragment
                Fragment sleepFragment = new SleepSymptomsFragment();
                Bundle sleepArgs = new Bundle();
                sleepFragment.setArguments(sleepArgs);

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, sleepFragment)
                        .commit();
                break;

            case 4:// summary symptoms
                // Create a new fragment
                Fragment SymptomssummaryFragment = new SymptomsSummaryFragment();
                Bundle symptomsSummaryArgs = new Bundle();

                symptomsSummaryArgs.putInt("Physical",physicalSymptomsResults.get("TotalYes"));
                symptomsSummaryArgs.putInt("Cognitive",cognitiveSymptomsResults.get("TotalYes"));
                symptomsSummaryArgs.putInt("Emotional",emotionalSymptomsResults.get("TotalYes"));
                symptomsSummaryArgs.putInt("Sleep",sleepSymptomsResults.get("TotalYes"));

                SymptomssummaryFragment.setArguments(symptomsSummaryArgs);

                // Insert the fragment by replacing any existing fragment
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, SymptomssummaryFragment)
                        .commit();
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void physicalSymptomsFragmentData(HashMap<String, Integer> physicalSymptomsValues) {
//        for(String key: physicalSymptomsValues.keySet())
//        {
//            Log.w(key, "--" + physicalSymptomsValues.get(key));
//        }
        //call cognitive fragment
        physicalSymptomsResults =new HashMap<String,Integer>(physicalSymptomsValues);

        selectItem(1);
    }

    @Override
    public void CognitiveSymptomsFragmentData(HashMap<String, Integer> cognitiveSymptomsValues) {
//        for (String key : cognitiveSymptomsValues.keySet()) {
//            Log.w(key, "--" + cognitiveSymptomsValues.get(key));
//        }
        //call Emotional fragment
        cognitiveSymptomsResults =new HashMap<String,Integer>(cognitiveSymptomsValues);
        selectItem(2);

    }

    @Override
    public void emotionalSymptomsFragmentData(HashMap<String, Integer> emotionalSymptomsValues) {
//        for (String key : emotionalSymptomsValues.keySet()) {
//            Log.w(key, "--" + emotionalSymptomsValues.get(key));
//        }

        //call Sleep fragment
        emotionalSymptomsResults =new HashMap<String,Integer>(emotionalSymptomsValues);
        selectItem(3);

    }

    @Override
    public void SleepSymptomsFragmentData(HashMap<String, Integer> sleepSymptomsValues) {
//        for (String key : sleepSymptomsValues.keySet()) {
//            Log.w(key, "--" + sleepSymptomsValues.get(key));
//        }

        sleepSymptomsResults =new HashMap<String,Integer>(sleepSymptomsValues);
        selectItem(4);
    }
}
