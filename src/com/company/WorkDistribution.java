package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkDistribution {

    public void clientDistribution(int workHours){
        StartUpMenu startUpMenu = new StartUpMenu();
        AddingNewClient addingNewClient = new AddingNewClient();

        String workerAndProject = (startUpMenu.getWorkerNickname() + " : " + addingNewClient.getProjectName());

        HashMap<String,Integer> workDistributionHashMap = new HashMap<>();
        workDistributionHashMap.put(workerAndProject, workHours);

        List<HashMap> workDistributionList = new ArrayList<>();
        workDistributionList.add(workDistributionHashMap);

    }
}
