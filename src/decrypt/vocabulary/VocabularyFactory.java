package decrypt.vocabulary;

import java.util.Objects;

public class VocabularyFactory {
    private VocabularyFactory() {
    }

    public static Vocabulary create(String vocabularyName) {
        if(vocabularyName == null){
            throw new IllegalArgumentException("Строка не можеть быть null");
        }
        if (vocabularyName.equals("EN")){
            return new EnglishVocabulary();
        }
        else if(vocabularyName.equals("RU")){
            return new RussianVocabulary();
        }
        else{
            throw new IllegalArgumentException("Некорректное название алфавита. Допускаются только RU и EN");
        }
    }
}
