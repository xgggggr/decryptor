package decrypt.decryptor.rot;

import decrypt.substitutor.Substitution;
import decrypt.vocabulary.EnglishVocabulary;
import decrypt.vocabulary.Vocabulary;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RotNDecryptorTest {
    private final Vocabulary enVoc = new EnglishVocabulary();
    @Test
    void constructor_nullVoc(){
        assertThrows(IllegalArgumentException.class, () -> new RotNDecryptor(1, null));
    }
    @Test
    void decrypt_rotTest(){
        List<Substitution> rot = new RotNDecryptor(2, enVoc).decrypt("data");
        Map<Character, Character> map = new HashMap<>();
        for(Substitution sub: rot ){
            map.put(sub.getOldLetter(), sub.getNewLetter());
        }
        assertEquals('a', map.get('y'));
        assertEquals('b', map.get('z'));

    }
    @Test
    void decrypt_bigShift(){
        List<Substitution> rot = new RotNDecryptor(28, enVoc).decrypt("data");
        Map<Character, Character> map = new HashMap<>();
        for(Substitution sub: rot ){
            map.put(sub.getOldLetter(), sub.getNewLetter());
        }
        assertEquals('c', map.get('a'));

    }
    @Test
    void decrypt_negativeShift(){
        List<Substitution> rot = new RotNDecryptor(-1, enVoc).decrypt("data");
        Map<Character, Character> map = new HashMap<>();
        for(Substitution sub: rot ){
            map.put(sub.getOldLetter(), sub.getNewLetter());
        }
        assertEquals('a', map.get('b'));
    }
    @Test
    void decrypt_nullData(){
        RotNDecryptor decr = new RotNDecryptor(1, enVoc);
        assertThrows(IllegalArgumentException.class, () -> decr.decrypt(null));
    }
}