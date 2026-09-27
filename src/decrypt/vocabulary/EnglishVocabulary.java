package decrypt.vocabulary;

public class EnglishVocabulary extends AbstractVocabulary {
    private static final String ALPHABET_ORDER = "abcdefghijklmnopqrstuvwxyz";
    private static final String FREQUENCY_ORDER = "etaohinsrdlumwcfgypbvkxjqz";
    public EnglishVocabulary(){
        super(VocabularyToList.toList(ALPHABET_ORDER), VocabularyToList.toList(FREQUENCY_ORDER));
    }
}
