package decrypt.vocabulary;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VocabularyToListTest {
    @Test
    void toList_nullTest(){
        assertThrows(IllegalArgumentException.class, () -> VocabularyToList.toList(null));

    }
    @Test
    void toList_Test(){
        List<Character> l= new ArrayList<>();
        l.add('a');
        l.add('b');
        assertEquals(l, VocabularyToList.toList("ab"));
    }

}