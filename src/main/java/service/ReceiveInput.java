package service;

import java.util.Scanner;

public class ReceiveInput {
    private Calculate cal = new Calculate();
    private final Scanner scanner = new Scanner(System.in);
    private String userInput;
    History history = new History();
    public  ReceiveInput (){

    }
    public void start(){
        System.out.println("Welcome...");


        while (true) {

            System.out.print("Enter first number : ");
            userInput = scanner.nextLine();
            if ("esc".toLowerCase().equalsIgnoreCase(userInput)) {
                System.out.println("Exiting game...");
                break;
            }
            else {
                validInput(userInput,1);
                double firstNumber = Double.parseDouble(userInput);
                System.out.print("Enter second number : ");
                userInput =scanner.nextLine();
                validInput(userInput,1);
                double secondNumber = Double.parseDouble(userInput);
                System.out.print("which operator would you use(+ , - , * , /)? : ");
                userInput =scanner.nextLine();
                validInput(userInput,2);
                String operand = userInput;


            try {
                double result = 0;
                switch (operand) {
                    case "+":
                        result = cal.add(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = cal.subtract(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = cal.multipliy(firstNumber, secondNumber);
                        break;
                    case "/":
                        result = cal.divide(firstNumber, secondNumber);
                        if (result == -1)
                            System.out.print("second value can not be zero for divide operatiion !");
                        break;
                    default:
                        System.out.print("Invalid operator ! ");
                        continue;
                }
                if (result == -1)
                    System.out.print("your numbers were invalid please start from the first");
                else
                    history.save(result);
                    System.out.print("history added... " + System.getProperty("line.separator"));

            } catch (Exception e) {
                System.out.print("Error : " + e.getMessage());
            }
        }
        }
        System.out.print("The End ...! " );
        scanner.close();
        history.closeFile();
    }

   public void validInput(String str,int type){
       boolean valid = true;
       boolean inValid = false;
       while (valid) {
           if (type == 1) {
               for (int i = 0; i < str.length(); i++) {
                   if (!Character.isDigit((str.charAt(i)))) {
                       inValid = true;
                       break;
                   }
               }

               if (!inValid)
                   valid = false;

               else {
                   System.out.print("Invalid Input , please enter a number :");
                   str = scanner.nextLine();
                   inValid = false;
               }
           }
           else {

                   if (!(str.contains("+") || str.contains("-") ||str.contains("*") ||str.contains("/") ) ) {
                       inValid = true;

                   }

               if (!inValid)
                   valid = false;

               else {
                   System.out.print("Invalid Input , please enter operator from (+ , - , * , /) :");
                   str = scanner.nextLine();
                   inValid = false;
               }
           }
       }
       userInput=str;

   }
}