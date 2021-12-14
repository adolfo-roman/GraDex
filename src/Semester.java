import java.util.LinkedList;

public class Semester extends Grade
{
    public LinkedList<Subject> list;

    public Semester(String name)
    {
        super(name);
        this.list = new LinkedList<>();
    }

    @Override
    public void printList()
    {
        for (int i = 0; i < listSize; i++)
        {
            System.out.println((i + 1) + ".- " + list.get(i).name);
        }
    }

    public Subject getElement()
    {
        int opcion;
        printList();
        opcion = scan.nextInt() - 1;
        return list.get(opcion);
    }

    @Override
    public void addListElement()
    {
        int num;
        String name;

        System.out.print("Cuantas materias desea agregar?: ");

        num = scan.nextInt();

        for (int i = 0; i < num; i++)
        {
            System.out.print("Nombre materia: ");
            name = scan.useDelimiter("\n").nextLine();
            addListElement(name);
        }
    }

    public void addListElement(String name)
    {
        listSize++;
        Subject subject = new Subject(name);
        list.add(subject);
    }

    @Override
    public void setGrade()
    {
        double sum = 0;

        for (Subject subject: list)
        {
            sum += subject.grade;
        }

        if(listSize != 0)
            sum = sum / listSize;

        setGrade(sum);
    }

    @Override
    public void printClass()
    {
        System.out.println("\t" + name);
        System.out.println( "\tPromedio: " + grade);
    }
}
