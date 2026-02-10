package CountWords.FifthSprint.FilesAndPath;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharSetExercises {
    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF-8");
        System.out.println(charset.name());

        Charset charset2 = StandardCharsets.US_ASCII;
        System.out.println(charset2);

        System.out.println(Charset.defaultCharset().displayName());
    }
}
