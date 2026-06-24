/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public class Borrow {

    private Book[] books;
    private DATE date;
    private Account member;
    public static int BorrowCount;
    private int borrowId;

    public Borrow(Account member, Book[] books, DATE date) {
        setMember(member);
        setBooks(books);
        setDate(date);

        borrowId = ++BorrowCount;

    }

    public Borrow() {
        this(null, null, null);
    }

    public static void setBorrowCount(int BorrowCount) {
        Borrow.BorrowCount = BorrowCount;
    }

    public void setDate(DATE date) {
        this.date = date;
    }

    public void setMember(Account member) {
        this.member = member;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public DATE getDate() {
        return date;
    }

    public Account getMember() {
        return member;
    }

    public Book[] getBooks() {
        return books;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public static int getBorrowCount() {
        return BorrowCount;
    }

    public void displayBooks() {
        for (Book b : books) {
            System.out.println(b);
            System.out.println("-------------------");
        }
    }

    public final void return_Book() {

        double total = 0;

        for (Book book : books) {
            book.setIsValid(true);

            total += book.calcAmount();
        }

        System.out.println("All books have been returned. Thanks");

        System.out.printf("Your total amount is: %.2f SAR.\n", total);

    }

    public void processBorrow() {
        for (Book b : books) {
            b.setCopies(b.getCopies() - 1);
        }

    }

    public String getbooks() {
        String b = "";

        for (Book book : books) {
            b += book;
        }

        return b;
    }

    @Override
    public String toString() {
        return String.format("%s%nBorrow%n books:%S%ndate%s%nmember%s - borrowId%d", super.toString(), getbooks(), getDate(), getMember(), getBorrowId());
    }

}
