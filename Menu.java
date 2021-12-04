import java.io.*;
import java.util.*;

public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.flush();
            System.out.println("LOGIN AS :\n\t 1. STAFF \n\t 2. STUDENT");
            int ch = Integer.parseInt(in.nextLine());
            switch (ch) {
                case 1:
                    Staff staff = new Staff();
                    System.out.print("Enter your login ID : ");
                    String loginIDStaff = in.nextLine();
                    String username = "admin";
                    if (loginIDStaff.equals(username)) {
                        staff.staffLogin();
                    }
                    else{
                        System.out.println("Please enter valid login details");
                    }
                break;
                
                case 2:
                break;

                default:
                    return;
                    // System.out.println("Enter Valid Choice");
                }
            }
    }
}