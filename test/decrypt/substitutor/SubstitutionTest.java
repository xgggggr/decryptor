package decrypt.substitutor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutionTest {
    @Test
    void constructor_UppercaseOldLetterException(){
        assertThrows(IllegalArgumentException.class, () -> new Substitution('A', 'b') );

    }
    @Test
    void constructor_UppercaseNewLetterException(){
        assertThrows(IllegalArgumentException.class, () -> new Substitution('a', 'B'));
    }
    @Test
    void getOldLetter_Test(){
        Substitution s = new Substitution('a', 'b');
        assertEquals('a', s.getOldLetter());
    }
    @Test
    void getNewLetter_Test(){
        Substitution s = new Substitution('a', 'b');
        assertEquals('b', s.getNewLetter());
    }
}