package ru.ssau.model;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public interface PupilFactory {
    Pupil createInstance(String fio, int subjectCount);
}
