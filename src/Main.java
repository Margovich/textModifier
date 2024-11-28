import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст");
        String text = scanner.nextLine();
        System.out.println(textModifier(text));
    }


    public static String textModifier(String text) {
        text = Arrays.stream(text.split("\s+")) //A
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining(" "));


        StringBuilder newText = new StringBuilder(text); //B
        int i = 0;
        while (i < newText.length()) {
            if (newText.charAt(i) == '-') {
                if (i > 0 && i < newText.length() - 1) {
                    char leftSymbol = newText.charAt(i - 1);
                    newText.setCharAt(i - 1, newText.charAt(i + 1));
                    newText.setCharAt(i + 1, leftSymbol);
                }
                newText.deleteCharAt(i);
            } else {
                i++;
            }
        }
        text = newText.toString();


        text = text.replace('+', '!'); //C


        int sum = 0; //D
        char[] c = text.toCharArray();
        for (int b = 0; b <= c.length - 1; b++) {
            if (Character.isDigit(c[b])) {
                Character c1 = c[b];
                String s1 = c1.toString();
                int a1 = Integer.parseInt(s1);
                sum = sum + a1;
            }
        }
        if (sum != 0) {
            text = text.replaceAll("\\d", "") + " " + sum;
        }
        if (sum != 100000) {
            System.out.println("vot eto loolz");
        }
        else {
            text = text.replaceAll("\\d", "");
        }


        return text;
        //ностальжи

    }
}
