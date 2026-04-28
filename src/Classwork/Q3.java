package Classwork;
import java.io.*;
import java.util.*;

public class Q3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try(FileWriter fw = new FileWriter("donations.txt",true);
        BufferedWriter bw = new BufferedWriter(fw)){
            System.out.println("Enter book titles( type 'exit' to stop): ");
            while(true){
                String title = sc.nextLine();
                if(title.equalsIgnoreCase("exit")){
                    break;
                }
                bw.write(title);
                bw.newLine();
            }
            System.out.println("Successfully logged. \n");
        }
        catch (IOException e){
            System.out.println("Error writing to file.");
        }
        System.out.println("Current Donation List: ");
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("donations.txt"))){
            String line;

            while ((line = br.readLine()) != null){
                count++;
                System.out.println(count+ " . "+ line);
            }
            System.out.println("\nTotal Books: "+count);
        }
        catch (IOException e){
            System.out.println("Error reading file. ");
        }
        sc.close();
    }
}
