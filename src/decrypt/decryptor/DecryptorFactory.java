package decrypt.decryptor;

import decrypt.decryptor.frequency.FrequencyDecryptor;
import decrypt.decryptor.rot.RotNDecryptor;
import decrypt.vocabulary.Vocabulary;

public class DecryptorFactory {
    private DecryptorFactory() {
    }

    public static Decryptor create(String decryptorName, Vocabulary vocabulary) {
        if(decryptorName == null){
            throw new IllegalArgumentException("название дешифроватора не может быть null");
        }
        if(vocabulary == null){
            throw new IllegalArgumentException("Алфавит не  может быть null");
        }
        if(decryptorName.equals("FREQ")){
            return new FrequencyDecryptor(vocabulary);

        }
        if(decryptorName.startsWith("ROT")){
            String nStr = decryptorName.substring(3);
            int n = CheckingN(nStr);
            return new RotNDecryptor(n, vocabulary);

        }
        throw new IllegalArgumentException("Дешифроватор может быть только FREQ или ROTn, где n - любое число типа int");
    }
    public static int CheckingN(String nStr){
        try{
            return Integer.parseInt(nStr);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Некорректное значение сдвига!", e);
        }

    }
}
