import java.util.Scanner;

public class Idiotproofing{

    

    static Scanner UserInput = new Scanner(System.in);

    public static int idiotResistnantInt(){
        
        while (!UserInput.hasNextInt()) UserInput.next();
        
        int choice = UserInput.nextInt();

        UserInput.nextLine();  //trying to flush buffer

        return choice;

    }

    public static String idiotResistnantString(){
        
        while (!UserInput.hasNextLine()) UserInput.next();
        
        String stringChoice = UserInput.nextLine();

        return stringChoice;

    }

    public static Boolean idiotResistnantBool(){
        
        while (!UserInput.hasNextBoolean()) UserInput.next();
        
        Boolean stringChoice = UserInput.nextBoolean();

        return stringChoice;

    }


    
}
