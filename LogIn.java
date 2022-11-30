package Fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Create username: ");
        String username = scanner.nextLine();
        String[] blockedSymbols = {
                "+","-","'","§","$","%","&","/","(",",",")","=","?","!","`",":",";","*","~"," "
        };

        boolean isIllegal = false;
        String currentSymbol = "";
        //Цикъл проверяващ за забранени символи
        for (int n = 0; true; n++) {
            for (int i = 0; i < username.length() ; i++) {

                char symbol = username.charAt(i);
                // проверява всеки символ от юзернейма за наличие на забранен от зададените долу
                // при наличие на забранен символ булевата става тру и влиза в иф проверката долу

                for (int j = 0; j < blockedSymbols.length; j++) {
                    currentSymbol = blockedSymbols[j];
                    char badSymbols = currentSymbol.charAt(0);
                    if (badSymbols == symbol){
                        isIllegal = true;
                        break;
                    }
                }
                if (isIllegal){
                    break;
                }
            }
            if (isIllegal) {
                if (currentSymbol.equals(" ")){
                    System.out.println("The symbol space is not allowed!%n");
                } else {
                    System.out.printf("The symbol '%s' is not allowed!%n", currentSymbol);
                }
                System.out.println("Create username: ");
                username = scanner.nextLine(); // повтаряме цикъла отново докато няма забранен символ
                isIllegal = false; // връщаме стойността на фолс за да не влезем в иф проверката ако няма забранен символ

            } else {   // ако няма забранен символ излизаме от цикъла
                break;
            }
        }
        // Юзернейма не трябва да е по-малък от 4 символа.
        while (username.length() < 4 && username.isBlank()) {
            System.out.println("Username can not be blank or less that 3 characters!");
            System.out.println("Create username: ");
            username = scanner.nextLine();
        }

        // Паролата не трябва да е по-малка от 4 символа.
        System.out.println("Create password:");
        String password = scanner.nextLine();
        while (password.length() < 4 && password.isBlank()) {
            System.out.println("Password can not be black or less than 3 characters!");
            System.out.println("Create password: ");
            password = scanner.nextLine();
        }
        System.out.println("Great! Now use your username and password to log in!");


        System.out.println("Enter your username: ");
        String inputUsername = scanner.nextLine();

        while (!username.equals(inputUsername)) {   // До въвеждане на точният юзър се върти цикъл
            System.out.println("Wrong username! Try again: ");
            inputUsername = scanner.nextLine();
        }

        // При въвеждане на грешна парола повече от 3 пъти, програмата приключва

        int attemptsLeft = 3;     // оставащи опити
        boolean isWrong = false;  // булева, с която излизаме от цикъла при въвеждане на 3 грешни пароли
        System.out.println("Enter your password:");
        String inputPassword = scanner.nextLine();

        while (!inputPassword.equals(password)) {
            attemptsLeft--;
            if (attemptsLeft == 0) { // проверка ако са достигнати зададеният брой грешни опити
                isWrong = true;
                break;
            }
            System.out.println("Wrong password! " + attemptsLeft + " attempts left!"); // може да се изпише и с форматиран текст
            inputPassword = scanner.nextLine();
        }

        if (isWrong) {
            System.out.println("Too many wrong attempts!");
        } else {
            System.out.printf("Welcome %s!", username);
        }
    }
}