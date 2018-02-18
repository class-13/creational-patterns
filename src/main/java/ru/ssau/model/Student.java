package ru.ssau.model;

import java.util.Arrays;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public class Student implements Pupil {

    private String fio;
    private String[] subjects;
    private int[] marks;

    public Student(String fio, int subjectsCount) {
        if (fio == null || fio.isEmpty() || subjectsCount < 0)
            throw new IllegalArgumentException();
        this.fio = fio;
        subjects = new String[subjectsCount];
        marks = new int[subjectsCount];
        Arrays.fill(subjects, "N/A");
        Arrays.fill(marks, 0);
    }

    @Override
    public String getFio() {
        return fio;
    }

    @Override
    public void setFio(String fio) {
        if (fio == null || fio.isEmpty())
            throw new IllegalArgumentException("FIO " + fio + " must not be null or empty!");
        this.fio = fio;
    }

    @Override
    public int getMark(int index) {
        if (index < 0 || index >= marks.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        return marks[index];
    }

    @Override
    public void setMark(int index, int mark) {
        if (index < 0 || index >= marks.length )
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        if (mark < 1 || mark > 5)
            throw new IllegalArgumentException("Mark " + mark + " must be between 1 and 5!");
        marks[index] = mark;
    }

    @Override
    public String getSubject(int index) {
        if (index < 0 || index >= subjects.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        return subjects[index];
    }

    @Override
    public void setSubject(int index, String subject) {
        if (index < 0 || index >= subjects.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Subject " + subject + " must not be null or empty!");
        subjects[index] = subject;
    }

    @Override
    public void add(String subject, int mark) {
        if (mark < 1 || mark > 5)
            throw new IllegalArgumentException("Mark " + mark + " must be between 1 and 5!");
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Subject " + subject + " must not be null or empty!");
        marks = Arrays.copyOf(marks, marks.length + 1);
        subjects = Arrays.copyOf(subjects, subjects.length + 1);
        marks[marks.length - 1] = mark;
        subjects[subjects.length - 1] = subject;
    }

    @Override
    public int size() {
        return subjects.length;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.fio = this.fio;
        clone.marks = this.marks.clone();
        clone.subjects = this.subjects.clone();
        return clone;
    }
}
