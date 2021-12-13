import java.io.*;
import java.util.*;

public class Library {
    Scanner in = new Scanner(System.in);
    
    
    int issueb=0, returnb=0;
    void action()
    {
        System.out.print("Registration number of student : ");
        String regNo = in.nextLine();
        try {
            int flag1=0, flag2=0;
            File fr1 = new File("Students.txt");
            Scanner s1 = new Scanner(fr1);
            File fr2 = new File("Books.txt");
            Scanner s2 = new Scanner(fr2);
            FileWriter tfw = new FileWriter("Temp.txt",true);
            File t = new File("Temp.txt");

            while(s1.hasNextLine())
            {
                String line = s1.nextLine();
                String data1[] = line.split("\\|");
                if(data1[1].equals(regNo))
                {
                    flag1 = 1;
                    System.out.print("Book name or Book ID : "); 
                    String bookInfo = in.nextLine();
                    try {
                        flag2=0;
                        while(s2.hasNextLine())
                        {
                            line = s2.nextLine();
                            String data2[] = line.split("\\|");
                            if((data2[0].equals(bookInfo) || data2[1].equals(bookInfo)))
                            {
                                flag2 = 1;
                                int x = Integer.parseInt(data2[3]);
                                try {
                                    if(issueb == 1  && x>0)
                                    {
                                        System.out.println("Book Issued!!");
                                        x-- ;
                                    }
                                    else if(returnb == 1)
                                    {
                                        System.out.println("Book Returned!!");
                                        x++ ;
                                    }
                                    String str = data2[0] + "|" + data2[1] + "|" + data2[2] + "|" + x + "\n";
                                    tfw.write(str);
                                    
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            else
                            {
                                String str =  data2[0] + "|" + data2[1] + "|" + data2[2] + "|" + data2[3] + "\n";
                                tfw.write(str);
                            }
                        }
                        if(flag2==0)
                        {
                            if(issueb == 1)
                                System.out.println("Book not available");
                            else if(returnb == 1)
                                System.out.println("Invalid Book Details");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            s2.close();
            s1.close();
            tfw.close();
            if(flag1 == 0)
            {
                t.delete();
                if(issueb == 1)
                    System.out.println("Student details not available");
                else if(returnb == 1)
                    System.out.println("Invalid Student Details");
            }
            if(flag1 == 1)
            {
                fr2.delete();
                File f = new File("Temp.txt");
                File r = new File("Books.txt");
                f.renameTo(r);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        issueb = returnb = 0;
    }

    void issueBook()
    {
        issueb = 1;
        action();
    }

    void returnBook()
    {
        returnb = 1;
        action();
    }
}