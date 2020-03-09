package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CPU {
    ArrayList<Process> processes;
    Algorithm algorithm;
    int globalTime;

    public CPU(ArrayList<Process> processes)
    {
        cloneProcesses(processes);
        this.algorithm = new FCFS(this);
        globalTime = 0;
    }

    public ArrayList<Process> getProcesses()
    {
        return this.processes;
    }

    public void start()
    {
        algorithm.start();
    }

    //returns true if additional processes were generated
    public boolean doCycle(Process process)
    {
        boolean wasGenerated = false;
        process.decrementWorkTime();
        processes.forEach(p ->
        {
            if(!p.equals(process) && !p.isDone() && p.getStartTime() <= globalTime)
                p.incrementWaitTime();
        });
        globalTime++;
        Random random = new Random();
        if(random.nextInt(10) % 5 == 0)
        {
            ArrayList<Process> newProcesses = (ArrayList<Process>) processes.clone();
            newProcesses.addAll(Generator.generateAdditionalProcesses(2, 1, 10, 200));
            processes = newProcesses;
            wasGenerated = true;
        }
        return wasGenerated;
    }

    public void setFCFSAlgorithm()
    {
        this.algorithm = new FCFS(this);
    }

    public void setSJFAlgorithm()
    {
        this.algorithm = new SJF(this);
    }

    public void setSJFWAlgorithm()
    {
        this.algorithm = new SJFW(this);
    }

    public void setROTAlgorithm(int timeUnit)
    {
        this.algorithm = new ROT(this, timeUnit);
    }

    public void restart(ArrayList<Process> processes)
    {
        cloneProcesses(processes);
        this.algorithm = new FCFS(this);
    }

    private void cloneProcesses(ArrayList<Process> processes)
    {
        ArrayList<Process> newProcesses = new ArrayList<>();
        for(Process process : processes)
        {
            newProcesses.add(process.clone());
        }
        this.processes = newProcesses;
    }

    public double getAverageWaitTime()
    {
        int waitTime = 0;
        for(Process process : processes)
            waitTime += process.getWaitTime();
        return waitTime / (double) processes.size();
    }
}
