import java.util.ArrayList;
import java.util.List;
public class Dictionary {

    private  List<String>  words ;
    private  List<String>  customizeWords;
    private  int mode;

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void setCustomizeWords(List<String> customizeWords) {
        this.customizeWords = customizeWords;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public ArrayList<String> getDictionaryWords( )
    {
        ArrayList<String> result = new ArrayList<String>();
         if(mode == 3)// stage 3
         {
            result.addAll(words);
            result.addAll(customizeWords);
         }
         else if(mode == 2)// stage 2
         {
             result.addAll(customizeWords);
         }
         else//stage 1
         {
             result.addAll(words);
         }
         return result;

    }
}
