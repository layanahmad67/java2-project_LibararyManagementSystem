/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Available> list1 = new ArrayList<>();
    static ArrayList<Borrow> list2 = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        fillList(list1);

        do {

            try {
                System.out.println("------ Welcome to Library system ------");
                menu();
                System.out.println("Enter your choice from 1 to 9 :");
                choice = input.nextInt();
                switch (choice) {

                    case 1:
                        creatAccount();
                        break;

                    case 2:
                        updateAccount();
                        break;

                    case 3:
                        borrowBook();
                        break;
                    case 4:
                        displayBook();
                        break;
                    case 5:
                        returnBook();
                        break;

                    case 6:
                        LibraryAPP.main(null);
                        break;

                    case 7:
                        ReadText rt = new ReadText();
                        rt.openTextFile("Books.txt");
                        rt.readFromFile();
                        rt.closeFile();
                        break;
                    case 8:
                        WriteText wf = new WriteText();
                        wf.openTextFile("Books.txt");
                        if (list2.isEmpty()) {
                            System.out.println("No books yet.");
                        } else {
                            for (Available ele : list1) {

                                if (ele instanceof Book) {
                                    wf.writeToFile((Book) ele);
                                }
                            }
                        }
                        wf.closeFile();
                        System.out.println("All orders saved to the text file orders.txt");
                        break;

                    case 9:
                        System.out.println("Thank you for using our system.");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InputMismatchException ex) {
                System.err.println("Invalid input");
                input.nextLine();
            } catch (NullPointerException ex) {
                System.err.println(ex);
            } catch (ClassCastException ex) {
                System.err.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println(ex);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } while (choice != 9);

    }

    public static void menu() {

        System.out.println("\n1.Create Account"
                + "\n2.Ubdate Account"
                + "\n3.Borrow Book"
                + "\n4.Display Books"
                + "\n5.Return Book"
                + "\n6.GUI"
                + "\n7.Read from File."
                + "\n8.Save Orders."
                + "\n9.Exit."
                + "\n >>");
    }

    public static void updateAccount() {
        input.nextLine();
        System.out.print("Enter your username: ");
        String userName = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        boolean found = false;
        for (Available ele : list1) {
            if (ele instanceof Account) {
                Account account = (Account) ele;
                String currentUsername = account.getUserName();
                String currentPassword = account.getPassword();

                if (currentUsername.equals(userName) && currentPassword.equals(password)) {
                    System.out.print("Enter your new  username: ");
                    String newuserName = input.nextLine();
                    System.out.print("Enter your new password: ");
                    String newPassword = input.nextLine();

                    account.updateAccount(currentUsername, newuserName, newPassword);
                    found = true;
                    break;
                }

            }
        }
        if (found == false) {
            System.out.println("Sorry, no account found with this username and password.");
        }
    }

    public static void fillList(ArrayList<Available> list1) {

        list1.add(new Member("Sara", "123456", 113037648));
        list1.add(new Librarian("Joud", "156893"));
        list1.add(new Novels("Harry Potter", "J.k.rowling", 18950, 450, 50, 6, "Fantasy"));
        list1.add(new GeneralBook("Java Programing", "James Gosling", 14968, 300, 60, 20, "Computer Scince"));
        list1.add(new EducationalBook("Imagination machine", "Martin Reeves", 12653, 450, 70, 12, "Harvard"));

    }

    public static Account creatAccount() {
        System.out.println("if you are member enter 1 \n if you are librarian enter 2\n");
        int option = input.nextInt();

        input.nextLine();
        System.out.println("Enter User name: ");

        String U = input.nextLine();

        System.out.println("Enter Passowrd: ");

        String P = input.nextLine();

        Account account = null;
        if (option >= 1 && option <= 2) {

            if (option == 1) {
                System.out.println("Enter ID : ");
                int I = input.nextInt();
                account = new Member(U, P, I);
            } else {
                account = new Librarian(U, P);
            }
            list1.add(account);
            System.out.println("Your Account : " + account);
        } else {
            System.out.println("You chioce is not correct");
        }

        return account;
    }

    public static void borrowBook() {

        System.out.print("How many days want to borrow the items? ");
        int days = input.nextInt();

        System.out.print("How many items want to borrow? ");
        int num = input.nextInt();
        if (num < 1 || num > Available.MAX_BOOKS) {
            System.out.println("Sorry, the min number is 1 and the max allowed number of items is " + Available.MAX_BOOKS);
            return;
        }

        // Borrow(Member member, Book[] books, Date date)
        Book[] orderBooks = new Book[num];
        System.out.println("Enter " + num + " book serial numbers:");
        int count = 0;
        while (count < num) {
            System.out.printf("Enter book  #%d serial_Num: %s\n", (count + 1), " Enter -1 to exite :  ");
            int serialNumber = input.nextInt();
            //search for product
            boolean flag = false;
            for (Available ele : list1) {

                if (serialNumber == -1) {
                    return;
                }
                if (ele instanceof Book) {
                    Book book = (Book) ele;
                    if (book.getSerial_Num() == serialNumber) {
                        if (book.isIsValid()) {
                            book.borrowingBook();
                            orderBooks[count] = book;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            //end
            if (!flag) {
                System.out.println("Invalid book serial number  or book is not valid!");
            } else {
                count++;
            }
        }//end loop

        System.out.println("Enter borrow date:");
        System.out.print("year: ");
        int year = input.nextInt();

        while (year < 2024) {

            System.out.println("Invalid year.");

            year = input.nextInt();
        }

        System.out.print("month: ");
        int month = input.nextInt();
        while (month < 1 || month > 12) {

            System.out.println("Invalid month.");
            System.out.println("Enter again: ");

            month = input.nextInt();
        }

        System.out.print("day: ");
        int day = input.nextInt();

        while (day < 1 || day > 31) {
            System.out.println("Invalid day.");
            System.out.println("Enter again: ");
            day = input.nextInt();
        }

        //Borrow(Member member, Book[] books, Date date) 
        System.out.println("DO YOU HAVE AN ACCOUNT: (Y/N)");

        char answer = input.next().charAt(0);

        Borrow borrow;
        if (answer == 'Y' || answer == 'y') {

            input.nextLine();

            Account account = returnAccount();

            if (account == null) {

                System.out.println("The account is not available");

                //Member(String UserName, String Password, int MEMBER_ID) 
                //Librarian(String UserName, String Password)
                System.out.println("1. Account member");
                System.out.println("2. Account Librarian");
                int type = input.nextInt();

                input.nextLine();
                System.out.print("Enter your new  username: ");
                String userName = input.nextLine();
                System.out.print("Enter your new password: ");
                String password = input.nextLine();
                if (type == 1) {

                    System.out.println("Enter member id: ");
                    int id = input.nextInt();
                    account = new Member(userName, password, id);

                } else {
                    account = new Librarian(userName, password);
                }

            }

            borrow = new Borrow(account, orderBooks, new DATE(year, month, day));

            System.out.print("Confirm order? (Y/N): ");
            char answer2 = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {

                list2.add(borrow);
                System.out.println("Your borrow has completed successfully!");
            } else {
                System.out.println("Your borrow has been cancelled!");
            }
        }
    }

    public static void displayBook() {
        for (Available b : list1) {

            //poly
            if (b instanceof Book) {
                System.out.println(b);
            }
            if (b instanceof EducationalBook) {

                ((EducationalBook) b).instituteNames();
            } else if (b instanceof Novels) {
                ((Novels) b).availableGenere();
            } else if (b instanceof GeneralBook) {
                ((GeneralBook) b).categoryList();

            }

            //down casting
            if (b instanceof Book) {
                System.out.println("The price :" + ((Book) b).calcAmount());
            }

        }
    }

    public static void returnBook() {

        System.out.print("Enter borrow id: ");
        int borrowNum = input.nextInt();
        boolean found = false;
        for (Borrow ele : list2) {
            if (ele.getBorrowId() == borrowNum) {

                ele.return_Book();
                found = true;

                Book books[] = ele.getBooks();

                for (Book book : books) {

                    System.out.println("How many days did the book stay with you ? ");
                    int days = input.nextInt();
                    if (days > 30) {
                        System.out.println("The total price of Late return of " + book.getTitle() + " " + book.Late_Return(days));
                    }
                }

                System.out.println("Your Book is return \n Thank You! ");
            }
        }
        if (found == false) {
            System.out.println("Borrow with id " + borrowNum + " is not found");
        }

    }

    public static Account returnAccount() {

        System.out.println("Enter the user name: ");
        String userName = input.nextLine();

        System.out.println("Enter the passoword: ");
        String passowrd = input.nextLine();

        Account account = null;

        for (Available available : list1) {
            if (available instanceof Account) {

                if (((Account) available).getPassword().equals(passowrd) && ((Account) available).getUserName().equals(userName)) {

                    account = ((Account) available);
                }
            }
        }

        return account;
    }
}
