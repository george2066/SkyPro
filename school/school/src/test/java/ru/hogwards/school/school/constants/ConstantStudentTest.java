package ru.hogwards.school.school.constants;

import org.json.JSONObject;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;

import java.util.Arrays;
import java.util.List;

public class ConstantStudentTest {
    public static Long NOT_EXIST_ID = 5L;
    public static Long       ID_1 = 1L;
    public static Long       ID_2 = 2L;
    public static Long       ID_3 = 3L;
    public static Long       ID_4 = 4L;
    public static Long       ID_5 = 5L;
    public static Long       ID_6 = 6L;
    public static Long       ID_START_A_7 = 7L;
    public static Long       ID_START_A_8 = 8L;
    public static Long       ID_START_A_9 = 9L;

    public static String     NAME_1 = "name1";
    public static String     NAME_2 = "name2";
    public static String     NAME_3 = "name3";
    public static String     NAME_4 = "name4";
    public static String     NAME_5 = "name5";
    public static String     NAME_6 = "name6";
    public static String     NAME_START_A_7 = "A_name7";
    public static String     NAME_START_A_8 = "A_name8";
    public static String     NAME_START_A_9 = "A_name9";

    public static Integer    AGE_1 = 21;
    public static Integer    AGE_2 = 22;
    public static Integer    AGE_3 = 33;
    public static Integer    AGE_4 = 44;
    public static Integer    AGE_5 = 55;
    public static Integer    AGE_6 = 66;
    public static Integer    AGE_START_A_7 = 77;
    public static Integer    AGE_START_A_8 = 88;
    public static Integer    AGE_START_A_9 = 99;

    public static String COLOR = "color";

    public static Student    STUDENT_1 = new Student();
    public static Student    STUDENT_2 = new Student();
    public static Student    STUDENT_3 = new Student();
    public static Student    STUDENT_4 = new Student();
    public static Student    STUDENT_5 = new Student();
    public static Student    STUDENT_6 = new Student();
    public static Student    STUDENT_START_A_7 = new Student();
    public static Student    STUDENT_START_A_8 = new Student();
    public static Student    STUDENT_START_A_9 = new Student();

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

    public static List<Student> LAST_FIVE_STUDENTS = Arrays.asList(
            STUDENT_2,
            STUDENT_3,
            STUDENT_4,
            STUDENT_5,
            STUDENT_6
    );

    public static List<Student> PAGINATION_STUDENTS = Arrays.asList(
            STUDENT_1,
            STUDENT_2
    );

    public static List<Student> STUDENTS_START_A = Arrays.asList(
            STUDENT_START_A_7,
            STUDENT_START_A_8,
            STUDENT_START_A_9
    );
}
