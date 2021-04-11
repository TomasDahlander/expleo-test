import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-10 <br>
 * Time: 11:44 <br>
 * Project: expleo-test <br>
 */
public class AnagramTesterTest {

    @Test
    public final void isAnagramTest(){
        AnagramTester at = new AnagramTester();
        assertTrue(at.isAnagram("Mary","army"));
        assertTrue(at.isAnagram("åra","råa"));
        assertTrue(at.isAnagram("dog","GOD"));
        assertTrue(at.isAnagram("harald den långe","åland har den gel"));
        assertTrue(at.isAnagram("      DoG   ","       gOd  "));
        assertFalse(at.isAnagram("Mary","arma"));
    }
}
