package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                count++;
            }
        }
        return count == 0 ? 0 : totalScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            int count = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            labels.add(new Label(pupil.name(), totalScore / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> totalScores = new HashMap<>();
        Map<String, Integer> countScores = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores.put(subject.name(),
                        totalScores.getOrDefault(subject.name(), 0) + subject.score());
                countScores.put(subject.name(),
                        countScores.getOrDefault(subject.name(), 0) + 1);
            }
        }

        List<Label> labels = new ArrayList<>();
        for (String subject : totalScores.keySet()) {
            labels.add(new Label(subject, (double) totalScores.get(subject) / countScores.get(subject)));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        double maxScore = 0;

        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            if (totalScore > maxScore) {
                maxScore = totalScore;
                best = new Label(pupil.name(), totalScore);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> totalScores = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores.put(subject.name(),
                        totalScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        Label best = null;
        int maxScore = 0;
        for (Map.Entry<String, Integer> entry : totalScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                best = new Label(entry.getKey(), entry.getValue());
            }
        }
        return best;
    }
}
