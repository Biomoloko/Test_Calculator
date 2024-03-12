import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder firstNum = new StringBuilder();
        StringBuilder secondNum = new StringBuilder();
        char sign = ' ';
        boolean firstDigit = true;
        String usersInput;

        Scanner scanner = new Scanner(System.in);
        usersInput = scanner.nextLine();

        usersInput = usersInput.replaceAll(" ", "");

        char[] usersCharArr = usersInput.toCharArray();

        ArabicLogic(usersCharArr, sign, firstDigit, firstNum, secondNum);
    }



    public static void ArabicLogic(char [] usersCharArr, char sign, boolean firstDigit, StringBuilder firstNum, StringBuilder secondNum){
        for (char c : usersCharArr) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                sign = c;
                firstDigit = false;
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == true && Character.isDigit(c)) {
                firstNum.append(c);
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == false && Character.isDigit(c)) {
                secondNum.append(c);
            } else {
                System.out.println("Вы ввели ерунду ! Попробуйте еще раз.");
            }
        }
        int result = ArabicDigitCalculations(Integer.parseInt(firstNum.toString()), Integer.parseInt(secondNum.toString()), sign);
        System.out.println(result);
    }

    public static int ArabicDigitCalculations(int a, int b, char sign){
        switch (sign){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static void RomanLogic(char [] usersCharArr, char sign, boolean firstDigit, StringBuilder firstNum, StringBuilder secondNum){
        for (char c : usersCharArr) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                sign = c;
                firstDigit = false;
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == true && RomanLetter.) {
                firstNum.append(c);
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == false && Character.isDigit(c)) {
                secondNum.append(c);
            } else {
                System.out.println("Вы ввели ерунду ! Попробуйте еще раз.");
            }
        }
        int result = ArabicDigitCalculations(Integer.parseInt(firstNum.toString()), Integer.parseInt(secondNum.toString()), sign);
        System.out.println(result);
    }

    public static boolean ContainsInEnum(char letter) {
        boolean isInEnum = false;
        for (RomanLetter с : RomanLetter.values()) {
            if (letter == RomanLetter) {
                isInEnum = true
            }
        }
    }
    enum RomanLetter{
        I("I"), II("II"), III("III"), IV("IV("), V("V"),
        VI("VI"), VII("VII"), VIII("VIII"), IX("IX"), X("X");

        private String literal;
        RomanLetter(String literal){
            this.literal = literal;
        }
        public String getRomanConverted(RomanLetter romanLetter){
            return literal;
        }
    }
}