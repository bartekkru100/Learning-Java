public class Student extends User
{
    public String major;

    @Override
    public void sayHello()
    {
        System.out.println("Hello I'm " + getFulName() + " my major is " + major);
    }
}
