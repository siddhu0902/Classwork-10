package Classwork;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class EmptyNoteException extends Exception{
    public EmptyNoteException(String message){
        super(message);
    }
}

abstract class Logger{
    public abstract String format(String note);
}
class FileLogger extends Logger{
    @Override
    public String format(String note){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        String timeStamp = LocalDateTime.now().format(formatter);
        return"["+timeStamp+"] "+note;
    }
}
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = new FileLogger();
        try {
            System.out.println("Enter your note: ");
            String note = sc.nextLine();
            if(note.trim().isEmpty()){
                throw new EmptyNoteException("error: note cannot be empty.");
            }
            String formattedNote = logger.format(note);
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("logs.txt", true))){
                bw.write(formattedNote);
                bw.newLine();
            }
            System.out.println("Note saved to logs.txt: "+formattedNote);
        }catch (EmptyNoteException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println("Error writing to file.");
        }finally{
            sc.close();
        }
    }
}
