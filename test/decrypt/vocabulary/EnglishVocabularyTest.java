package decrypt.vocabulary;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnglishVocabularyTest {
    private final Vocabulary enVoc = new EnglishVocabulary();
    @Test
    void getTotalLetters_Test(){
        assertEquals(26, enVoc.getTotalLetters());
    }
    @Test
    void getLetters_Test(){
        assertEquals(26, enVoc.getLetters().size());
        assertTrue(enVoc.getLetters().contains('s'));
        assertTrue(enVoc.getLetters().contains('i'));
        assertTrue(enVoc.getLetters().contains('x'));
        assertTrue(enVoc.getLetters().contains('e'));
        assertTrue(enVoc.getLetters().contains('v'));
        assertTrue(enVoc.getLetters().contains('n'));
    }
    @Test
    void getIndexOfLetter_IllegalLetter(){
        assertThrows(IllegalArgumentException.class, () -> enVoc.getIndexOfLetter('0'));
    }
    @Test
    void getIndexOfLetter_Test(){
        assertEquals(6, enVoc.getIndexOfLetter('g'));
        assertEquals(7, enVoc.getIndexOfLetter('h'));
    }
    @Test
    void getLetterByIndex_Test(){
        assertEquals('g', enVoc.getLetterByIndex(6));
        assertEquals('h', enVoc.getLetterByIndex(7));
    }
    @Test
    void getLetterByIndex_negativeInd(){
        assertThrows(IllegalArgumentException.class, () -> enVoc.getLetterByIndex(-67));
    }
    @Test
    void getLetterByIndex_tooLargeInd(){
        assertThrows(IllegalArgumentException.class, () -> enVoc.getLetterByIndex(26));
    }
    @Test
    void getLettersOrderedByFrequency_Test(){
        List<Character> freq = enVoc.getLettersOrderedByFrequency();
        assertEquals('e', freq.get(0));
    }

}