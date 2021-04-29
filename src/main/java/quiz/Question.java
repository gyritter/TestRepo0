package quiz;

public class Question {
    private String question;
    private String answer;
    private int score;
    private String category;

    public Question(String question, String answer, int score, String category) {
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question +
                ", answer='" + answer +
                ", score=" + score +
                ", category='" + category +
                '}';
    }
}
