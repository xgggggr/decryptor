package decrypt.vocabulary;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RussianVocabularyTest {
    private final Vocabulary ruVoc = new RussianVocabulary();
    @Test
    void getTotalLetters_Test(){
        assertEquals(33, ruVoc.getTotalLetters());
    }
    @Test
    void getLetters_Test(){
        assertEquals(33, ruVoc.getLetters().size());
        assertTrue(ruVoc.getLetters().contains('с'));
        assertTrue(ruVoc.getLetters().contains('и'));
        assertTrue(ruVoc.getLetters().contains('к'));
        assertTrue(ruVoc.getLetters().contains('е'));
        assertTrue(ruVoc.getLetters().contains('в'));
        assertTrue(ruVoc.getLetters().contains('н'));
    }
    @Test
    void getIndexOfLetter_IllegalLetter(){
        assertThrows(IllegalArgumentException.class, () -> ruVoc.getIndexOfLetter('0'));
    }
    @Test
    void getIndexOfLetter_Test(){
        assertEquals(6, ruVoc.getIndexOfLetter('ё'));
        assertEquals(7, ruVoc.getIndexOfLetter('ж'));
    }
    @Test
    void getLetterByIndex_Test(){
        assertEquals('ё', ruVoc.getLetterByIndex(6));
        assertEquals('ж', ruVoc.getLetterByIndex(7));
    }
    @Test
    void getLetterByIndex_negativeInd(){
        assertThrows(IllegalArgumentException.class, () -> ruVoc.getLetterByIndex(-67));
    }
    @Test
    void getLetterByIndex_tooLargeInd(){
        assertThrows(IllegalArgumentException.class, () -> ruVoc.getLetterByIndex(33));
    }
    @Test
    void getLettersOrderedByFrequency_Test(){
        List<Character> freq = ruVoc.getLettersOrderedByFrequency();
        assertEquals('о', freq.get(0));
    }


}