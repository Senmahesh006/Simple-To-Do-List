import java.util.ArrayList;
import java.util.Scanner;

public class SimpleToDoList {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to the To-Do List!");

        while (isRunning) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - View To-Do List");
            System.out.println("2 - Add Item");
            System.out.println("3 - Remove Item");
            System.out.println("4 - Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewToDoList();
                    break;
                case 2:
                    addItem(scanner);
                    break;
                case 3:
                    removeItem(scanner);
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose a number from 1 to 4.");
            }
        }

        System.out.println("Thank you for using the To-Do List!");
        scanner.close();
    }

    private static void viewToDoList() {
        System.out.println("Your To-Do List:");
        if (todoList.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter the item to add: ");
        String newItem = scanner.nextLine();
        todoList.add(newItem);
        System.out.println("Item added to the list!");
    }

    private static void removeItem(Scanner scanner) {
        viewToDoList();
        if (!todoList.isEmpty()) {
            System.out.print("Enter the number of the item to remove: ");
            int indexToRemove = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (indexToRemove >= 1 && indexToRemove <= todoList.size()) {
                String removedItem = todoList.remove(indexToRemove - 1);
                System.out.println("Removed: " + removedItem);
            } else {
                System.out.println("Invalid item number!");
            }
        }
    }
}
