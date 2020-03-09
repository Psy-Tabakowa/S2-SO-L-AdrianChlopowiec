package com.company;

public class Process {
    private int id;
    private int workTime;
    private int waitTime;
    private int startTime;

    public Process(int id, int workTime, int startTime)
    {
        this.id = id;
        this.workTime = workTime;
        this.waitTime = 0;
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void decrementWorkTime()
    {
        this.workTime--;
    }

    public void incrementWaitTime()
    {
        this.waitTime++;
    }

    public Process clone()
    {
        return new Process(this.id, this.workTime, this.startTime);
    }

    public boolean isDone()
    {
        return workTime <= 0;
    }

    public String toString()
    {
        return "Process: " + this.getId() + " workTime: " + this.getWorkTime() + " startTime: " + this.getStartTime();
    }
}
