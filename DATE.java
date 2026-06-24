/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public final class DATE {

    private int Day;
    private int Month;
    private int Year;

    public DATE(int Day, int Month, int Year) {
        setDay(Day);
        setMonth(Month);
        setYear(Year);

    }

    public DATE() {
        this(0, 0, 0);
    }

    public void setDay(int Day) {
        this.Day = Day;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }

}
