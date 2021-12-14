import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save
{
    public void check(Student student)
    {
        File file = new File("perfil");

        if(file.exists())
        {
            File[] files = file.listFiles();

            for (File f: files)
            {
                delete(f);
                f.delete();
            }
        }

        buildProfile(student);
    }

    public void delete(File file)
    {
        if(file.isDirectory())
        {
            File[] list = file.listFiles();

            for (File f: list)
            {
                delete(f);
                f.delete();
            }
        }
        else
        {
            file.delete();
        }
    }

    public void buildProfile(Student student)
    {
        File s = new File("perfil/" + student.name);

        if(s.mkdir())
        {
            for (Semester semester: student.list)
            {
                buildSemesters(semester, s);
            }
        }

        File p = new File("perfil/" + student.name + "/" + "Promedio Global.csv");

        try
        {
            if(p.createNewFile())
            {
                FileWriter writer = new FileWriter(p);

                writer.write("Promedio Global" + "\n");
                writer.write("\n");

                writer.write("Semestre, Promedio\n");

                for (Semester semester: student.list)
                {
                    writer.write(semester.name + ",");
                    writer.write(Double.toString(semester.grade) + "\n");
                }

                writer.write("\n");
                writer.write("Total, " + Double.toString(student.grade));

                writer.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error");
        }

    }

    public void buildSemesters(Semester semester, File student)
    {
        File s = new File(student.getAbsolutePath() + "/" + semester.name);

        if(s.mkdir())
        {
            for (Subject subject: semester.list)
            {
                buildSubject(subject, s);
            }
        }

        File p = new File(student.getAbsolutePath() + "/" + semester.name + "/" + "Promedio " + semester.name + ".csv");

        try
        {
            if(p.createNewFile())
            {
                FileWriter writer = new FileWriter(p);

                writer.write(semester.name + "\n");
                writer.write("\n");

                writer.write("Materia, Promedio\n");

                for (Subject subject: semester.list)
                {
                    writer.write(subject.name + ",");
                    writer.write(Double.toString(subject.grade) + "\n");
                }

                writer.write("\n");
                writer.write("Total, " + Double.toString(semester.grade));

                writer.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error");
        }


    }

    public void buildSubject(Subject subject, File file)
    {
        File s = new File(file.getAbsolutePath() + "/" + subject.name);

        if(s.mkdir())
        {
            writeSubject(subject, s);
        }
    }

    public void writeSubject(Subject subject, File s)
    {
        File p = new File(s.getAbsolutePath() + "/" + "Promedio " + subject.name + ".csv");
        int most = subject.mostElements;

        try
        {
            if(p.createNewFile())
            {
                FileWriter writer = new FileWriter(p);

                writer.write(",");

                for (int i = 0; i < most; i++)
                {
                    writer.write(Integer.toString(i+1));
                    writer.write(",");
                }

                writer.write(",Total,");
                writer.write("%,");
                writer.write("Final\n");

                for (Element element: subject.list)
                {
                    writeElement(element, writer, most);
                }

                for (int i = 0; i < most + 4; i++)
                {
                    writer.write(",");
                }

                writer.write(Double.toString(subject.grade));

                writer.close();
            }
        }
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void writeElement(Element element, FileWriter writer, int mostSpaces)
    {
        int size;
        try
        {
            writer.write(element.name);
            size = element.list.size();
            double grade;

            for (int i = 0; i < mostSpaces; i++)
            {
                if(i < size)
                {
                    grade = element.list.get(i);
                    writer.write("," + Double.toString(grade));
                }
                else
                    writer.write(",");
            }
            writer.write(",");

            writer.write("," + Double.toString(element.total) + ",");
            writer.write(Integer.toString(element.percentage) + ",");
            writer.write(Double.toString(element.grade)+"\n");

        }
        catch (IOException e)
        {
            System.out.println("Error");
        }
    }
}
