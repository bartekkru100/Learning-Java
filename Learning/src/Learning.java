import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Learning
{
    public static void main(String[] args)
    {
        Student me = new Student();
        me.firstName = "Bartek";
        me.lastName = "Kru";
        me.age = 69;
        me.major = "aerospace";

        Teacher teacher = new Teacher();
        teacher.firstName = "Tea";
        teacher.lastName = "Teachman";
        switch (me.status) {
            case ACTIVE:
                System.out.println(me.status + " - you're good");
                break;
            case INACTIVE:
                System.out.println(me.status + " - oof");
                break;
            case PROBATION:
                System.out.println(me.status + " - ouch");
                break;
            default:
                break;
        }
    }

}

