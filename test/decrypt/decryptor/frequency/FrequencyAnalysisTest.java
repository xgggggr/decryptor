package decrypt.decryptor.frequency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyAnalysisTest {
    @Test
    void computeCharacterFrequencies_null(){
        assertThrows(IllegalArgumentException.class, () -> FrequencyAnalysis.computeCharacterFrequencies(null));
    }
    @Test
    void computeCharacterFrequencies_Test(){
        FrequencyAnalysisResult result = FrequencyAnalysis.computeCharacterFrequencies("ab!Bc");
        assertEquals(1, result.getNumberOfAppearances('a'));
        assertEquals(2, result.getNumberOfAppearances('b'));
        assertEquals(1, result.getNumberOfAppearances('c'));
        assertEquals(1, result.getNumberOfAppearances('!'));
    }
    @Test
    void computeCharacterFrequencies_emptyString(){
        FrequencyAnalysisResult result = FrequencyAnalysis.computeCharacterFrequencies("");
        assertEquals(0, result.getNumberOfAppearances('a'));
    }

}