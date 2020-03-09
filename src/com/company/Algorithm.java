package com.company;

import java.util.ArrayList;

public abstract class Algorithm {

    private CPU cpu;

    public Algorithm(CPU cpu)
    {
        this.cpu = cpu;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public abstract void start();
}
