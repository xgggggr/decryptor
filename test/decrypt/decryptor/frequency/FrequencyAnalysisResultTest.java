package decrypt.decryptor.frequency;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyAnalysisResultTest {
    @Test
    void constructor_nullTest(){
        assertThrows(IllegalArgumentException.class, () -> new FrequencyAnalysisResult(null));

    }
    @Test
    void constructor_uppercaseTest(){
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 67);
        assertThrows(IllegalArgumentException.class, () ->new FrequencyAnalysisResult(map));
    }
    @Test
    void getNumberOfAppearances_Test(){
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 67);
        FrequencyAnalysisResult result = new FrequencyAnalysisResult(map);
        assertEquals(67, result.getNumberOfAppearances('a'));
    }
    @Test
    void getNumberOfAppearances_noAppearing(){
        FrequencyAnalysisResult result = new FrequencyAnalysisResult(new HashMap<>());
        assertEquals(0, result.getNumberOfAppearances('a'));

    }
    @Test
    void getNumberOfAppearances_uppercase(){
        FrequencyAnalysisResult result = new FrequencyAnalysisResult(new HashMap<>());
        assertThrows(IllegalArgumentException.class, () -> result.getNumberOfAppearances('A'));
    }
}