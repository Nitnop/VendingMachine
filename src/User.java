//import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class User extends Movie{
    
    static String titleSearch;
    static Scanner UserInput = new Scanner(System.in);
    static CopyOnWriteArrayList<Movie> movieList = new CopyOnWriteArrayList<Movie>(LoadUnload.loadMoviesFromFile());
    private static int userchoice;
    //static ArrayList<Movie> AtoZmovieTitleList = new ArrayList<Movie>();

    public static void printMovieList(){
        //AtoZmovieTitleList = Movie.sortTitleAtoZ(movieList);
        System.out.println("\n");
        int i = 0;
        for(Movie movtitle : movieList){
            System.out.print(++i + ": ");   
            System.out.println(movtitle);
            }
        System.out.println("\n");
        }

    public static void lowerquantity(int responseCode){

        if (responseCode > 399){
            //System.out.println("@lowerquantity" + movieList.get(userchoice).getQuantity());
            movieList.get(userchoice - 1).quantity = movieList.get(userchoice - 1).getQuantity() - 1;
            //System.out.println("@lowerquantity2" + movieList.get(userchoice).getQuantity());  test sucsessfull!!!!!
            LoadUnload.saveFile(movieList);
            System.out.println("sucsesfully checked out");
        }
        else{
            System.exit(0);}

    }

    public static void Start(){

        System. out.println("Welcome to Redbox");

        printMovieList();
        
        System.out.println("\ndo you want to rent any of these movies?\n");
        System.out.println("1 = yes\n2 = no");
        
        userchoice = Idiotproofing.idiotResistnantInt();
        
        switch(userchoice){

            case 2:
            System.out.println("Come back again soon!");
            System.exit(0);

            case 1:
            System.out.println("Enter the number of the movie you want to rent");
            userchoice = Idiotproofing.idiotResistnantInt() - 1;

            System.out.print("You chose ");
            System.out.println(movieList.get(userchoice));
            System.out.println("1 = yes\n2 = no");

            userchoice = Idiotproofing.idiotResistnantInt();

            switch(userchoice){

                case 2:
                Start();
                break;

                case 1:
                System.out.println("@case 1 : " + movieList.get(userchoice).getQuantity());
                Payment.Start();
                break;


            }

        }
    }
}
