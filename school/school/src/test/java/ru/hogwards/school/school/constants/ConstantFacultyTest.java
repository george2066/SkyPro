package ru.hogwards.school.school.constants;

import org.json.JSONObject;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;

import java.util.*;

public class ConstantFacultyTest {
    public static JSONObject OBJECT = new JSONObject();

    public static Long NOT_EXIST_ID = 99L;
    public static Long ID_1 = 1L;
    public static Long ID_2 = 2L;
    public static Long ID_3 = 3L;
    public static Long ID_4 = 4L;

    public static String NAME_1 = "name_1";
    public static String NAME_2 = "name_2";
    public static String NAME_3 = "name_3";
    public static String NAME_4 = "name_4";

    public static String COLOR_1 = "color_1";
    public static String COLOR_2 = "color_2";
    public static String COLOR_3 = "color_3";
    public static String COLOR_4 = "color_4";

    public static final Faculty FACULTY_1 = new Faculty();
    public static final Faculty FACULTY_2 = new Faculty();
    public static final Faculty FACULTY_3 = new Faculty();
    public static final Faculty FACULTY_4 = new Faculty();

    public static List<Faculty> ALL_FACULTIES = Arrays.asList(
            FACULTY_1,
            FACULTY_2,
            FACULTY_3,
            FACULTY_4
    );
    public static Set<Long> ALL_STUDENTS = new HashSet<>(Arrays.asList(
            ConstantStudentTest.STUDENT_1.getId(),
            ConstantStudentTest.STUDENT_2.getId(),
            ConstantStudentTest.STUDENT_3.getId(),
            ConstantStudentTest.STUDENT_4.getId()
    ));


}
