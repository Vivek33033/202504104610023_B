import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    int id;
    String title;
    double amount;
    String category;

    public Expense(int id, String title, double amount, String category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public void display() {
        System.out.println("ID: " + id + " | Title: " + title + " | Amount: ₹" + amount + " | Category: " + category);
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n===== EXPENSE TRACKER MENU =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Expense Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    expenses.add(new Expense(id, title, amount, category));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("⚠ No expenses found.");
                    } else {
                        System.out.println("\n--- Expense List ---");
                        for (Expense e : expenses) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Expense ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    boolean foundUpdate = false;

                    for (Expense e : expenses) {
                        if (e.id == updateId) {
                            System.out.print("Enter New Title: ");
                            e.title = sc.nextLine();

                            System.out.print("Enter New Amount: ");
                            e.amount = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter New Category: ");
                            e.category = sc.nextLine();

                            System.out.println(" Expense updated successfully!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println(" Expense not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Expense ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;

                    for (int i = 0; i < expenses.size(); i++) {
                        if (expenses.get(i).id == deleteId) {
                            expenses.remove(i);
                            System.out.println(" Expense deleted successfully!");
                            foundDelete = true;
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println(" Expense not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Expense Tracker...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}