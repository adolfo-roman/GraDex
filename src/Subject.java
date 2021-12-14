import java.util.LinkedList;

public class Subject extends Grade
{
    public LinkedList<Element> list;
    public int mostElements;

    public Subject(String name)
    {
        super(name);
        this.mostElements = 0;
        this.list = new LinkedList<>();
    }

    public void setMostElements()
    {
        for (Element element : list)
        {
            if(element.listSize > mostElements)
            {
                mostElements = element.listSize;
            }
        }
    }

    @Override
    public void printList()
    {
        for (int i = 0; i < listSize; i++)
        {
            System.out.println((i + 1) + ".- " + list.get(i).name);
        }
    }

    public Element getElement()
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
        int percent;

        System.out.print("Cuantos elementos desea agregar?: ");

        num = scan.nextInt();

        for (int i = 0; i < num; i++)
        {
            System.out.print("Nombre elemento: ");
            name = scan.useDelimiter("\n").next();
            System.out.print("Porcentaje de Evaluacion: ");
            percent = scan.nextInt();

            addListELement(name, percent);
        }
    }

    public void addListELement(String name, int percentage)
    {
        listSize++;
        Element element = new Element(name, percentage);
        list.add(element);
    }

    @Override
    public void setGrade()
    {
        double sum = 0;

        for (Element element: list)
        {
            sum += element.grade;
        }
        setGrade(sum);
        setMostElements();
    }

    @Override
    public void printClass()
    {
        System.out.println("\t\tSubject: " + name);
        System.out.println("\t\tPromedio: " + grade);
        System.out.println("\t\tMost: " + mostElements);
    }
}
