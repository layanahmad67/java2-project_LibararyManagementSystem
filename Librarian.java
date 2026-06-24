/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public class Librarian extends Account {

    private final int BASE_SALARY= 4000;

    public Librarian(String UserName, String Password) {
        super(UserName, Password);

    }

    public Librarian() {
        this("", "");
    }

    public int getBASE_SALARY() {
        return BASE_SALARY;
    }

    public double calcSalary(int Hours) {
        if (Hours > 5) {
            return BASE_SALARY + (BASE_SALARY * 0.25);
        } else {
            return BASE_SALARY;
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n Librarian%nSalary:%d ", super.toString(), getBASE_SALARY());
    }

}
