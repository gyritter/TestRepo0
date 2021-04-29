import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getIndexesOfChar(String name, char x){
       List <Integer>result=new ArrayList<>();
        for(int i=0; i<name.length(); i++){
            if (name.charAt(i)==x){
                result.add(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Search search= new Search();
        System.out.println(search.getIndexesOfChar("almafa",'a'));

    }
}
