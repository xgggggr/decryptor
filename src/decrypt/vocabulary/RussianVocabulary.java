package decrypt.vocabulary;

public class RussianVocabulary extends AbstractVocabulary {
    private static final String ALPHABET_ORDER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String FREQUENCY_ORDER = "оеанитслвркмудпыябгзчьйхжшюцэщфъё";
    public RussianVocabulary(){
        super( VocabularyToList.toList(ALPHABET_ORDER), VocabularyToList.toList(FREQUENCY_ORDER));




    }
}
