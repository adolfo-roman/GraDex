public class Test
{
    public static void main(String[] args)
    {
        Save save = new Save();
        Student student = new Student("Adolfo Roman");
        Semester s1 = new Semester("Semestre 1");
        Semester s2 = new Semester("Semestre 2");

        Subject subject = new Subject("EDA");

        Element e1 = new Element("Tarea", 50);
        double[] d1 = {6.2,6.7,8.1,9.1,6.9,8.3};

        Element e2 = new Element("Lab", 50);
        double[] d2 = {7.6,8.7,8,7.7,9.5,9.6,7.4,9.7,8.2};

        for (double d: d1)
        {
            e1.addListElement(d);
        }

        for (double d: d2)
        {
            e2.addListElement(d);
        }

        subject.list.add(e1);
        subject.list.add(e2);
        s1.list.add(subject);
        student.list.add(s1);
        student.list.add(s2);



        System.out.println(e1.grade);
        System.out.println(e2.grade);
        System.out.println(subject.grade);
        System.out.println(subject.listSize);
        System.out.println(s1.grade);
        System.out.println(s2.grade);
        System.out.println(student.grade);

        student.setGPA();
        student.printClass();

        save.check(student);
    }
}
