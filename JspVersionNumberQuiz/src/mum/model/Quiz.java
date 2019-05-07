package mum.model;

public class Quiz {
    private static String[] questions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 4, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };
    private static int[] answers = {9, 8, 36, 13, 32};

    private int currentQuestion = -1;
    private int score = 0;
    private int answerTimes = 0;

    public String getNextQuestion() {
        if (currentQuestion > questions.length - 1) {
            return null;
        }
        if (answerTimes > 0 && answerTimes < 3) {
            // Case wrong answer but can try again.
            return questions[currentQuestion];
        }
        return questions[++currentQuestion];
    }

    public String getCorrectAnswerOfPrevQuestion() {
        if (answerTimes >= 3) {
            answerTimes = 0;
            return "The answer of previous question (" + questions[currentQuestion] + ") is " + answers[currentQuestion];
        }
        return "";
    }

    public void checkAnswer(String answer) {
        if (currentQuestion < 0 || currentQuestion > answers.length - 1) {
            return;
        }
        if (String.valueOf(answers[currentQuestion]).equals(answer)) {
            if (answerTimes == 0) {
                score += 10;
            } else if (answerTimes == 1) {
                score += 5;
            } else if(answerTimes == 2) {
                score += 2;
            }
            answerTimes = 0;
        } else {
            answerTimes++;
        }
    }

    public boolean hasNextQuestion() {
        return currentQuestion < questions.length - 1 || currentQuestion == questions.length -1 && answerTimes > 0 && answerTimes < 3;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        if (score >= 45 && score <= 50) {
            return "A";
        } else if (score >= 35 && score <= 44) {
            return "B";
        } else if (score >= 25 && score <= 34) {
            return "C";
        }
        return "NC";
    }

}
