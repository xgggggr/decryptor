package decrypt.decryptor;

import decrypt.decryptor.frequency.FrequencyDecryptor;
import decrypt.decryptor.rot.RotNDecryptor;
import decrypt.vocabulary.RussianVocabulary;
import decrypt.vocabulary.Vocabulary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptorFactoryTest {
    private final Vocabulary ruVoc = new RussianVocabulary();
    @Test
    void create_nullVoc(){
        assertThrows(IllegalArgumentException.class, () -> DecryptorFactory.create("FREQ", null));
    }
    @Test
    void create_nullName(){
        assertThrows(IllegalArgumentException.class, () -> DecryptorFactory.create(null, ruVoc));
    }
    @Test
    void create_UnknownName(){
        assertThrows(IllegalArgumentException.class, () -> DecryptorFactory.create("sixseven", ruVoc));
    }
    @Test
    void create_ROTWithoutNum(){
        assertThrows(IllegalArgumentException.class, () -> DecryptorFactory.create("ROT", ruVoc));
    }
    @Test
    void create_ROTBadNum(){
        assertThrows(IllegalArgumentException.class, () -> DecryptorFactory.create("ROTx", ruVoc));
    }
    @Test
    void create_Freq(){
        assertInstanceOf(FrequencyDecryptor.class, DecryptorFactory.create("FREQ", ruVoc));
    }
    @Test
    void create_ROT3(){
        assertInstanceOf(RotNDecryptor.class, DecryptorFactory.create("ROT3", ruVoc));
    }
    @Test
    void create_ROT0(){
        assertInstanceOf(RotNDecryptor.class, DecryptorFactory.create("ROT0", ruVoc));
    }
    @Test
    void create_ROTneg(){
        assertInstanceOf(RotNDecryptor.class, DecryptorFactory.create("ROT-123", ruVoc));
    }

}