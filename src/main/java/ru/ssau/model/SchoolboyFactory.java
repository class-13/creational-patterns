package ru.ssau.model;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public class SchoolboyFactory implements PupilFactory {
    @Override
    public Pupil createInstance(String fio, int subjectCount) {
        return new Schoolboy(fio, subjectCount);
    }
}
