package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Generator generator = new Generator(50, 50, 100, 200);
        ArrayList<Process> processes = generator.generate();
        CPU cpu = new CPU(processes);
        cpu.setFCFSAlgorithm();
        cpu.start();
        double averageWaitTime = cpu.getAverageWaitTime();
        System.out.println("Dla algorytmu FCFS średni czas oczekiwania wyniósł: " + averageWaitTime);

        cpu.restart(processes);
        cpu.setSJFAlgorithm();
        cpu.start();
        averageWaitTime = cpu.getAverageWaitTime();

        System.out.println("Dla algorytmu SJF średni czas oczekiwania wyniósł: " + averageWaitTime);
        cpu.restart(processes);
        cpu.setSJFWAlgorithm();
        cpu.start();
        averageWaitTime = cpu.getAverageWaitTime();

        System.out.println("Dla algorytmu SJF z wywłaszczeniem średni czas oczekiwania wyniósł: " + averageWaitTime);
        cpu.restart(processes);
        cpu.setROTAlgorithm(2);
        cpu.start();
        averageWaitTime = cpu.getAverageWaitTime();

        System.out.println("Dla algorytmu rotacyjnego średni czas oczekiwania wyniósł: " + averageWaitTime);

        System.out.println();
        System.out.println();
        String s = "";
        for(Process process : processes)
            s += process + "\n";
        System.out.println(s);
    }
}

