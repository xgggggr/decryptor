package decrypt.decryptor.rot;

import decrypt.decryptor.Decryptor;
import decrypt.substitutor.Substitution;
import decrypt.vocabulary.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class RotNDecryptor implements Decryptor {
    private final int n;
    private final Vocabulary vocabulary;
    public RotNDecryptor(int n, Vocabulary vocabulary){
        if(vocabulary == null){
            throw new IllegalArgumentException("Алфавит не может быть null");
        }
        this.n =n;
        this.vocabulary = vocabulary;
    }
    @Override
    public List<Substitution> decrypt(String data){
        if(data == null){
            throw new IllegalArgumentException("строка не может быть null");
        }
        int len = vocabulary.getTotalLetters();
        List<Substitution> result = new ArrayList<>(len);
        for(int i = 0; i < len; ++i){
            int newIndex = goodIndex(i + n, len);
            Substitution current = new Substitution(vocabulary.getLetterByIndex(i), vocabulary.getLetterByIndex(newIndex));
            result.add(current);
        }
        return result;
    }
    private int goodIndex(int index, int len){
        int result = index%len;
        if(result < 0){
            result += len;
        }
        return result;

    }
}
