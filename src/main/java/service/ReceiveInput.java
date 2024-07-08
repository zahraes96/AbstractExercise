package service;

import java.util.Scanner;

public class ReceiveInput {
    private Calculate cal = new Calculate();
    History history = new History();
    public  ReceiveInput (){

    }
    public void start(){
        System.out.println("Welcome...");
        final Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("If you want to Exit please enter Esc otherwise Enter your first number : ");
            double firstNumber = Double.parseDouble(scanner.nextLine());
            if ("Esc".equalsIgnoreCase(String.valueOf(firstNumber))) {
                System.out.println("Exiting game...");
                break;
            }
            
            System.out.print("Enter second number : ");
            double secondNumber = Double.parseDouble(scanner.nextLine());
            System.out.print("which operator would you use(+ , - , * , /)? : ");
            String operand = scanner.nextLine();


            try {
                double result = 0;
                switch (operand){
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
                        System.out.print("Invalid operator ! " );
                        continue;
                }
                if(result== -1)
                    System.out.print("your numbers were invalid please start from the first");
                else
                  history.save(result);

            }
            catch (Exception e){
                System.out.print("Error : " + e.getMessage());
            }

        }
        System.out.print("The  End ...! " );
        scanner.close();
        history.closeFile();
    }
}