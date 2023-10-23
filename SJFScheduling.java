import java.util.*;

public class SJFScheduling {

    public static double shortestJobFirst(List<Process> processes) {
        BSTPriorityQueue priorityQueue = new BSTPriorityQueue();
        int totalWaitingTime = 0;
        int currentTime = 0;

        for (Process process : processes) {
            priorityQueue.insert(process);
        }

        while (priorityQueue.root != null) {
            Process shortestProcess = priorityQueue.getProcessWithShortestExecutionTime();
            int waitingTime = Math.max(currentTime, shortestProcess.executionTime);
            totalWaitingTime += waitingTime;

            currentTime += shortestProcess.executionTime;
            priorityQueue.remove(shortestProcess);

            System.out.println("Process " + shortestProcess.name + " completed.");
        }

        return (double) totalWaitingTime / processes.size();
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, "Process A", 6));
        processes.add(new Process(2, "Process B", 8));
        processes.add(new Process(3, "Process C", 7));
        processes.add(new Process(4, "Process D", 3));

        double averageWaitingTime = shortestJobFirst(processes);
        System.out.println("Average Waiting Time: " + averageWaitingTime);
    }
}
