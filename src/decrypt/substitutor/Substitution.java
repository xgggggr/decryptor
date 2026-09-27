package decrypt.substitutor;

    public class Substitution {
        private final char oldLetter;
        private final char newLetter;
        public Substitution(char oldLetter, char newLetter){
            if(!Character.isLowerCase(oldLetter)){
                throw new IllegalArgumentException();
            }
            if(!Character.isLowerCase(newLetter)) {
                throw new IllegalArgumentException();
            }
            this.newLetter = newLetter;
            this.oldLetter = oldLetter;
            }
        public char getOldLetter(){
            return oldLetter;
        }
        public char getNewLetter(){
            return newLetter;
        }
        }

