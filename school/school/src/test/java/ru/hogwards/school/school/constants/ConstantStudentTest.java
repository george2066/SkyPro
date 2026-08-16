package ru.hogwards.school.school.constants;

import org.json.JSONObject;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;

import java.util.Arrays;
import java.util.List;

public class ConstantStudentTest {
    public static Long       ID_1 = 1L;
    public static String     NAME_1 = "name1";
    public static Integer    AGE_1 = 21;

    public static Long       ID_2 = 2L;
    public static String     NAME_2 = "name2";
    public static Integer    AGE_2 = 22;

    public static Long       ID_3 = 3L;
    public static String     NAME_3 = "name3";
    public static Integer    AGE_3 = 33;

    public static Long       ID_4 = 4L;
    public static String     NAME_4 = "name4";
    public static Integer    AGE_4 = 44;

    public static String COLOR = "color";

    public static Student    STUDENT_1 = new Student();
    public static Student    STUDENT_2 = new Student();
    public static Student    STUDENT_3 = new Student();
    public static Student    STUDENT_4 = new Student();

    public static JSONObject OBJECT = new JSONObject();

    public static Integer MIN = 30;
    public static Integer MAX = 45;

    public static List<Student> ALL_STUDENTS = Arrays.asList(
            STUDENT_1,
            STUDENT_2,
            STUDENT_3,
            STUDENT_4
    );
    public static List<Student> STUDENTS_AGE_BETWEEN = Arrays.asList(
            STUDENT_3,
            STUDENT_4
    );
}
