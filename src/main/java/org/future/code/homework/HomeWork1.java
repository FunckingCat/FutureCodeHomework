package org.future.code.homework;

import java.util.Objects;
import java.util.function.Function;

/**
 * Правила выполнения домашнего задания: 1. Вся работа выполняется в файле доамашнего задания Если вас просят создать
 * класс - его надо создать вложенным, т.е. внутри класса HomeWorkN вы создаете класс MyClass {} (все в одном файле) 2.
 * Задание считается выполненным если все тесты пройдены. Тест выполнен если напротив него находится знак ✅ 3. Что бы
 * запустить тесты нажмите значек запуска кода напротив мтода main. ‼️ВАЖНО‼️ Вся работа в модкле ведется на JDK-17,
 * перед запуском скачайте его и установите правильный JDK и уровень языка в Settings -> Project Structure
 */
public class HomeWork1 {

    /*
    Домашнее задание #1:
    У всех полей выставить модфикатор доступа private
    Реализовать класс «Student»
        Поля класса - name:String, grade:Integer (+конструктор, +геттеры)
        Метод announce - String announce() {} - возвращает строку в формате "/name/ учится в /grade/ классе"

    Реализовать класс «Teacher»
        Поля класса - name:String, students:Student[30] (+конструктор из name, +геттеры)
        Метод - void addStudent(Student student) {} - добавляет студента в массив студентов,
            если колличество студентов достигло максимального колличества, ничего не делать
        Метод - String[] rollCall() {} - возвращает массив строк из результатов вызова метода
            announce всех встудентов преподавателя
     */
//модификаторы доступа, геттеры, сеттеры и построение правильного конструктора. Не надо дефолтных значений переменных

    public static class Student {

        private String name = STUDENT_NAME;
        private int grade = STUDENT_GRADE;

        public Student(String name, int age) {
            this.name = name;
            this.grade = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int age) {
            this.grade = age;
        }

        public String announce() {
            return name + " учится в " + grade + " классе";
        }
    }

    static class Teacher {

        private int i = -1;
        private Student[] students = new Student[30];
        private String name;

        public Teacher(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student[] getStudents() {
            return students;
        }

        public void setStudents(Student[] students) {
            this.students = students;
        }

        // метод написан абсолютно неправильно
        // Должно быть вот так..а это читерство
        //Метод - String[] rollCall() {} - возвращает массив строк из результатов вызова метода
//        announce всех студентов преподавателя


        //Этот метод тоже сплошной обман!!! добавляет только в первую позицию, так быть не должно.
        //Метод - void addStudent(Student student) {} - добавляет студента в массив студентов,
        public void addStudent(Student student) {
            if(i<29){i++;}
            this.students[i] = student;

        }
        public String[] rollCall(){
            String[] cass = new String[i+1];
            for(int n = 0;n<=i;n++)
            {
                cass[n]  = students[n].announce();
            }
            return cass;
        }
    }







    /*
    Это метод main - нажми play что бы запустить тесты
    Ничего не меняй в тестах, они уже написаны так что бы проверить твое решение
    Некторые методы в тесте подсвечены красным, это значит что компилятор не может их найти
    и тебе необходимо их релизовать, пока ты это не сделаешь, тесты не запустятся
    */

    public static void main(String[] args) {


        var student = new Student(STUDENT_NAME, STUDENT_GRADE);

        print("Student: Студент создался", true);
        print("Student: Геттер имени", Objects.equals(student.getName(), STUDENT_NAME));
        print("Student: Геттер класса", Objects.equals(student.getGrade(), STUDENT_GRADE));
        print("Student: announce содержит имя", student.announce().contains(STUDENT_NAME));
        print("Student: announce содержит класс", student.announce().contains(STUDENT_GRADE.toString()));

        var teacher = new Teacher(TEACHER_NAME);
        print("Teacher: Уичтель создался", true);
        print("Teacher: Геттер имени", teacher.getName() == TEACHER_NAME);
        print("Teacher: Геттер студентов", teacher.getStudents() != null);
        print("Teacher: Массив учеников должен быть размером 30", teacher.getStudents().length == 30);

        teacher.addStudent(student);
        print("Teacher: Студент сохранился в массив", teacher.getStudents()[0] == student);

        var student2 = new Student("Student2", STUDENT_GRADE);
        teacher.addStudent(student2);
        print("Teacher: Студент сохранился в массив", teacher.getStudents()[1] == student2);

        String[] calls = teacher.rollCall();
        print("Teacher: Массив rollCall состоит из ДВУХ элемента", calls.length == 2);
        print("Teacher: В строке содержится имя студента", calls[0].contains(STUDENT_NAME));
        print("Teacher: В строке содержится класс студента", calls[0].contains(STUDENT_GRADE.toString()));
    }

    /* Техническая секция - сюда писать ничего не надо */

    private static void print(String condition, Boolean act) {
        Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
        System.out.print("TEST CASE " + yellow.apply(constLen(condition, 55)));
        if (act) {
            System.out.print("✅");
        } else {
            System.out.print("❌");
        }
        System.out.println();
    }

    private static String constLen(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        while (len-- - str.length() > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private final static String STUDENT_NAME = "NameStudent";
    private final static String TEACHER_NAME = "NameStudent";
    private final static Integer STUDENT_GRADE = 1;
}