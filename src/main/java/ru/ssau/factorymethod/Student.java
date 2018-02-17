package ru.ssau.factorymethod;

import java.util.Arrays;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public class Student implements Pupil {

    private String fio;
    private String[] subjects;
    private int[] marks;

    public Student(String fio, int subjectCount) {
        this.fio = fio;
        subjects = new String[subjectCount];
        marks = new int[subjectCount];
        Arrays.fill(subjects, "");
        Arrays.fill(marks, 0);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getMark(int index) {
        if (index < 0 || index >= marks.length)
            throw new IllegalArgumentException();
        return marks[index];
    }

    public void setMark(int index, int mark) {
        if (index < 0 || index >= marks.length || mark < 1 || mark > 5)
            throw new IllegalArgumentException();
        marks[index] = mark;
    }

    public String getSubject(int index) {
        if (index < 0 || index >= subjects.length)
            throw new IllegalArgumentException();
        return subjects[index];
    }

    public void setSubject(int index, String subject) {
        if (index < 0 || index >= subjects.length || subject == null || subject.isEmpty())
            throw new IllegalArgumentException();
        subjects[index] = subject;
    }

    public void addMark(int mark) {
        if (mark < 1 || mark > 5)
            throw new IllegalArgumentException();
        marks = Arrays.copyOf(marks, marks.length + 1);
        marks[marks.length - 1] = mark;
    }

    public void addSubject(String subject) {
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException();
        subjects = Arrays.copyOf(subjects, subjects.length + 1);
        subjects[subjects.length - 1] = subject;
    }

    public int size() {
        return subjects.length;
    }
}
