package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkDistribution {
    public String workerName;
    public String projectName;
    public int workhours;

    public void clientDistribution(int workHours){
        StartUpMenu startUpMenu = new StartUpMenu();
        AddingNewClient addingNewClient = new AddingNewClient();

        this.workerName = startUpMenu.getWorkerNickname();
        this.projectName = addingNewClient.getProjectName();
        this.workhours = workHours;
        String workerAndProject = (this.workerName + " : "+ this.projectName);

        HashMap<String,Integer> workDistributionHashMap = new HashMap<>();
        workDistributionHashMap.put(workerAndProject, this.workhours);

        List<HashMap> workDistributionList = new ArrayList<>();
        workDistributionList.add(workDistributionHashMap);

    }
}
