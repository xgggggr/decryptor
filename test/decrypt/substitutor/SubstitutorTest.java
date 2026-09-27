package decrypt.substitutor;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutorTest {
    @Test
    void constructor_nullList(){
        assertThrows(IllegalArgumentException.class, () -> new Substitutor(null));
    }
    @Test
    void constructor_nullElement(){
        List<Substitution> s = new ArrayList<>();
        s.add(null);
        assertThrows(IllegalArgumentException.class, () -> new Substitutor(s));
    }
    @Test
    void constructor_LetterRepeats(){
        List<Substitution> s = new ArrayList<>();
        s.add(new Substitution('a', 'b'));
        s.add(new Substitution('a', 'c'));
        assertThrows(IllegalArgumentException.class, () -> new Substitutor(s));
    }
    @Test
    void substitute_nullData(){
        List<Substitution> s = new ArrayList<>();
        s.add(new Substitution('a', 'b'));
        Substitutor sub = new Substitutor(s);
        assertThrows(IllegalArgumentException.class, () -> sub.substitute(null));
    }
    @Test
    void substitute_Test(){
        List<Substitution> s = new ArrayList<>();
        s.add(new Substitution('b', 'c'));
        s.add(new Substitution('c', 'b'));
        Substitutor sub = new Substitutor(s);
        assertEquals("ac!Cb", sub.substitute("ab!Bc"));
    }
    @Test
    void substitute_emptyStringTest(){
        List<Substitution> s = new ArrayList<>();
        s.add(new Substitution('b', 'c'));
        s.add(new Substitution('c', 'b'));
        Substitutor sub = new Substitutor(s);
        assertEquals("", sub.substitute(""));
    }
    @Test
    void substitute_uppercaseToUppercase(){
        List<Substitution> s = new ArrayList<>();
        s.add(new Substitution('b', 'c'));
        Substitutor sub = new Substitutor(s);
        assertEquals("C", sub.substitute("B"));
    }

}