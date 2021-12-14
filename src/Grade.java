public class Grade implements GradeMethods
{
    public String name;
    public int listSize;
    public double grade;

    public Grade(String name)
    {
        this.name = name;
        this.grade = 0;
        this.listSize = 0;
    }

    @Override
    public void setGrade(){};

    @Override
    public void setGrade(double f)
    {
        this.grade = f;
    }

    @Override
    public double getGrade()
    {
        return this.grade;
    }

    @Override
    public void setListSize(){}

    @Override
    public void addListElement() {}

    @Override
    public void printList() {}

    @Override
    public void printClass() {

    }
}
