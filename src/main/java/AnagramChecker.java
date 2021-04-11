import java.util.Arrays;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-10 <br>
 * Time: 11:40 <br>
 * Project: expleo-test <br>
 */
public class AnagramChecker {

    public boolean isAnagram(String word1, String word2){
        word1 = word1.toLowerCase().replace(" ","");
        word2 = word2.toLowerCase().replace(" ","");
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array2, array1);
    }
}

