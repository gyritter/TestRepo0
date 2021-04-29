package quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class QuizManager {
    private List<Question> questions= new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    private void readLines (BufferedReader reader) throws IOException {
        String line;
        String question;
        while ((line = reader.readLine())  != null) {
            question=line;
            line=reader.readLine();
            addQuestionToList(question, line);
        }
    }
    private void addQuestionToList(String question, String line){
        String [] div= line.split(" ");
        questions.add(new Question(question, div[0], Integer.parseInt(div[1]), div[2]));
    }


    public void readFile(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filename))) {
            System.out.println(filename);
            readLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
    public List <String> getAllQuestionsByTopic (String topic){
        List <String> result=new ArrayList<>();
        for(Question q:questions){
            if(q.getCategory().equals(topic)){
                result.add(q.getQuestion());
            }
        }
        return  result;
    }

    public Question getRandomQuestion (){
        Random rnd= new Random();
      return questions.get(rnd.nextInt(questions.size()));
    }

    public Map<String, List<String>> getAllQuestionsByAllTopic(){
        HashMap<String, List<String>> result =new HashMap<>();
        String key;
        for (Question q: questions) {
            if (!result.containsKey(q.getCategory())) {
                result.put(q.getCategory(), new ArrayList<String>());
            }
           result.get(q.getCategory()).add(q.getQuestion());
        }
        return result;
    }

    public String getHighestTopicbyScore (){

        HashMap<String, Integer> result =new HashMap<>();
        for (Question q: questions) {
            if (!result.containsKey(q.getCategory())) {
                result.put(q.getCategory(), 0);
            }
            result.put(q.getCategory(),result.get(q.getCategory())+q.getScore());
        }
        int max =0;
        String subject="";

        for (Map.Entry entry: result.entrySet()) {
            if ((int)entry.getValue()>max){
                System.out.println(entry);
                max=(int)entry.getValue();
                subject=entry.getKey().toString();
            }
        }
        return subject;
    }



    public static void main(String[] args) {
        QuizManager quizManager= new QuizManager();
        quizManager.readFile("kerdesek.txt");
       // System.out.println(quizManager.getQuestions());
        //System.out.println(quizManager.getAllQuestionsByTopic("foldrajz"));
       // System.out.println(quizManager.getRandomQuestion());
        System.out.println(quizManager.getHighestTopicbyScore());

    }



}
