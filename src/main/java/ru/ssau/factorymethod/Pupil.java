package ru.ssau.factorymethod;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public interface Pupil {
    String getFio();
    void setFio(String fio);
    int getMark(int index);
    void setMark(int index, int mark);
    String getSubject(int index);
    void setSubject(int index, String subject);
    void addMark(int mark);
    void addSubject(String subject);
    int size();
}
