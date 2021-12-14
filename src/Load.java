import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Load
{
    public Student check()
    {
        Student student;
        File file = new File("perfil");

        if (file.exists())
        {
            File[] files = file.listFiles();
            student = new Student("");

            for (File f: files)
            {
                if(f.isDirectory())
                {
                    setStudent(f, student);
                }
            }
            return student;
        }
        return null;
    }

    public void setStudent(File file, Student student)
    {
        student.name = file.getName();

        File[] files = file.listFiles();
        Semester semester;

        int i = 0;

        for (File f: files)
        {
            if(f.isDirectory())
            {
                student.addListElement();
                semester = student.list.get(i);
                setSubject(f, semester);
                i++;
            }
        }
        student.setGPA();
    }

    public void setSubject(File file, Semester semester)
    {
        Subject subject;
        File[] files = file.listFiles();
        int i = 0;

        for (File f: files)
        {
            if(f.isDirectory())
            {
                semester.addListElement(f.getName());
                subject = semester.list.get(i);
                setElement(f, subject);
                i++;
            }
        }
    }

    public void setElement(File file, Subject subject)
    {
        Element element;
        File[] files = file.listFiles();
        String[] ls;

        for (File f: files)
        {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                reader.readLine();
                int i = 0;

                do
                {
                    try
                    {
                        ls = reader.readLine().split(",");

                        if(!ls[0].isBlank())
                        {
                            subject.addListELement(ls[0], Integer.parseInt(ls[ls.length - 2]));
                            element = subject.list.get(i);

                            for (int j = 1; j < ls.length; j++)
                            {
                                if(!ls[j].isBlank())
                                    element.addListElement(Double.parseDouble(ls[j]));
                                else
                                    break;
                            }
                        }
                        i++;
                    }
                    catch (NullPointerException e)
                    {
                        break;
                    }
                }
                while(true);

                subject.setMostElements();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
