/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package java2_project;

public class Member extends Account {

    private final int MEMBER_ID;

    public Member(String UserName, String Password, int MEMBER_ID) {
        super(UserName, Password);
        this.MEMBER_ID = MEMBER_ID;

    }

    public Member() {
        this("", "", 0);
    }

    public int getMEMBER_ID() {
        return MEMBER_ID;
    }

    @Override
    public String toString() {
        return String.format("%s%nMember Id: %d", super.toString(), MEMBER_ID);
    }

}
