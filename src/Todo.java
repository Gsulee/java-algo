import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Todo {

    String first;
    String last;

    Todo(String first, String last) {
        this.first = first;
        this.last = last;
    }
    void options() {
        IO.println("1. Add task");
        IO.println("2. List tasks");
        IO.println("3. Delete all tasks");
        IO.println("4. Exit");
    }
    void addTask(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> addTodo = new ArrayList<>();

        String filePath = "text.txt";
        String task;
        int amount;

        IO.print("Enter # of task  to add: ");
        amount = scanner.nextInt();

        for(int i = 0; i < amount; i++){
            IO.print("Enter a task: ");
            task = IO.readln();
            addTodo.add(task);
        }

        try(FileWriter writer = new FileWriter(filePath, true)){

            for(String addTask : addTodo){
                writer.write(addTask+"\n");
            }
            IO.println("New task has been added.");
        }catch(FileNotFoundException e){
            IO.println("Task file not found.");
        }catch(IOException e){
            IO.println("Could not write to file.");
        }

    }
    void deleteAllTasks(){
        String filePath = "text.txt";
        String confirm;

        IO.print("Delete all tasks (Yes/No): ");
        confirm = IO.readln();

        while(!confirm.equals("Yes") && !confirm.equals("No")){
            IO.println("Invalid option.");
            IO.print("Delete all tasks (Yes/No): ");
            confirm = IO.readln();

            if(confirm.equals("Yes")){
                try(FileWriter writer  = new FileWriter(filePath, false)){
                    writer.close();
                    IO.println("Tasks has been deleted.");
                }catch(FileNotFoundException e){
                    IO.println("Task file not found.");
                }catch(IOException e){
                    IO.println("Could not write to file.");
                }
            }else{
                IO.println("File has not been deleted.");
            }
        }
    }
    void listTask(){
        String filePath = "text.txt";

        try(BufferedReader reader = new BufferedReader( new FileReader(filePath))){
            String line;
            IO.println("<Tasks>:");
            while((line = reader.readLine()) != null){
                IO.println(line);
            }
        }catch(FileNotFoundException e){
            IO.println("Task file not found.");
        }catch(IOException e){
            IO.println("Could not read from file.");
        }
    }
    @Override
    public String toString() {
        return first + " " + last;
    }
}
