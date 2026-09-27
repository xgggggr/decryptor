package decrypt.decryptor.frequency;

import decrypt.decryptor.Decryptor;
import decrypt.substitutor.Substitution;
import decrypt.vocabulary.Vocabulary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrequencyDecryptor implements Decryptor {
    private final Vocabulary vocabulary;
    public FrequencyDecryptor(Vocabulary vocabulary){
        if(vocabulary == null){
            throw new IllegalArgumentException("Алфавит не может быть null");
        }
        this.vocabulary = vocabulary;
    }

    @Override
    public List<Substitution> decrypt(String data) {
        // NOTE: Запрещается менять реализацию этого метода!
        FrequencyAnalysisResult frequencyAnalysisResult = FrequencyAnalysis.computeCharacterFrequencies(data);
        List<Substitution> substitutions = createSubstitutions(frequencyAnalysisResult);
        return Collections.unmodifiableList(substitutions);
    }

    private List<Substitution> createSubstitutions(FrequencyAnalysisResult frequencyAnalysisResult) {
        if(frequencyAnalysisResult == null){
            throw new IllegalArgumentException("Результат анализе не может быть null");

        }
        List<Character> lettersByFrequency = new ArrayList<>();
        for(int i = 0; i < vocabulary.getTotalLetters(); ++i){
            lettersByFrequency.add(vocabulary.getLetterByIndex(i));
        }
        for(int i = 0; i < lettersByFrequency.size() - 1; ++i){
            for(int j = 0; j < lettersByFrequency.size() -1-i; ++j){
                char l = lettersByFrequency.get(j);
                char r = lettersByFrequency.get(j+1);
                int lCount = frequencyAnalysisResult.getNumberOfAppearances(l);
                int rCount = frequencyAnalysisResult.getNumberOfAppearances(r);
                if(rCount > lCount){
                    lettersByFrequency.set(j, r);
                    lettersByFrequency.set(j+1, l);

                }
            }
        }
        List<Character> alphabetByFrequency = vocabulary.getLettersOrderedByFrequency();
        List<Substitution> result = new ArrayList<>(lettersByFrequency.size());
        for(int i = 0; i < lettersByFrequency.size(); ++i){
            result.add(new Substitution(lettersByFrequency.get(i), alphabetByFrequency.get(i)));
        }
        return result;
    }
}
