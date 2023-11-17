import java.util.Arrays;
import java.util.Scanner; 
//Implementation of first fit algorithm
class First_fit { 
public void firstFit(int blockSize[], int m, int processSize[], int n)
{ 
 int allocation[] = new int[n]; 
 for (int i = 0; i < allocation.length; i++) 
 allocation[i] = -1; 
 for (int i = 0; i < n; i++) 
 { 
 for (int j = 0; j < m; j++) 
 { 
 if (blockSize[j] >= processSize[i]) 
 { 
 allocation[i] = j; 
 blockSize[j] -= processSize[i];
 break; 
 } 
 } 
 
}
 System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
 for (int i = 0; i < n; i++) 
 { 
 System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t"); if 
(allocation[i] != -1) 
 System.out.print(allocation[i] + 1); 
 else 
 System.out.print("Not Allocated"); 
 System.out.println(); 
 } 
 } 
}
//Implementation of next-fit algorithm
class Next_fit
{
 public void NextFit(int blockSize[], int m, int processSize[], int n) 
 { 
 int allocation[] = new int[n], j = 0; 
 Arrays.fill(allocation, -1); 
 for (int i = 0; i < n; i++) 
 { 
 int count =0; 
 while (j < m) 
 { 
 count++; 
 if (blockSize[j] >= processSize[i]) 
 { 
 allocation[i] = j; 
 blockSize[j] -= processSize[i]; 
 break; 
 }
 j = (j + 1) % m; 
 
 } 
 
 }
 System.out.print("\nProcess No.\tProcess Size\tBlock no.\n"); 
 for (int i = 0; i < n; i++) 
 { 
 System.out.print( i + 1 + "\t\t" + processSize[i]+ "\t\t");
 if (allocation[i] != -1) 
 { 
 System.out.print(allocation[i] + 1); 
 } 
 else 
 { 
 System.out.print("Not Allocated"); 
 } 
 System.out.println(""); 
 } 
 }
}
//implementation of best fit algorithm
class Best_fit
{
 void bestFit(int blockSize[], int m, int processSize[], int n)
 { 
 int allocation[] = new int[n];
 for (int i = 0; i < allocation.length; i++) 
 allocation[i] = -1; 
 for (int i=0; i<n; i++) 
 {
 int bestIdx = -1; 
 for (int j=0; j<m; j++) 
 { 
 if (blockSize[j] >= processSize[i]) 
 { 
 if (bestIdx == -1) 
 bestIdx = j; 
 else if (blockSize[bestIdx] > blockSize[j]) bestIdx = 
j; 
 
 } 
 
 } 
 if (bestIdx != -1) 
 { 
 allocation[i] = bestIdx; 
 blockSize[bestIdx] -= processSize[i]; 
 } 
 }
 System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
 for (int i = 0; i < n; i++) 
 { 
 System.out.print(" " + (i+1) + "\t\t" + processSize[i]+ "\t\t");
 if (allocation[i] != -1) 
 System.out.print(allocation[i] + 1); 
 else 
 System.out.print("Not Allocated"); 
 System.out.println(); 
 } 
 } 
 
}
//implementation of worst fit algorithm
class Worst_fit
{
 void worstFit(int blockSize[], int m, int processSize[], int n) 
 { 
 int allocation[] = new int[n]; 
 for (int i = 0; i < allocation.length; i++) 
 allocation[i] = -1;
 for (int i=0; i<n; i++) 
 { 
 int wstIdx = -1;
 for (int j=0; j<m; j++) 
 { 
 if (blockSize[j] >= processSize[i]) 
 { 
 if (wstIdx == -1) 
 wstIdx = j; 
 else if (blockSize[wstIdx] < blockSize[j]) 
 wstIdx = j; 
 
 } 
 }
 if (wstIdx != -1) 
 { 
 allocation[i] = wstIdx;
 blockSize[wstIdx] -= processSize[i]; 
 } 
 } 
 System.out.println("\nProcess No.\tProcess Size\tBlock no.");
 for (int i = 0; i < n; i++) 
 { 
 System.out.print(" " + (i+1) + "\t\t" + processSize[i]+ 
"\t\t"); 
 if (allocation[i] != -1) 
 System.out.print(allocation[i] + 1); 
 else 
 System.out.print("Not Allocated"); 
 System.out.println(); 
 } 
 } 
 
}
public class Main 
{ 
 public static void main(String[] args) 
 { 
 First_fit first = new First_fit(); 
 Next_fit next = new Next_fit(); 
 Worst_fit worst = new Worst_fit(); 
 Best_fit best = new Best_fit(); 
 Scanner scan = new Scanner(System.in);
 while(true) 
 { 
 int choice; 
 System.out.println();
 System.out.println("Enter the number of Blocks: "); 
 int m = scan.nextInt(); 
 System.out.println("Enter the number of Processes: "); 
 int n = scan.nextInt(); 
 int blockSize[] = new int[m]; 
 int processSize[] = new int[n]; 
 System.out.println("Enter the Size of all the blocks: ");
 for (int i = 0; i<m; i++) 
 { 
 blockSize[i] = scan.nextInt(); 
 
 } 
 System.out.println("Enter the size of all processes: "); 
 for (int i = 0; i<n; i++) 
 { 
 processSize[i] = scan.nextInt(); 
 
 }
 System.out.println(); 
 System.out.println("Menu");
 System.out.println("1. First Fit "); 
 System.out.println("2. Next Fit"); 
 System.out.println("3. Worst Fit"); 
 System.out.println("4. Best Fit"); 
 System.out.println("5. exit");
 System.out.println("Select the algorithm you want to implement: "); 
 choice = scan.nextInt();
 switch(choice) 
 { 
 case 1: 
 System.out.println("First Fit Output"); 
 first.firstFit(blockSize, m, processSize, n); 
 break; 
 case 2: 
 System.out.println("Next Fit Output");
 next.NextFit(blockSize, m, processSize, n); 
 break; 
 case 3: 
 System.out.println("Worst Fit Output"); 
 worst.worstFit(blockSize, m, processSize, n); 
 break; 
 case 4: 
 System.out.println("Best Fit Output"); 
 best.bestFit(blockSize, m, processSize, n);
 break; 
 case 5: 
 System.out.println("Exiting the code..."); 
 return; 
 default: 
 System.out.println("Invalid option"); 
 } 
 } 
 }
}



