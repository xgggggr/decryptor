package decrypt.vocabulary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public abstract class AbstractVocabulary implements Vocabulary {
    private final List<Character> alphabetOrderList;
    private final List<Character> frequencyOrderList;
    protected AbstractVocabulary(List<Character> alphabetOrderList, List<Character> frequencyOrderList){
        this.alphabetOrderList = new ArrayList<>(alphabetOrderList);
        this.frequencyOrderList = new ArrayList<>(frequencyOrderList);
    }
    @Override
    public Set<Character> getLetters(){
        return new HashSet<>(alphabetOrderList);
    }
    @Override
    public List<Character> getLettersOrderedByFrequency(){
        return new ArrayList<>(frequencyOrderList);
    }
    @Override
    public int getIndexOfLetter(char c) {
        for (int i = 0; i < alphabetOrderList.size(); ++i) {
            if (alphabetOrderList.get(i) == c) {
                return i;
            }
        }
        throw new IllegalArgumentException("В алфавите нет буквы " + c);
    }

    @Override
    public char getLetterByIndex(int index){
        if(index < 0 || index >= alphabetOrderList.size()){
            throw new IllegalArgumentException("Индекс должен быть не менее 0 и меньше значения размера списка");

        }
        return alphabetOrderList.get(index);
    }
}
