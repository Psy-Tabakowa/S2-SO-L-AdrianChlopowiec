package com.company;

import java.util.ArrayList;

public class SJFW extends Algorithm {

    public SJFW(CPU cpu)
    {
        super(cpu);
    }

    public void start()
    {
        while(anyProcessHasWorkTime())
        {
           Process shortest = selectProcess();
           this.getCpu().doCycle(shortest);
        }
    }

    private boolean anyProcessHasWorkTime()
    {
        for(Process process : this.getCpu().getProcesses())
            if(!process.isDone())
                return true;
        return false;
    }

    private Process selectProcess()
    {
        int minWorkTime = Integer.MAX_VALUE;

        for(Process process : this.getCpu().getProcesses())
        {
            if(process.getWorkTime() < minWorkTime && !process.isDone())
                minWorkTime = process.getWorkTime();
        }

        for(Process process : this.getCpu().getProcesses())
        {
            if(process.getWorkTime() == minWorkTime) return process;
        }

        return null;
    }
}
