package com.company;

import java.util.ArrayList;

public class ROT extends Algorithm {

    private int timeUnit;

    public ROT(CPU cpu, int timeUnit)
    {
        super(cpu);
        this.timeUnit = timeUnit;
    }

    public void start()
    {
        boolean wasGenerated = false;
        while(!allProcessesDone())
        {
            for(Process process : this.getCpu().getProcesses())
            {
                if(!process.isDone())
                    for(int i = 0; i < timeUnit; i++)
                    {
                        wasGenerated = this.getCpu().doCycle(process);
                    }
                if(wasGenerated) break;
            }
            if(wasGenerated) break;
        }

        if(wasGenerated) start();
    }

    private boolean allProcessesDone()
    {
        for(Process process : this.getCpu().getProcesses())
            if(!process.isDone())
                return false;
        return true;
    }
}
