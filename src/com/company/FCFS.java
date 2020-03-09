package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class FCFS extends Algorithm {

    public FCFS(CPU cpu)
    {
        super(cpu);
    }

    public void start()
    {
        for(Process process : this.getCpu().getProcesses())
        {
            while(process.getWorkTime() > 0)
                this.getCpu().doCycle(process);
        }
    }
}
