import java.util.*;

class Entry1 {
    String Process;
    int A_time;
    int B_time;
    int C_time;
    int T_time;
    int W_time;



}

public class SJF_Preemptive_Scheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of processes: ");
        n = sc.nextInt();
        Entry1[] processes = new Entry1[n];

        for (int i = 0; i < n; i++) {
            processes[i] = new Entry1();
            System.out.println("Enter the Process Name: ");
            processes[i].Process = sc.next();
            System.out.println("Enter the Arrival Time of Process " + processes[i].Process + ": ");
            processes[i].A_time = sc.nextInt();
            System.out.println("Enter the Burst Time of Process " + processes[i].Process + ": ");
            processes[i].B_time = sc.nextInt();
        }

        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;


        int[] remainingTime = new int[n];
        for (int i = 0; i < n; i++) {
            remainingTime[i] = processes[i].B_time;
        }

        int currentTime = 0;
        int completed = 0;

        while (completed != n) {
            int shortest = -1;
            int shortestBurst = 999;

            for (int i = 0; i < n; i++) {
                if (processes[i].A_time <= currentTime && remainingTime[i] < shortestBurst && remainingTime[i] > 0) {
                    shortest = i;
                    shortestBurst = remainingTime[i];
                }
            }

            if (shortest == -1) {
                currentTime++;
            } else {
                remainingTime[shortest]--;
                currentTime++;
                if (remainingTime[shortest] == 0) {
                    completed++;
                    processes[shortest].C_time = currentTime;
                    processes[shortest].T_time = processes[shortest].C_time - processes[shortest].A_time;
                    processes[shortest].W_time = processes[shortest].T_time - processes[shortest].B_time;

                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            totalTurnaroundTime += processes[i].T_time;
            totalWaitingTime += processes[i].W_time;
        }

        System.out.println(" ");
        System.out.println("PID\t\tArrival Time\tBurst Time\tCompletion Time\t\tTurnaround Time\t\tWaiting Time");

        for (int i = 0; i < n; i++) {
            System.out.println(processes[i].Process + "\t\t" + processes[i].A_time + "\t\t" + processes[i].B_time + "\t\t" + processes[i].C_time + "\t\t\t" + processes[i].T_time + "\t\t\t" + processes[i].W_time);
        }

        double avgTurnaroundTime = (double) totalTurnaroundTime / n;
        double avgWaitingTime = (double) totalWaitingTime / n;

        System.out.println("\nAverage Turnaround Time: " + avgTurnaroundTime+" ms");
        System.out.println("Average Waiting Time: " + avgWaitingTime+ " ms");
    }
}

/*
 Enter the number of processes:
4
Enter the Process Name:
1
Enter the Arrival Time of Process 1:
0
Enter the Burst Time of Process 1:
5
Enter the Process Name:
2
Enter the Arrival Time of Process 2:
1
Enter the Burst Time of Process 2:
3
Enter the Process Name:
3
Enter the Arrival Time of Process 3:
2
Enter the Burst Time of Process 3:
4
Enter the Process Name:
4
Enter the Arrival Time of Process 4:
4
Enter the Burst Time of Process 4:
1
 */