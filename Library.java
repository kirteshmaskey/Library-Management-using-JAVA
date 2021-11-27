import java.io.*;
import java.util.*;

public class Library {
    void bookIssue() {

    }

    void returnBook() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("LOGIN AS :\n\t 1. STAFF \n\t 2. STUDENT");
        int ch = Integer.parseInt(in.nextLine());
        switch (ch) {
            case 1:
            Staff staff = new Staff();
            System.out.print("Enter your login ID : ");
            String loginIDStaff = in.nextLine();
            String username = "admin";
            if (loginIDStaff.equals(username)) {
                System.out.println("1. ADD NEW BOOK \n2. REGISTER NEW STUDENT \n3. VIEW ALL BOOKS IN RECORD");
                int cho = in.nextInt();
                switch (cho) {
                case 1:
                    staff.addNewBook();
                    break;

                case 2:
                    staff.addNewStudent();
                    break;
                    
                case 3:
                    staff.viewAllBooks();
                    break;

                default:
                    System.out.println("Enter valid choice");
                    break;
                }
            }
            break;
            
            case 2:
            break;

        default:
            System.out.println("Enter Valid Choice");
        }
    }
}

class Staff extends Library {
    Scanner in = new Scanner(System.in);

    void addNewBook() {
        String bookName, authorName, bookID;
        System.out.print("Name of book : ");
        bookName = in.nextLine();
        System.out.print("Author of book : ");
        authorName = in.nextLine();
        System.out.print("Book ID : ");
        bookID = in.nextLine();
        try {
            FileWriter fw = new FileWriter("Books.txt", true);
            String str = bookName + "|" + authorName + "|" + bookID + "\n";
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addNewStudent() {
        String studentName;
        int registrationID;
        System.out.print("Name of student : ");
        studentName = in.nextLine();
        System.out.print("Registration number : ");
        registrationID = in.nextInt();
        try {
            FileWriter fw = new FileWriter("Students.txt", true);
            String str = studentName + "|" + registrationID + "\n";
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void viewAllBooks() {
        System.out.println("All books that are available\n\n");
        try{
            File fr = new File("Books.txt");
            Scanner s = new Scanner(fr);
            // FileReader fr = new FileReader("Books.txt");
            while(s.hasNextLine())
            {
                String line = s.nextLine();
                String data[] = line.split("\\|");
                System.out.println(data[0]);
                System.out.println(data[1]);
                System.out.println(data[2]);
                System.out.println();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student extends Library {

}