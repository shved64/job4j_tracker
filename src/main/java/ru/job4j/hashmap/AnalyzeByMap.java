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
        return totalScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double totalScore = 0;
            int subjectCount = pupil.subjects().size();

            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double average = totalScore / subjectCount;
            labels.add(new Label(pupil.name(), average));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subject.score();
                subjectScores.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + score);
            }
        }
        List<Label> labels = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();
            int pupilCount = pupils.size();

            double average = (double) totalScore / pupilCount;

            labels.add(new Label(subjectName, average));

        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double totalScore = 0;

            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }

            labels.add(new Label(pupil.name(), totalScore));
        }

        labels.sort(Comparator.naturalOrder());

        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> labels = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            int totalScore = entry.getValue();

            labels.add(new Label(subjectName, totalScore));
        }
        labels.sort(Comparator.naturalOrder());

        return labels.get(labels.size() - 1);
    }
}
