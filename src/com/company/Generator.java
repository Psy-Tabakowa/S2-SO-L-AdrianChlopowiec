package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Generator {

    private int maxProcessWorkTime;
    private int maxNumberOfProcesses;
    private int minNumberOfProcesses;
    private int maxStartTime;

    public Generator(int maxProcessWorkTime, int minNumberOfProcesses, int maxNumberOfProcesses, int maxStartTime) throws IllegalArgumentException
    {
        if(minNumberOfProcesses > maxNumberOfProcesses) throw new IllegalArgumentException();
        this.maxProcessWorkTime = maxProcessWorkTime;
        this.minNumberOfProcesses = minNumberOfProcesses;
        this.maxNumberOfProcesses = maxNumberOfProcesses;
        this.maxStartTime = maxStartTime;
    }

    public ArrayList<Process> generate()
    {
        ArrayList<Process> processes = new ArrayList<>();
        Random random = new Random();
        int numOfProcesses = random.nextInt(maxNumberOfProcesses - minNumberOfProcesses) + minNumberOfProcesses;
        for(int i = 0; i < numOfProcesses; i++)
        {
            int workTime = random.nextInt(maxProcessWorkTime);
            int startTime = random.nextInt(maxStartTime);
            Process process = new Process(i, workTime, startTime);
            processes.add(process);
        }
        processes.sort(Comparator.comparingInt(Process::getStartTime));
        return processes;
    }

    public static ArrayList<Process> generateAdditionalProcesses(int maxNumberOfProcesses, int minNumberOfProcesses, int maxProcessWorkTime, int maxStartTime)
    {
        ArrayList<Process> processes = new ArrayList<>();
        Random random = new Random();
        int numOfProcesses = random.nextInt(maxNumberOfProcesses - minNumberOfProcesses) + minNumberOfProcesses;
        for(int i = 0; i < numOfProcesses; i++)
        {
            int workTime = random.nextInt(maxProcessWorkTime);
            int startTime = random.nextInt(maxStartTime);
            Process process = new Process(i, workTime, startTime);
            processes.add(process);
        }
        return processes;
    }
}
