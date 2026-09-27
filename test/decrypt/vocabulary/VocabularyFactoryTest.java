package decrypt.vocabulary;

import decrypt.decryptor.frequency.FrequencyDecryptor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VocabularyFactoryTest {
    @Test
    void create_null(){
        assertThrows(IllegalArgumentException.class, () -> VocabularyFactory.create(null));
    }
    @Test
    void create_unknownName(){
        assertThrows(IllegalArgumentException.class, () -> VocabularyFactory.create("AD"));

    }
    @Test
    void create_RuVoc(){
        assertInstanceOf(RussianVocabulary.class, VocabularyFactory.create("RU"));

    }
    @Test
    void create_EnVoc(){
        assertInstanceOf(EnglishVocabulary.class, VocabularyFactory.create("EN"));
    }

}