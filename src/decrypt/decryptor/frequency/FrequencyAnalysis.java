package decrypt.decryptor.frequency;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {

    private FrequencyAnalysis() {
    }

    public static FrequencyAnalysisResult computeCharacterFrequencies(String data) {
        if(data == null){
            throw new IllegalArgumentException("Строка не может быть null");
        }
        Map<Character, Integer> result = new HashMap<>();
        for(int i = 0; i < data.length(); ++i){
            char current = data.charAt(i);
            if(Character.isLetter(current)){
                current = Character.toLowerCase(current);
            }
            Integer currentInt = result.get(current);
            if(currentInt == null){
                result.put(current, 1);
            }
            else{
                result.put(current, currentInt + 1);
            }

        }
        return new FrequencyAnalysisResult(result);
}}
