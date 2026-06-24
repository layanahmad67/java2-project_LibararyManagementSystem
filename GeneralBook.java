/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public class GeneralBook extends Book {

    private String category;

    public GeneralBook(String Title, String Author, int serial_Num, int Pages, double basePrice, int copies, String category) {
        super(Title, Author, serial_Num, Pages, basePrice, copies);
        setCategory(category);
    }

    public GeneralBook() {
        this("", "", 0, 0, 0.0, 0, "");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double calcAmount() {
        return getBasePrice() + (getBasePrice() * 0.15);
    }

    public void categoryList() {
        System.out.println("The Category:");
        System.out.println("Computer Science");
        System.out.println("Medical Sciences");
        System.out.println("Business Management ");
        System.out.println("========================");
    }

    @Override
    public String toString() {
        return String.format("%s%n Category:%s%n", super.toString(), getCategory());
    }

}
