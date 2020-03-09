package com.company;

import java.util.Comparator;

public class SJF extends Algorithm {

    public SJF(CPU cpu)
    {
        super(cpu);
    }

    public void start()
    {
        boolean wasGenerated = false;
        sortByWorkTime();
        for(Process process : this.getCpu().getProcesses())
        {
            while(process.getWorkTime() > 0)
            {
                wasGenerated = this.getCpu().doCycle(process);
            }
            if(wasGenerated) break;
        }
        if(wasGenerated) start();
    }

    private void sortByWorkTime()
    {
        this.getCpu().getProcesses().sort(Comparator.comparingInt(Process::getWorkTime));
    }
}
