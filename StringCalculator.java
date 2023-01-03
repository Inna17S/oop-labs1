package main;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        String delimiters = ",|\n";
        String[] elements;
        StringBuilder negative = new StringBuilder();
        numbers = numbers.replaceAll(" ", "");


        if (numbers.isEmpty()) //перевірити порожній рядок
            return 0;
        if (numbers.toLowerCase().contains(",\n") || numbers.toLowerCase().contains("\n,")) {
            throw new RuntimeException("Incorrect Syntax Format!");}
        //перевірка наявності роздільників
        if (numbers.contains("//")) {
            String delimiter = numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\\n"));
            numbers = numbers.substring(numbers.indexOf("\\n") + 2);
            if (delimiter.endsWith("]") && delimiter.indexOf("[") == 0) {
                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(delimiter);
                int groupCount = matcher.groupCount();
                while (matcher.find()) {
                    for (int i = 0; i <= groupCount; i++) {
                        String m = matcher.group(i);
                        numbers = numbers.replaceAll(Pattern.quote(m), ",");
                    }
                }
                delimiter = ",";
            }

            // Поділ чисел за допомогою розділювача
            elements = numbers.split(Pattern.quote(delimiter));
        }
        else
            elements = numbers.split(delimiters);

        ArrayList<Integer> negative_numbers = new ArrayList<>();
        //Підрахунок суми чисел
        int summa = 0;
        for (String n : elements) {
            Integer s = Integer.parseInt(n);
            if (s < 0) {
                negative_numbers.add(s);
                negative.append(String.valueOf(s)).append(" ");
            }
            // Значення більше 1000 не слід додавати
            else if (s <= 1000)
                summa += s;
        }
        // виняток, якщо негативне значення існує
        NegativeValues.throwExceptionIfNegativeExists(negative.toString());
        return summa;
    }
    public class NegativeValues {
        public static class NegativesNotAllowed extends RuntimeException {
            public NegativesNotAllowed(String s) {
                super(s);
            }
        }

        public static void throwExceptionIfNegativeExists(String negative) {
            if (!Objects.equals(negative, "")) {
                throw new NegativesNotAllowed("Negatives Numbers are: " + negative);
            }
        }

    }
}


