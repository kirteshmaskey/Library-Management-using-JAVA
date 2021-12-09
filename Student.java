import java.util.*;

class Student extends Library {
    Scanner in = new Scanner(System.in);
    void studentLogin()
    {
        System.out.println("1. ISSUE BOOK \n2. RETURN BOOK");
        int ch = Integer.parseInt(in.nextLine());

        switch(ch)
        {
            case 1:
                issueBook();
                break;
            
            case 2:
                returnBook();
                break;
            
            default:
                return;
        }
    }
}
