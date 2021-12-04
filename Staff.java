import java.io.*;
import java.util.*;

class Staff extends Library {
    Scanner in = new Scanner(System.in);

    void addNewBook() {
        String bookName, authorName, bookID;
        System.out.print("Name of book : ");
        bookName = in.nextLine();
        System.out.print("Book ID : ");
        bookID = in.nextLine();
        System.out.print("Author of book : ");
        authorName = in.nextLine();
        System.out.println("Number of copies : ");
        numberOfCopies = Integer.parseInt(in.nextLine());

        try {
            FileWriter fw = new FileWriter("Books.txt", true);
            String str = bookName + "|" + bookID + "|" + authorName + "|" + numberOfCopies + "\n";
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addNewStudent() {
        String studentName, registrationID;
        System.out.print("Name of student : ");
        studentName = in.nextLine();
        System.out.print("Registration number : ");
        registrationID = in.nextLine();
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
        try {
            File fr = new File("Books.txt");
            Scanner s = new Scanner(fr);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String data[] = line.split("\\|");
                System.out.println(data[0]);
                System.out.println(data[1]);
                System.out.println(data[2]);
                System.out.println(data[3]);
                System.out.println();
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void staffLogin() {
        System.out.println("1. ADD NEW BOOK \n2. REGISTER NEW STUDENT \n3. VIEW ALL BOOKS IN RECORD \n4. ISSUE BOOK");
        int cho = Integer.parseInt(in.nextLine());
        switch (cho) {
            case 1:
                addNewBook();
                break;

            case 2:
                addNewStudent();
                break;

            case 3:
                viewAllBooks();
                break;

            case 4:
                bookIssue();
                break;
                
            default:
                System.out.println("Enter valid choice");
                break;
        }
    }
}