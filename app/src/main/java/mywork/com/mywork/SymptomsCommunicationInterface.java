package mywork.com.mywork;

import java.util.HashMap;

/**
 * Created by admin on 11/4/15.
 */
public interface SymptomsCommunicationInterface {

    public void physicalSymptomsFragmentData(HashMap<String,Integer> physicalSymptomsValues);

    public void CognitiveSymptomsFragmentData(HashMap<String,Integer> cognitiveSymptomsValues);

    public void emotionalSymptomsFragmentData(HashMap<String, Integer> emotionalSymptomsValues);

    void SleepSymptomsFragmentData(HashMap<String, Integer> sleepSymptomsValues);
}
