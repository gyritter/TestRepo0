import java.util.List;

public class ListCounter {

    public int ACounter (List<String> input){
        int count=0;
        for (String s:input){
            if(s.toLowerCase().startsWith("a")){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ListCounter listCounter= new ListCounter();
        System.out.println(listCounter.ACounter(List.of("Aggódik", "Elment", "apáca", "útravaló")));

    }
}
