package wr;
//File Name EmployeeManager.java

// EmployeeManager - Task3 (Improved variable names)
import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Error: Exactly one argument is required.");
            return;
        }

        String command = args[0];

        if (command.equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String[] employees = line.split(",");
                for (String emp : employees) {
                    System.out.println(emp);
                }
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        } else if (command.equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String line = reader.readLine();
                System.out.println(line);
                String[] employees = line.split(",");
                Random rand = new Random();
                int idx = rand.nextInt(employees.length);
                System.out.println(employees[idx]);
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        } else if (command.contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true));
                String nameToAdd = command.substring(1);
                writer.write(", " + nameToAdd);
                writer.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        } else if (command.contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String[] employees = line.split(",");
                boolean found = false;
                String searchName = command.substring(1);
                for (int i = 0; i < employees.length && !found; i++) {
                    if (employees[i].equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        } else if (command.contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String line = reader.readLine();
                char[] chars = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        } else if (command.contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String[] employees = line.split(",");
                String nameToUpdate = command.substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(nameToUpdate)) {
                        employees[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
                writer.write(String.join(",", employees));
                writer.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Updated.");
        } else if (command.contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String[] employees = line.split(",");
                String nameToDelete = command.substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(employees));
                list.remove(nameToDelete);
                BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
                writer.write(String.join(",", list));
                writer.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Deleted.");
        }
    }
    // TASK 4: Read employees into string array
    public static String[] readEmployees() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
        String line = reader.readLine();
        reader.close();
        return line.split(",");
    }

    // TASK 4: Write employees array back to file
    public static void writeEmployees(String[] employees) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
        writer.write(String.join(",", employees));
        writer.close();
    }
}
