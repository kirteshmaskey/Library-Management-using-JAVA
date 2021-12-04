import java.io.*;
import java.util.*;

public class Library {
    int numberOfCopies = 0;
    void bookIssue()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Registration number of student : ");
        String regNo = in.nextLine();
        try {
            int flag1=0;
            File fr1 = new File("Students.txt");
            Scanner s1 = new Scanner(fr1);
            while(s1.hasNextLine())
            {
                String line = s1.nextLine();
                String data1[] = line.split("\\|");
                if(data1[1].equals(regNo))
                {
                    flag1 = 1;
                    System.out.println("Book name or Book ID"); 
                    String book = in.nextLine();
                    try {
                        int flag2=0;
                        File fr2 = new File("Books.txt");
                        Scanner s2 = new Scanner(fr2);
                        while(s2.hasNextLine())
                        {
                            line = s2.nextLine();
                            String data2[] = line.split("\\|");
                            if(data2[0].equals(book) || data2[1].equals(book))
                            {
                                flag2 = 1;
                                System.out.println("Book Issued!!");
                                try {
                                    FileWriter fw = new FileWriter("Books.txt", true);
                                    int x = Integer.parseInt(data2[3]);
                                    x-- ;
                                    String str = data2[0] + "|" + data2[1] + "|" + data2[2] + "|" + x + "\n";
                                    fw.write(str);
                                    fw.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                        }
                        if(flag2==0)
                        {
                            System.out.println("Book not available");
                        }
                        s2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            if(flag1 == 0)
            {
                System.out.println("Student details not available");
            }
            s1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
    }

    void returnBook() {

    }

}