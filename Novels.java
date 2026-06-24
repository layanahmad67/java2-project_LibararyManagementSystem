/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public class Novels extends Book {

    private String genere;

    public Novels(String Title, String Author, int serial_Num, int Pages, double basePrice, int copies, String genere) {
        super(Title, Author, serial_Num, Pages, basePrice, copies);
        setGenere(genere);

    }

    public Novels() {
        this("", "", 0, 0, 0.0, 0, "");
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public double calcAmount() {
        switch (getGenere()) {
            case "Fantasy":
                return getBasePrice() + (getBasePrice() * 0.10);
            case "Historical":
                return getBasePrice() + (getBasePrice() * 0.20);

            case "Horror":
                return getBasePrice() + (getBasePrice() * 0.30);
            default:
                return getBasePrice();
        }
    }

    
    

    public void availableGenere() {
        System.out.println("The genere :");
        System.out.println("1. Fantasy");
        System.out.println("2. Historical");
        System.out.println("3. Horror");
        System.out.println("========================");
    }

    @Override
    public String toString() {
        return String.format("%s%nType:%s%n", super.toString(), getGenere());
    }

}
