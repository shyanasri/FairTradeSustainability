/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jjmar
 */
import java.util.Scanner;

public class GreenGame {
    
    // Goal: who reaches 2030 first?
    // Questions asked everyday for 17 days related to 17 UN Goals
    // Right answer => 1 step towards 2030
    // Wrong answer => same position or sometimes pushed back
    // Some Example Questions Below
    
    //Goal 1: End Poverty 
    public void Day1(){
        System.out.println("Goal 1: Choose the right answer: a/A,b/B,c/C");
        System.out.println("Let's start with an easy question");
        System.out.println("Despite having a job, ___ % of world's workers and families lived under extreme poverty in 2018");
        System.out.println("a. 3");
        System.out.println("b. 11");
        System.out.println("c. 8");
         
    }
    
    public void Day2(){
        System.out.println("Goal 2: Congratulations on making it to Goal 2!");
        System.out.println("Here is a True/False:");
        System.out.println("Approximately 1 in 9 people in the world were undernourished in 2017");      
    }
    
    
    public void Day3(){
        System.out.println("Goal 3: Congratulations on making it to Goal 3!");
        System.out.println("What is recognized as one of the world’s most successful and cost-effective health interventions?(please use lower case letters)");
    }
    
    public static void main(String[] args){
        
      GreenGame a = new GreenGame();
      a.Day1();
      Scanner ans = new Scanner(System.in);
      String answer = ans.nextLine();
      
      if(answer.equals("c")|| answer.equals("C")){
          System.out.println("That's right!!Congratulations, you have achieved goal 1");
          System.out.println("The number one goal of UN is to end poverty in all its form everywhere by 2030");
          System.out.println("To learn more about the progress of Goal 1 in 2019 visit:https://sustainabledevelopment.un.org/sdg1");
          
           a.Day2();
           Scanner ans2 = new Scanner(System.in);
           boolean answer2 = ans2.nextBoolean();
           if(answer2 == true){
                System.out.println("That's right!!Congratulations, you have achieved goal 2");
                System.out.println("The goal number 2 set by UN is to end hunger,achieve food security and improved nutrition and promote sustainable agriculture");
                System.out.println("To learn more about the progress of Goal 2 in 2019 and how you can contribute  visit:https://sustainabledevelopment.un.org/sdg2");
                    a.Day3();
                    Scanner ans3 = new Scanner(System.in);
                    String answer3 = ans3.nextLine();
                    if(answer3.equals("immunization")){
                        System.out.println("That's right!!Congratulations, you have achieved goal 3");
                        System.out.println("The goal number 3 set by UN is to ensure healthy lives and promote well-being for all at all ages");
                        System.out.println("To learn more about the progress of Goal 3 in 2019 and how you can contribute  visit:https://sustainabledevelopment.un.org/sdg3");    
                    }else{
                        System.out.println("Sorry, that's not the right answer");
                        System.out.println("The goal number 3 set by UN is to ensure healthy lives and promote well-being for all at all ages");
                        System.out.println("To learn more about the progress of Goal 3 in 2019 and how you can contribute  visit:https://sustainabledevelopment.un.org/sdg3"); 
                    }
                    
           }else{
               System.out.println("Sorry, that's not the right answer");
               System.out.println("The goal number 2 set by UN is to end hunger,achieve food security and improved nutrition and promote sustainable agriculture");
               System.out.println("To learn more about the progress of Goal 2 in 2019 and how you can contribute  visit:https://sustainabledevelopment.un.org/sdg2");
           }
          
      }else{
          System.out.println("Sorry, the right answer is c.8%.");
          System.out.println("The number one goal of UN is to end poverty in all its form everywhere by 2030");
          System.out.println("To learn more about the progress of Goal 1 in 2019 visit:https://sustainabledevelopment.un.org/sdg1");
      }
        
    }
    
}
