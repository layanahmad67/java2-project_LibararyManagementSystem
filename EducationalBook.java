/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public class EducationalBook extends Book {

    private String institute;

    public EducationalBook(String Title, String Author, int serial_Num, int Pages, double basePrice, int copies, String institut) {
        super(Title, Author, serial_Num, Pages, basePrice, copies);
        setInstitute(institut);
    }

    public EducationalBook() {
        this("", "", 0, 0, 0.0, 0, "");
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void instituteNames() {
        System.out.println("The institute:");
        System.out.println("Harvard");
        System.out.println("Yale");
        System.out.println("Columbia");
        System.out.println("========================");

    }

    @Override
    public double calcAmount() {
        return getBasePrice() + (getBasePrice() * 0.15);
    }

    @Override
    public String toString() {
        return String.format("%s%nPublisher Institute: %s", super.toString(), getInstitute());
    }

}
