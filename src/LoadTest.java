public class LoadTest
{
    public static void main(String[] args) {
        Load load = new Load();
        Student student = load.check();

        student.printClass();
    }

}
