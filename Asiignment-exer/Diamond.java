import java.util.ArrayList;
import java.util.List;

public class Diamond {
    public static void main(String[] args) {
        DiamondPrinter printer = new DiamondPrinter();
        List<String> diamond = printer.printToList('F');

        for (String row : diamond) {
            System.out.println(row);
        }
    }
}

class DiamondPrinter {

    List<String> printToList(char a) {
        int n = (a - 'A') + 1;
        List<String> diamond = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            char currentLetter = (char) ('A' + i);
            int spaces = n - i - 1;
            StringBuilder row = new StringBuilder();


            for (int j = 0; j < spaces; j++) {
                row.append(".");
            }


            row.append(currentLetter);


            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    row.append(".");
                }

                row.append(currentLetter);
            }

            for (int j = 0; j < spaces; j++) {
                row.append(".");
            }

            diamond.add(row.toString());
        }


        for (int i = n - 2; i >= 0; i--) {
            char currentLetter = (char) ('A' + i);
            int spaces = n - i - 1;
            StringBuilder row = new StringBuilder();

            // Append leading spaces
            for (int j = 0; j < spaces; j++) {
                row.append(".");
            }

            // Append letter
            row.append(currentLetter);

            // Append middle spaces (if not first or last row)
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    row.append(".");
                }
                // Append letter again for middle part
                row.append(currentLetter);
            }

            // Append trailing spaces
            for (int j = 0; j < spaces; j++) {
                row.append(".");
            }

            diamond.add(row.toString());
        }

        return diamond;
    }
}
