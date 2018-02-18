package ru.ssau;

import org.junit.Assert;
import org.junit.Test;
import ru.ssau.model.Pupil;
import ru.ssau.model.Pupils;
import ru.ssau.model.Schoolboy;
import ru.ssau.model.Student;

import static java.lang.System.out;
/**
 * Created by Вячеслав on 18.02.2018.
 */
public class PrototypeTest extends Assert {

    @Test
    public void prototypeStudentTest() throws CloneNotSupportedException {
        Pupil originStudent = new Student("Иванов И.И.", 3);

        originStudent.setMark(0, 4);
        originStudent.setMark(1, 5);
        originStudent.setMark(2, 3);
        originStudent.setSubject(0, "Право");
        originStudent.setSubject(1, "Философия");
        originStudent.setSubject(2, "История");
        out.println("Оригинальный студент");
        Pupils.printInfo(originStudent);

        Pupil cloneStudent = originStudent.clone();
        out.println("Клонируем студента");

        assertNotEquals(originStudent, cloneStudent);

        out.println("Меняем состояние оригинального студента");
        originStudent.setMark(1, 4);
        originStudent.setSubject(2, "Английский язык");
        cloneStudent.setFio("Макаров И.М.");

        out.println("Оригинальный студент с измененным состоянием");
        Pupils.printInfo(originStudent);
        out.println("Клонированный студент (состояние клонированного объекта не изменилось после изменения оригинала)");
        Pupils.printInfo(cloneStudent);

        assertNotEquals(originStudent.getMark(1), cloneStudent.getMark(1));
        assertNotEquals(originStudent.getSubject(2), cloneStudent.getSubject(2));
    }

    @Test
    public void prototypeSchoolboyTest() throws CloneNotSupportedException {
        Pupil originSchoolboy = new Schoolboy("Сидоров С.С.", 3);

        originSchoolboy.setMark(0, 5);
        originSchoolboy.setMark(1, 5);
        originSchoolboy.setMark(2, 5);
        originSchoolboy.setSubject(0, "Алегбра");
        originSchoolboy.setSubject(1, "Геометрия");
        originSchoolboy.setSubject(2, "Информатика");
        out.println("Оригинальный школьник");
        Pupils.printInfo(originSchoolboy);

        Pupil cloneSchoolboy = originSchoolboy.clone();
        out.println("Клонируем школьника");

        assertNotEquals(originSchoolboy, cloneSchoolboy);

        out.println("Меняем состояние оригинального школьника");
        originSchoolboy.setMark(1, 4);
        originSchoolboy.setSubject(2, "Физкультура");

        out.println("Оригинальный школьник с измененным состоянием");
        Pupils.printInfo(originSchoolboy);
        out.println("Клонированный школьник (состояние клонированного объекта не изменилось после изменения оригинала)");
        Pupils.printInfo(cloneSchoolboy);

        assertNotEquals(originSchoolboy.getMark(1), cloneSchoolboy.getMark(1));
        assertNotEquals(originSchoolboy.getSubject(2), cloneSchoolboy.getSubject(2));
    }
}
