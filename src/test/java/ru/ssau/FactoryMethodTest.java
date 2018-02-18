package ru.ssau;

import org.junit.Assert;
import org.junit.Test;
import ru.ssau.model.*;

import static java.lang.System.out;
/**
 * Created by Вячеслав on 18.02.2018.
 */
public class FactoryMethodTest extends Assert {

    @Test
    public void averageMarkTest() {
        out.println("Тестируем вычисление среднего арифметического\n");
        Pupil student = new Student("Иванов И.И.", 0);
        Pupil schoolboy = new Schoolboy("Макаров В.В.", 0);

        student.add("Информатика", 5);
        student.add("Физика", 3);
        student.add("Право", 4);
        student.add("Философия", 3);
        Pupils.printInfo(student);
        out.println("Средняя оценка студента: " + Pupils.averageMark(student) + "\n");
        assertEquals((5 + 3 + 4 + 3) / 4.0, Pupils.averageMark(student), 0.0);

        schoolboy.add("Русский язык", 4);
        schoolboy.add("Алгебра", 4);
        schoolboy.add("Геометрия", 3);
        schoolboy.add("Физкультура", 5);
        Pupils.printInfo(schoolboy);
        out.println("Средняя оценка школьника: " + Pupils.averageMark(schoolboy));
        assertEquals((4 + 4 + 3 + 5) / 4.0, Pupils.averageMark(schoolboy), 0.0);
    }

    @Test
    public void factoryMethodTest() {
        out.println("\nТестируем работу фабричного метода\n");
        out.println("Инстанцируем студента");
        Pupil student = Pupils.createInstance("Иванов И.И.", 3);
        out.println(student.getClass().getName());
        assertTrue(student instanceof Student);

        out.println("\nИнстанцируем школьника");
        Pupils.setPupilFactory(new SchoolboyFactory());
        Pupil schoolboy = Pupils.createInstance("Сидоров В.В.", 3);
        out.println(schoolboy.getClass().getName());
        assertTrue(schoolboy instanceof Schoolboy);
    }
}
