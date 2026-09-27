package decrypt.decryptor.frequency;

import decrypt.substitutor.Substitution;
import decrypt.substitutor.Substitutor;
import decrypt.vocabulary.EnglishVocabulary;
import decrypt.vocabulary.Vocabulary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FrequencyDecryptorTest {
    private final Vocabulary enVoc = new EnglishVocabulary();

    private static Map<Character, Character> toMap(List<Substitution> list) {
        Map<Character, Character> map = new HashMap<>();
        for (Substitution sub : list) {
            map.put(sub.getOldLetter(), sub.getNewLetter());
        }
        return map;
    }
    @Test
    void decrypt_Test(){
        Map<Character, Character> map = toMap(new FrequencyDecryptor(enVoc).decrypt("Aba"));
        assertEquals('e', map.get('a') );
    }
    @Test
    void decrypt_textTransform(){
        FrequencyDecryptor decryptor = new FrequencyDecryptor(enVoc);
        Substitutor sub = new Substitutor(decryptor.decrypt("Aba"));
        assertEquals("Ete", sub.substitute("Aba"));
    }
    @Test
    void decrypt_earlierInAlphabete(){
        Map<Character, Character> map = toMap(new FrequencyDecryptor(enVoc).decrypt("ab"));
        assertEquals('e', map.get('a'));
        assertEquals('t', map.get('b'));
    }
    @Test
    void constructor_nullVoc(){
        assertThrows(IllegalArgumentException.class, () -> new FrequencyDecryptor(null));
    }


}