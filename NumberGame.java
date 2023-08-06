package CodSoft;
import java.util.Scanner;

public class NumberGame {
    static int count;
    public static int gen(){
        System.out.println("!!! Number Generated between 1 to 100 !!!");
        System.out.println();
        
        int s=10+count;
        int n=s;
        count+=11;
        return n;

    }
    public static void guess(int n)   {
        
        System.out.println("********Guess the Correct Number********** ");
         System.out.println();
        System.out.println("_____YOU HAVE FIVE CHANCE TO GUESS_____ ");
        System.out.println();
        
       
           
            try {
                 for(int i=0;i<5;i++){
                System.out.println("Enter correct Number ");
                System.out.println();
                
                Scanner sc=new Scanner(System.in);
                 int g=sc.nextInt(); 
                if(n==g){
                    System.out.println("***** YOU WIN *****");
                    System.out.println("you can guess num at "+ ++i + "chance");

                    break;    
                }
                else{
                    System.out.println("wrong Guess");
                    System.out.println();
                    if(g<n){
                        System.out.println("Correct number  is greater than "+g);
                    }
                    else{
                         System.out.println("Correct number  is less than "+g);
                    }

                }
                }
                
            } catch (Exception e) {
                System.out.println("Enter valid Number");
                guess(n);
               
              }
             
             
            
        }
    
    public static void option(){
        System.out.println("**** FOR PLAY Again ENTER 1 ****");
         System.out.println();
        System.out.println("**** Exit Game Enter 2 ****");
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        
        if(q<1 || q>2){
            System.out.println("Enter the valid input ");
            option();
        }
        switch(q){
           
                   
            case 2:System.out.print("++++ =EXIT= ++++"); 
                    break;
            case 1:int n=gen();
                   guess(n);
                   
            default: option();
                  
        }
    }
    public static void main(String[] args) {
        int n=gen();
        guess(n);
        option();

      

    }
}
