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
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == true && Character.isDigit(c)) {
                firstNum.append(c);
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == false && Character.isDigit(c)) {
                secondNum.append(c);
            } else {
                System.out.println("Вы ввели ерунду ! Попробуйте еще раз.");
                System.exit(0);
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
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == true && ContainsInEnum(c)) {
                firstNum.append(c);
            } else if (c != '+' && c != '-' && c != '*' && c != '/' && firstDigit == false && ContainsInEnum(c)) {
                secondNum.append(c);
            } else {
                System.out.println("Вы ввели ерунду ! Попробуйте еще раз.");
                System.exit(0);
            }
        }
        for (int i = 0; i < RomanLetter.values().length; i++) {
            if(firstNum.toString().equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i]))){
                aDigit = RomanLetter.values()[i].ordinal() + 1;
            }
//            aDigit = firstNum.toString().equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i])) ?
//                    RomanLetter.values()[i].ordinal() + 1 : 0;
        }
        for (int i = 0; i < RomanLetter.values().length; i++) {
            if(secondNum.toString().equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i]))){
                bDigit = RomanLetter.values()[i].ordinal() + 1;
            }
//            bDigit = secondNum.toString().equals(RomanLetter.values()[i].getRomanConverted(RomanLetter.values()[i])) ?
//                RomanLetter.values()[i].ordinal() + 1 : 0;
        }
        if (FinalCalculations(aDigit, bDigit, sign) > 0){
            System.out.println(FinalCalculations(aDigit, bDigit, sign));
        }
        else {
            System.out.println("У Римлян не было отрицаельных чисел !");
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
        switch (sign){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
    enum RomanLetter{
        I("I"), II("II"), III("III"), IV("IV"), V("V"),
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