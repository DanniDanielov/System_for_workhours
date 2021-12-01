package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkDistribution {
    public String workerName;
    public String projectName;
    public int workHours;


    public void clientDistribution(int workHours) throws IOException {
        StartUpMenu startUpMenu = new StartUpMenu();
        AddingNewClient addingNewClient = new AddingNewClient();

        this.workerName = startUpMenu.getWorkerNickname();
        this.projectName = addingNewClient.getProjectName();
        this.workHours = workHours;
        String workerAndProject = (this.workerName + " : "+ this.projectName);

        HashMap<String,Integer> workDistributionHashMap = new HashMap<>();
        workDistributionHashMap.put(workerAndProject, this.workHours);

        List<HashMap> workDistributionList = new ArrayList<>();
        workDistributionList.add(workDistributionHashMap);
        Gson gson = new GsonBuilder().create();
        JsonArray jsonArray = gson.toJsonTree(workDistributionList).getAsJsonArray();
        FileWriter file = new FileWriter("WorkerFile.json");
        file.write(String.valueOf(jsonArray));
        file.flush();

    }
}
