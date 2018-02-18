package ru.ssau.model;

/**
 * Created by Вячеслав on 18.02.2018.
 */

public class Pupils {

    private static PupilFactory factory = new StudentFactory();

    private Pupils() {

    }

    public static double averageMark(Pupil pupil) {
        double sum = 0.0;
        for (int i = 0; i < pupil.size(); i++)
            sum += pupil.getMark(i);
        return sum / pupil.size();
    }

    public static void printInfo(Pupil pupil) {
        System.out.println(pupil.getFio());
        for (int i = 0; i < pupil.size(); i++)
            System.out.println(pupil.getSubject(i) + " " + pupil.getMark(i));
        System.out.println();
    }

    public static void setPupilFactory(PupilFactory factory) {
        Pupils.factory = factory;
    }

    public static Pupil createInstance(String fio, int subjectCount) {
        return factory.createInstance(fio, subjectCount);
    }
}
