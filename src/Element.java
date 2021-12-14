import java.util.LinkedList;

public class Element extends Grade
{
    public int percentage;
    public double total;
    public LinkedList<Double> list;

    public Element(String name, int percentage)
    {
        super(name);
        this.percentage = percentage;
        this.list = new LinkedList<>();
        this.total = 0;
    }

    @Override
    public void setGrade()
    {
        double sum = 0;

        for (double grade : list)
        {
            sum += grade;
        }

        total = sum;

        sum = sum / listSize;

        sum = sum * (double) percentage / 100;

        sum = Math.round(sum * 100d) / 100d;
        total = Math.round(total * 100d) / 100d;

        setGrade(sum);
    }

    @Override
    public void addListElement() {
        double g;
        System.out.print("Calificacion: ");
        g = scan.nextDouble();
        addListElement(g);
    }

    public void addListElement(double f) {
        list.add(f);
        listSize++;
        setGrade();
    }

    @Override
    public void printClass() {
        System.out.println("\t\t\tElemento: " + name);
        System.out.println("\t\t\tPromedio: " + grade);
        System.out.println("\t\t\t\tPorcentaje: " + percentage + " %");
        System.out.println("\t\t\t\tNumero de Cals: " + listSize);
        System.out.println("\t\t\t\tTotal: " + total);
        System.out.print("\t\t\t\tCals: ");

        for (Double c : list) {
            System.out.print(c + ", ");
        }

        System.out.println();
    }
}
