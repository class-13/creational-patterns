package ru.ssau.model;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public interface Pupil extends Cloneable {
    String getFio();
    void setFio(String fio);
    int getMark(int index);
    void setMark(int index, int mark);
    String getSubject(int index);
    void setSubject(int index, String subject);
    void add(String subject, int mark);
    int size();
}
