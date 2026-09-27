package decrypt.substitutor;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Substitutor {
    private final Map<Character, Character> substitutionsMap;

    public Substitutor(List<Substitution> substitutions){
        if(substitutions == null){
            throw new IllegalArgumentException("Список не может быть null!");
        }
        Map<Character, Character> substitutionsMapRaw = new HashMap<>();
        for(Substitution substitution: substitutions){
            if(substitution == null){
                throw new IllegalArgumentException("В списке замен не может быть null!");
            }
            if(substitutionsMapRaw.containsKey(substitution.getOldLetter())){
                throw new IllegalArgumentException("В списке не могут присутсвовать дубликаты среди oldLetter!");
            }
            substitutionsMapRaw.put(substitution.getOldLetter(), substitution.getNewLetter());
        }
        this.substitutionsMap = substitutionsMapRaw;
    }
    public String substitute(String data){
        if(data == null){
            throw new IllegalArgumentException("Строка не может быть null!");
        }
        String result = "";
        for(int i = 0; i < data.length(); ++i){
            char oldCurrent = data.charAt(i);
            char lowerOldCurrent = Character.toLowerCase(oldCurrent);
            if(substitutionsMap.containsKey(lowerOldCurrent)){
                char newCurrent = substitutionsMap.get(lowerOldCurrent);
                if(Character.isUpperCase(oldCurrent)){
                    result += Character.toUpperCase(newCurrent);
                }
                else{
                    result += newCurrent;

                }
            }
            else{
                result += oldCurrent;
            }

        }
        return result;
    }
}
