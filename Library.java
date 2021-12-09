import java.io.*;
import java.util.*;

public class Library {
    Scanner in = new Scanner(System.in);
    int numberOfCopies = 0;
    void issueBook()
    {
        System.out.println("Registration number of student : ");
        String regNo = in.nextLine();
        try {
            int flag1=0;
            File fr1 = new File("Students.txt");
            Scanner s1 = new Scanner(fr1);
            File fr2 = new File("Books.txt");
            Scanner s2 = new Scanner(fr2);
            FileWriter tfw = new FileWriter("Temp.txt",true);

            while(s1.hasNextLine())
            {
                String line = s1.nextLine();
                String data1[] = line.split("\\|");
                if(data1[1].equals(regNo))
                {
                    flag1 = 1;
                    System.out.println("Book name or Book ID"); 
                    String bookInfo = in.nextLine();
                    try {
                        int flag2=0;
                        while(s2.hasNextLine())
                        {
                            line = s2.nextLine();
                            String data2[] = line.split("\\|");
                            int x = Integer.parseInt(data2[3]);
                            if((data2[0].equals(bookInfo) || data2[1].equals(bookInfo)) && x>0)
                            {
                                flag2 = 1;
                                System.out.println("Book Issued!!");
                                try {
                                    x-- ;
                                    String str = data2[0] + "|" + data2[1] + "|" + data2[2] + "|" + x + "\n";
                                    tfw.write(str);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                // break;     --> if found
                            }
                            else
                            {
                                String str =  data2[0] + "|" + data2[1] + "|" + data2[2] + "|" + data2[3] + "\n";
                                tfw.write(str);
                            }
                        }
                        if(flag2==0)
                        {
                            System.out.println("Book not available");
                        }
                    } catch (IOException e) {
                        System.out.println("Hello From Book");
                        e.printStackTrace();
                    }
                    break;
                }
            }
            s2.close();
            tfw.close();

            // fr2.delete();
            fr2.delete();
            File f = new File("Temp.txt");
            File r = new File("Books.txt");
            f.renameTo(r);
            if(flag1 == 0)
            {
                System.out.println("Student details not available");
            }
            s1.close();
        } catch (IOException e) {
            System.out.println("Hello From Student");
            e.printStackTrace();
        }
    }


    void returnBook() {
        
    }

}