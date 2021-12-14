import java.util.LinkedList;

public class Student extends Grade
{
    public LinkedList<Semester> list;

    public Student(String name)
    {
        super(name);
        this.list = new LinkedList<>();
    }

    @Override
    public void setGrade()
    {
        double sum = 0;

        for (Semester semester: list)
        {
            sum += semester.grade;
        }

        if(listSize != 0)
            sum = sum / listSize;

        setGrade(sum);
    }

    @Override
    public void printList()
    {
        for (int i = 0; i < listSize; i++)
        {
            System.out.println((i + 1) + ".- " + list.get(i).name);
        }
    }
    public Semester getElement()
    {
        int opcion;
        printList();
        opcion = scan.nextInt() - 1;
        return list.get(opcion);
    }

    @Override
    public void addListElement()
    {
        listSize++;
        Semester semester = new Semester("Semestre " + listSize);
        list.add(semester);
    }

    public void setGPA()
    {
        for (Semester semester: list)
        {
            setSemGrade(semester);
        }
        this.setGrade();
    }

    public void setSemGrade(Semester semester)
    {
        for (Subject subject: semester.list)
        {
            subject.setGrade();
        }
        semester.setGrade();
    }

    @Override
    public void printClass()
    {
        System.out.println("Student: " + name);
        System.out.println("GPA: " + grade);

        for (Semester semester : list)
        {
            printSemester(semester);
        }
    }

    public void printSemester(Semester semester)
    {
        semester.printClass();

        for (Subject subject: semester.list)
        {
            printSubject(subject);
        }
    }

    public void printSubject(Subject subject)
    {
        subject.printClass();

        for (Element element: subject.list)
        {
            element.printClass();
        }

    }
}
