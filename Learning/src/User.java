public abstract class User implements Talk
{
    public String firstName;
    public String lastName;
    public int age;
    public boolean isVerified = false;
    public enum status{ACTIVE, INACTIVE, PROBATION};
    public status status = this.status.PROBATION;
    public void sayHello()
    {
        System.out.println("Hello my name is " + getFulName());
    }
    public String getFulName()
    {
        return firstName + " " + lastName;
    }
}
