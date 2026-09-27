package decrypt.decryptor.frequency;

import java.util.Map;
import java.util.HashMap;
public class FrequencyAnalysisResult {
    private final Map<Character, Integer> charToFrequency;
    public FrequencyAnalysisResult(Map<Character, Integer> charToFrequency){
        if(charToFrequency == null){
            throw new IllegalArgumentException("Сопоставление не может быть null");

        }
        Map<Character, Integer> map = new HashMap<>();
        for(Map.Entry<Character, Integer> i: charToFrequency.entrySet()){
            if (Character.isLetter(i.getKey()) && !Character.isLowerCase(i.getKey())){
                throw new IllegalArgumentException("буква " + i.getKey() + " должна быть в нижнем регистре!");
            }
            map.put(i.getKey(), i.getValue());
        }
        this.charToFrequency = map;
    }
    public int getNumberOfAppearances(char c){
        if(Character.isLetter(c) && !Character.isLowerCase(c)){
            throw new IllegalArgumentException("Буква должна передаваться в нижнем регистре!");
        }
        if(!charToFrequency.containsKey(c)){
            return 0;
        }
        else{
            return charToFrequency.get(c);
        }
    }
}
