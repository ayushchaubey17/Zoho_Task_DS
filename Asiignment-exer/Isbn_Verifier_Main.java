public class Isbn_Verifier_Main {
    public static void main(String[] args) {
        IsbnVerifier verifier = new IsbnVerifier();


        System.out.println(verifier.isValid("3-598-21508-8"));
        System.out.println(verifier.isValid("3-598-21507-X"));
        System.out.println(verifier.isValid("3-598-21507"));
        System.out.println(verifier.isValid("3598215088"));
        System.out.println(verifier.isValid("359821507X"));
        System.out.println(verifier.isValid("3-598-P1581-X"));
        System.out.println(verifier.isValid("3-598-2X507-0"));
        System.out.println(verifier.isValid("359821507"));
    }
}

class IsbnVerifier {

    boolean isValid(String stringToVerify) {



        String cleanString = stringToVerify.replaceAll("-", "").toUpperCase();


        if (cleanString.length() != 10) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(cleanString.charAt(i))) {
                return false;
            }
        }

        char lastChar = cleanString.charAt(9);
        if (!(Character.isDigit(lastChar) || lastChar == 'X')) {
            return false;
        }



        int sum = 0;
        for (int i = 0; i < 10; i++) {
            char c = cleanString.charAt(i);
            int digit = (c == 'X') ? 10 : (c - '0');
            sum += digit * (10 - i);
        }

        return (sum % 11) == 0;



    }

}

