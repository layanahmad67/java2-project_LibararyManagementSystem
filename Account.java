/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public abstract class Account implements Available {

    private String UserName;
    private String Password;
    private static int AccountCount;
    private String isActive;

    public Account(String UserName, String Password) {
        setUserName(UserName);
        setPassword(Password);
        AccountCount++;
        this.isActive = "Active";
    }

    public Account() {
        this("", "");
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public static void setAccountCount(int AccountCount) {
        Account.AccountCount = AccountCount;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public static int getAccountCount() {
        return AccountCount;
    }

    public String getIsActive() {
        return isActive;
    }

    @Override
    public boolean isAvailabe() {
        if (getIsActive().equals("Active")) {
            return true;
        } else {
            return false;
        }
    }

    public void updateAccount(String OldUserName, String NewUserName, String NewPassword) {
        if (isAvailabe()) {
            setUserName(NewUserName);
            setPassword(NewPassword);
            System.out.println("Your account has been updated successsfully.");
        } else {
            System.out.println("You do not have Account \n You need to create Account ");
        }
    }

    @Override
    public String toString() {
        return String.format("Account%nUserName:%s%nPassword:%s", getUserName(), getPassword());
    }

}
