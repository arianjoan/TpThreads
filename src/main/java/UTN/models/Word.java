package UTN.models;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private List<Character> incomplete;
    private String word;

    public Word(String word){

        this.word = word.toUpperCase();
        incomplete = new ArrayList<Character>();

        for (int i=0 ; i < this.word.length() ; i++){
            incomplete.add('_');
        }
        this.addChar(word.charAt(0));

    }

    public boolean addChar (Character c){

        boolean attempt = false;

        c = Character.toUpperCase(c);

        int index = this.word.indexOf(c);
        int oldIndex = -1;

        if (index >= 0){
            while (oldIndex < index){
                this.incomplete.set(index,c);
                oldIndex = index;
                index = this.word.indexOf(c,oldIndex+1);
            }
            attempt = true;
        }

        return attempt;
    }

    public boolean isComplete(){

        if (incomplete.indexOf('_') >=0){
            return false;
        }else{
            return true;
        }

    }

    public String showCurrentWord (){
         return this.incomplete.toString();
    }

    public String getWord() {
        return word;
    }
}
