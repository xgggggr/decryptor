package decrypt.vocabulary;

import java.util.ArrayList;
import java.util.List;

public class VocabularyToList {
    private VocabularyToList(){};
    public static List<Character> toList(String letters){
        if(letters == null){
            throw new IllegalArgumentException("Строка не может быть null");
        }
        List<Character> result = new ArrayList<>(letters.length());
        for(int i = 0; i < letters.length(); ++i){
            result.add(letters.charAt(i));
        }
        return result;
    }

}
