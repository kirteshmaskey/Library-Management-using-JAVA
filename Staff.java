import java.io.*;
import java.util.*;

class Staff extends Library {
    Scanner in = new Scanner(System.in);

    void addNewBook() {
        String bookName, authorName, bookID;
        int numberOfCopies = 0;
        System.out.print("Name of book : ");
        bookName = in.nextLine();
        System.out.print("Book ID : ");
        bookID = in.nextLine();
        System.out.print("Author of book : ");
        authorName = in.nextLine();
        System.out.print("Number of copies : ");
        numberOfCopies = Integer.parseInt(in.nextLine());

        try {
            File fr = new File("Books.txt");
            fr.createNewFile();
            Scanner f = new Scanner(fr);
            FileWriter fw = new FileWriter("Temp.txt", true);
            int flag = 0;
            while(f.hasNextLine())
            {
                String get = f.nextLine();
                String tStr[] = get.split("\\|");
                if(tStr[1].equals(bookID))
                {
                    flag = 1;
                    int copies = Integer.parseInt(tStr[3]);
                    copies = copies + numberOfCopies;
                    String str = bookName + "|" + bookID + "|" + authorName + "|" + copies + "\n";
                    fw.write(str);
                }
                else
                {
                    String str = tStr[0] + "|" + tStr[1] + "|" + tStr[2] + "|" + tStr[3] + "\n";
                    fw.write(str);
                }
            }
            if(flag == 0)
            {
                String str = bookName + "|" + bookID + "|" + authorName + "|" + numberOfCopies + "\n";
                fw.write(str);
            }
            fw.close();
            f.close();
            fr.delete();
            File t = new File("Temp.txt");
            File r = new File("Books.txt");
            t.renameTo(r);
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
            File sf = new File("Students.txt");
            sf.createNewFile();
            Scanner sfs = new Scanner(sf);
            int flag = 0;
            while(sfs.hasNextLine())
            {
                String line = sfs.nextLine();
                String data[] = line.split("\\|");
                if(data[1].equals(registrationID))
                {
                    flag = 1;
                    System.out.println("Student already registered");
                } 
            }
            sfs.close();
            if(flag == 0)
            {
                FileWriter fw = new FileWriter("Students.txt", true);
                String str = studentName + "|" + registrationID + "\n";
                fw.write(str);
                fw.close();
            }
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
                System.out.println("Book name : " + data[0]);
                System.out.println("BookId : " + data[1]);
                System.out.println("Author : " + data[2]);
                System.out.println("Number of copies : " + data[3]);
                System.out.println();
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void staffLogin() {
        System.out.println("1. ADD NEW BOOK \n2. REGISTER NEW STUDENT \n3. VIEW ALL BOOKS IN RECORD \n4. ISSUE BOOK \n5. RETURN BOOK");
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
                issueBook();
                break;

            case 5:
                returnBook();
                break;
                
            default:
                return;
        }
    }
}