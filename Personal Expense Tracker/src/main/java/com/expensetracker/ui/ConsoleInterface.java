package main.java.com.expensetracker.ui;

import main.java.com.expensetracker.exception.ValidationException;
import main.java.com.expensetracker.manager.ExpenseManager;
import main.java.com.expensetracker.manager.FileManager;
import main.java.com.expensetracker.model.Category;
import main.java.com.expensetracker.model.Expense;
import main.java.com.expensetracker.model.PaymentMethod;
import main.java.com.expensetracker.service.ReportGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private Scanner scanner;
    private ExpenseManager expenseManager;
    private FileManager fileManager;
    private ReportGenerator reportGenerator;
    private InputValidator inputValidator;

    public ConsoleInterface() {
        this.scanner = new Scanner(System.in);
        this.expenseManager = new ExpenseManager();
        this.fileManager = new FileManager();
        this.reportGenerator = new ReportGenerator();
        this.inputValidator = new InputValidator();
    }

    public void start() {
        loadData();
        showWelcomeMessage();

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = inputValidator.getValidChoice(1, 8);

            switch (choice) {
                case 1 -> addNewExpense();
                case 2 -> viewAllExpenses();
                case 3 -> viewExpensesByCategory();
                case 4 -> editExpense();
                case 5 -> deleteExpense();
                case 6 -> generateReports();
                case 7 -> backupData();
                case 8 -> running = exitApplication();
            }
        }
    }

    private void addNewExpense() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println(" ADD NEW EXPENSE");
        System.out.println("=".repeat(40));

        try {

            System.out.print("Enter description: ");
            String description = scanner.nextLine().trim();

            System.out.print("Enter amount: $");
            double amount = scanner.nextDouble();


            LocalDate date;
            while (true) {
                System.out.print("Enter date (yyyy-mm-dd) or press Enter for today: ");
                String dateInput = scanner.nextLine().trim();

                if (dateInput.isEmpty()) {
                    date = LocalDate.now();
                    break;
                } else {
                    try {
                        date = inputValidator.getValidDate(dateInput);
                        break;
                    } catch (ValidationException e) {
                        System.out.println("" + e.getMessage() + ". Please try again.");
                    }
                }
            }


            System.out.println("\nSelect category:");
            Category[] categories = Category.values();
            for (int i = 0; i < categories.length; i++) {
                System.out.printf("%d. %s%n", i + 1, categories[i]);
            }
            System.out.print("Enter category choice: ");
            int categoryChoice = inputValidator.getValidChoice(1, categories.length);
            Category category = categories[categoryChoice - 1];


            System.out.println("\nSelect payment method:");
            PaymentMethod[] paymentMethods = PaymentMethod.values();
            for (int i = 0; i < paymentMethods.length; i++) {
                System.out.printf("%d. %s%n", i + 1, paymentMethods[i]);
            }
            System.out.print("Enter payment method choice: ");
            int paymentChoice = inputValidator.getValidChoice(1, paymentMethods.length);
            PaymentMethod paymentMethod = paymentMethods[paymentChoice - 1];


            System.out.print("Enter notes (optional): ");
            String notes = scanner.nextLine().trim();


            Expense expense;
            if (!notes.isEmpty()) {
                expense = new Expense(description, amount, date, category, paymentMethod, notes);
            } else {
                expense = new Expense(description, amount, date, category, paymentMethod);
            }
            expenseManager.addExpense(expense);
            saveData();
            System.out.println(" Expense added successfully!");
            System.out.println("   Description: " + description);
            System.out.println("   Amount: $" + amount);
            System.out.println("   Date: " + date);
            System.out.println("   Category: " + category);
            System.out.println("   Payment Method: " + paymentMethod);
            if (!notes.isEmpty()) {
                System.out.println("Notes: " + notes);
            }

        } catch (ValidationException e) {
            System.out.println(" Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" An unexpected error occurred. Please try again.");
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        showMainMenu();
    }

    private void saveData() {
        try {
            List<Expense> expenses = expenseManager.getAllExpenses();
            fileManager.saveExpensesToFile(expenses);
        } catch (Exception e) {
            System.out.println(" Warning: Could not save data - " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            // Load expenses from a file (CSV, JSON, or serialized data)
            List<Expense> savedExpenses = fileManager.loadExpensesFromFile();

            if (savedExpenses != null && !savedExpenses.isEmpty()) {
                expenseManager.loadExpenses(savedExpenses);
                System.out.println("Loaded " + savedExpenses.size() + " expenses from file.");
            } else {
                System.out.println("No previous data found. Starting with empty expense list.");
            }
        } catch (Exception e) {
            System.out.println(" Could not load previous data: " + e.getMessage());
            System.out.println("Starting with empty expense list.");
        }
    }

    private void showWelcomeMessage() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" PERSONAL EXPENSE TRACKER");
        System.out.println("=".repeat(60));
        System.out.println("Welcome! Manage your expenses efficiently.");
        System.out.printf("Loaded %d existing expenses.%n", expenseManager.getAllExpenses().size());
        System.out.println();
    }

    private void showMainMenu() {
        System.out.println("\n MAIN MENU:");
        System.out.println("1.  Add New Expense");
        System.out.println("2.  View All Expenses");
        System.out.println("3. ️  View by Category");
        System.out.println("4.  Edit Expense");
        System.out.println("5. ️  Delete Expense");
        System.out.println("6.  Generate Reports");
        System.out.println("7.  Backup Data");
        System.out.println("8.  Exit");
        System.out.print("\nEnter your choice (1-8): ");
    }



}
