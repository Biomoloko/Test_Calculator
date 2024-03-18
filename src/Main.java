import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StringBuilder firstNum = new StringBuilder();
        StringBuilder secondNum = new StringBuilder();
        char sign = ' ';
        boolean firstDigit = true;
        RomanLetter romanLetter;
        String usersInput;

        Scanner scanner = new Scanner(System.in);
        usersInput = scanner.nextLine();

        usersInput = usersInput.replaceAll(" ", "");

        char[] usersCharArr = usersInput.toCharArray();


        if (Character.isDigit(usersCharArr[0])){
            ArabicLogic(usersCharArr, sign, firstDigit, firstNum, secondNum);
        }
        else {
            RomanLogic(usersCharArr, sign, firstDigit, firstNum, secondNum);
        }
    }


    public static void ArabicLogic(char [] usersCharArr, char sign, boolean firstDigit, StringBuilder firstNum, StringBuilder secondNum){
        for (char c : usersCharArr) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                sign = c;
                firstDigit = false;
            } else if (NotSign(c) && firstDigit == true && Character.isDigit(c)) {
                firstNum.append(c);
            } else if (NotSign(c) && firstDigit == false && Character.isDigit(c)) {
                secondNum.append(c);
            } else {
                throw new ArithmeticException("Вы ввели ерунду ! Попробуйте еще раз.");
            }
        }
        System.out.println(FinalCalculations(Integer.parseInt(firstNum.toString()), Integer.parseInt(secondNum.toString()), sign));
    }


    public static void RomanLogic(char [] usersCharArr, char sign, boolean firstDigit, StringBuilder firstNum, StringBuilder secondNum){
        int aDigit = 0;
        int bDigit = 0;
        int result;

        for (char c : usersCharArr) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                sign = c;
                firstDigit = false;
            } else if (NotSign(c) && firstDigit == true && ContainsInEnum(c)) {
                firstNum.append(c);
            } else if (NotSign(c) && firstDigit == false && ContainsInEnum(c)) {
                secondNum.append(c);
            } else {
                throw new ArithmeticException("Вы ввели ерунду ! Попробуйте еще раз.");
            }
        }
        for (int i = 0; i < RomanLetter.values().length; i++) {
            if(firstNum.toString().equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i]))){
                aDigit = RomanLetter.values()[i].ordinal() + 1;
            }
            if(secondNum.toString().equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i]))){
                bDigit = RomanLetter.values()[i].ordinal() + 1;
            }
        }

        if (FinalCalculations(aDigit, bDigit, sign) >= 0){
            System.out.println(RomanLetter.values()[FinalCalculations(aDigit, bDigit, sign)-1]);
        }
        else {
            throw new ArithmeticException("У Римлян не было отрицаельных чисел !");
        }
    }

    public static boolean ContainsInEnum(char letter) {
        for (int i = 0; i < RomanLetter.values().length; i++) {
            if (Character.toString(letter).equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i]))) {
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }

    public static int FinalCalculations(int a, int b, char sign){
        if (a > 10 ||  b > 10) {
            throw new ArithmeticException("Число не может быть больше 10 !");
        }
        switch (sign){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static boolean NotSign(char c){
        return c != '+' && c != '-' && c != '*' && c != '/';
    }
    enum RomanLetter{
        I("I"), II("II"), III("III"), IV("IV"), V("V"),
        VI("VI"), VII("VII"), VIII("VIII"), IX("IX"), X("X"),
        XI("XI"), XII("XII"), XIII("XIII"), XIV("XIV"), XV("XV"),
        XVI("XVI"), XVII("XVII"), XVIII("XVIII"), XIX("XIX"), XX("XX");

        private String literal;
        RomanLetter(String literal){
            this.literal = literal;
        }
        public String getRomanConverted(RomanLetter romanLetter){
            return literal;
        }
    }
}