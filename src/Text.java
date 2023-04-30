import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    public static void main(String[] args) {
        String strText = "Gree, blue, violet and red, my name`s Billy, your name`s Fred, violet, orange, " +
                "red and yellow, look at the beautifull rainbow.";
        Pattern pt = Pattern.compile("\\b[AEIOUYaeiouy]\\w*");
        Matcher mt = pt.matcher(strText);
        String stringOfSelection = " ";
        while (mt.find()) {
            stringOfSelection += mt.group() + " ";
        }
        System.out.println(stringOfSelection);
        String[] words = stringOfSelection.split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        Arrays.sort(words, Comparator.comparing(Text::getConsonant));
        for (String word : words) {
            System.out.println(word);
        }
    }
    private static char getConsonant(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letterOfWord = Character.toLowerCase(word.charAt(i));
            if (letterOfWord != 'a' && letterOfWord != 'e' && letterOfWord != 'i' && letterOfWord != 'o' && letterOfWord != 'u' && letterOfWord != 'y') {
                return letterOfWord;
            }
        }
        return 0;
    }
}