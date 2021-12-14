import java.util.Scanner;

public class Main implements MainMethods
{
    public static void main(String[] args)
    {
        int option;
        String nombre;

        Student student = firstMenu();
        Load load;
        Save save;
        Semester semester;
        Subject subject;
        Element element;
        do
        {
            do
            {

                System.out.println("1. Semestre");
                System.out.println("2. Materia");
                System.out.println("3. Elemento");
                System.out.println("4. Calificacion");
                System.out.println("5. Print");
                System.out.println("6. ssSave");
                System.out.println("8. Salir");

                option = scan.nextInt();
            }
            while (option < 1 || option > 8);

            switch (option)
            {
                case 1:
                    student.addListElement();
                    break;
                case 2:
                    semester = student.getElement();
                    System.out.print("Nombre de Materia: ");
                    nombre = scan.useDelimiter("\n").next();
                    semester.addListElement(nombre);
                    break;
                case 3:
                    semester = student.getElement();
                    subject = semester.getElement();
                    subject.addListElement();
                    break;
                case 4:
                    semester = student.getElement();
                    subject = semester.getElement();
                    element = subject.getElement();
                    element.addListElement();
                    break;
                case 5:
                    student.printClass();
                    break;
                case 6:
                    //save.check(student);
                    break;
            }

            student.setGPA();
        }
        while (option != 8);
    }

    public static Student firstMenu()
    {
        Student student = null;
        Scanner scanner = new Scanner(System.in);
        String nombre;
        int option;
        Load load = new Load();

        do
        {
            System.out.println("1. Nuevo Perfil");
            System.out.println("2. Cargar Perfil");

            option = scanner.nextInt();
        }
        while(option < 1 || option > 2);

        switch (option)
        {
            case 1:
                System.out.println("Nombre de Estudiante: ");
                nombre = scanner.useDelimiter("\n").next();
                student = new Student(nombre);
                break;
            case 2:
                student = load.check();
                break;
        }

        return student;
    }

    public static void printStudent(Student student)
    {
        student.printClass();

        for (Semester semester: student.list)
        {
            printSemester(semester);
        }

    }

    public static void printSemester(Semester semester)
    {
        semester.printClass();

        for (Subject subject: semester.list)
        {
            printSubject(subject);
        }
    }

    public static void printSubject(Subject subject)
    {
        subject.printClass();

        for (Element element: subject.list)
        {
            element.printClass();
        }

    }

   /* public static void menuSemestre(Student student)
    {
        student.getElement();
        int optionSemestre;

        do
        {
            System.out.println();
        }
        while();

    }*/

}
