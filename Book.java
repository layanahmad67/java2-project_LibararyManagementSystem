/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package java2_project;

public abstract class Book implements Available {

    private String Title;
    private String Author;
    public int Pages;
    private int serial_Num;
    private static int BookCount;
    private double basePrice;
    private int copies;
    public boolean isValid;

    public Book(String Title, String Author, int serial_Num, int Pages, double basePrice, int copies) {
        setTitle(Title);
        setAuthor(Author);
        setSerial_Num(serial_Num);
        setPages(Pages);
        setBasePrice(basePrice);
        setCopies(copies);
        setIsValid(true);
        BookCount++;
    }

    public Book() {
        this("", "", 0, 0, 0.0, 0);
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setSerial_Num(int serial_Num) {
        this.serial_Num = serial_Num;
    }

    public static void setBookCount(int BookCount) {
        Book.BookCount = BookCount;
    }

    public void setPages(int Pages) {
        this.Pages = Pages;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            System.out.println("Invalid price.");
        } else {
            this.basePrice = basePrice;
        }
    }
       public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
       
       public void setCopies(int copies) {
        this.copies = copies;
    }
       
    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getSerial_Num() {
        return serial_Num;
    }

    public static int getBookCount() {
        return BookCount;
    }

    public int getPages() {
        return Pages;
    }

    public double getBasePrice() {
        return basePrice;
    }

    
    public boolean isIsValid() {
        return isValid;
    }

   

    public int getCopies() {
        return copies;
    }

    @Override
    public boolean isAvailabe() {
        if (isValid) {
            return true;
        } else {
            return false;
        }

    }

    public final void borrowingBook() {
        if (isAvailabe()) {
            copies--;
            BookCount++;
        } else {
            System.out.println("Sorry, the item is not available.");
        }
    }

    public final void returnItem() {
        copies++;
        System.out.println(getTitle() + " has been returned, Thank you.");
    }

    public abstract double calcAmount();

    public double Late_Return(int Days) { 
        if (Days <= 30) {
            return getBasePrice();
        } else if (Days > 30 || Days <= 60) {
            return (getBasePrice() * 1.5) + getBasePrice();
        } else {
            return (getBasePrice() * 3.0) + getBasePrice();
        }

    }
    
    @Override
    public String toString() {
        return String.format("%nBook%nTitle:%s%nAuthor:%s%nPages:%d%nserial_Num:%d%nBase Price: %.2f SAR\nAvailable Copies: %d", getTitle(), getAuthor(), getPages(),getSerial_Num(), getBasePrice(), getCopies());
    }

}
