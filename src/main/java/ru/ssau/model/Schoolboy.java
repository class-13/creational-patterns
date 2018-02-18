package ru.ssau.model;

import java.util.Arrays;

/**
 * Created by Вячеслав on 18.02.2018.
 */
public class Schoolboy implements Pupil {

    private String fio;
    private Register[] registers;

    public Schoolboy(String fio, int subjectsCount) {
        if (fio == null || fio.isEmpty() || subjectsCount < 0)
            throw new IllegalArgumentException();
        this.fio = fio;
        registers = new Register[subjectsCount];
        Arrays.fill(registers, new Register("N/A", 0));
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
        if (index < 0 || index >= registers.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        return registers[index].mark;
    }

    @Override
    public void setMark(int index, int mark) {
        if (index < 0 || index >= registers.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        if (mark < 1 || mark > 5)
            throw new IllegalArgumentException("Mark " + mark + " must be between 1 and 5!");
        registers[index].mark = mark;
    }

    @Override
    public String getSubject(int index) {
        if (index < 0 || index >= registers.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        return registers[index].subject;
    }

    @Override
    public void setSubject(int index, String subject) {
        if (index < 0 || index >= registers.length)
            throw new IllegalArgumentException("Index " + index + " must be between 0 and subject count!");
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Subject " + subject + " must not be null or empty!");
        registers[index].subject = subject;
    }

    @Override
    public void add(String subject, int mark) {
        if (mark < 1 || mark > 5)
            throw new IllegalArgumentException("Mark " + mark + " must be between 1 and 5!");
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException("Subject " + subject + " must not be null or empty!");
        registers = Arrays.copyOf(registers, registers.length + 1);
        registers[registers.length - 1] = new Register(subject, mark);
    }

    @Override
    public int size() {
        return registers.length;
    }

    @Override
    public Schoolboy clone() throws CloneNotSupportedException {
        Schoolboy clone = (Schoolboy) super.clone();
        clone.fio = this.fio;
        clone.registers = registers.clone();
        return clone;
    }

    private class Register implements Cloneable {
        private String subject;
        private int mark;

        Register(String subject, int mark) {
            this.subject = subject;
            this.mark = mark;
        }

        @Override
        protected Register clone() throws CloneNotSupportedException {
            Register clone = (Register) super.clone();
            clone.subject = this.subject;
            clone.mark = this.mark;
            return clone;
        }
    }
}
