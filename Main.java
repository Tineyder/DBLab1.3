import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File originalFile = new File("C:\\Users\\Lenovo\\IdeaProjects\\J2\\a.txt");
        Scanner console = new Scanner(System.in);
        for ( ; ; ) {
            System.out.print("команда===>");
            String inp = console.nextLine();
            System.out.println("Виконуємо: " + inp);

            if (inp.equals("pwd")) { printCurrentDirectory();}
            else if (inp.equals("ls")) { printCurFolders(originalFile);    }
            else if (inp.equals("cd")) { changeDirectory("C:\\Users\\Dell\\IdeaProjects");    }
            else if (inp.equals("e")) { System.exit(0);   }
            else {System.out.println("Помилка: Команда не дійсна ");  }
        }

    }

    public static void changeDirectory(String newDirectoryPath) {
        File newDirectory = new File(newDirectoryPath);

        if (newDirectory.isDirectory() && newDirectory.exists()) {
            System.setProperty("user.dir", newDirectory.getAbsolutePath());
            System.out.println("Директорія змінена на: " + newDirectory.getAbsolutePath());
        } else {
            System.out.println("Помилка: Директорія не існує.");
        }
    }

    public static void printCurFolders(File originalFile) {
        //  File originalFile = new File("C:\\Users\\Dell\\IdeaProjects\\J2\\a.txt");
        File folder = originalFile.getParentFile();
        for (File file : folder.listFiles())
        {
            if (file.isDirectory()) {
                System.out.println("-> " + file.getAbsolutePath());
            } else {
                System.out.println(file.getAbsolutePath() +
                        " (Розмір у байтах: " + file.length() +
                        ", Час останнього редагування: " + file.lastModified() + " )"
                        +", Видимість (hidden)- "+ file.isHidden()
                        +" Права доступу (r)"+file.canRead()+"/ (w)/"+file.canWrite()+" (e)"+file.canExecute());
            }
        }
    }

    public static void printCurrentDirectory() {
        File currentDirectory = new File(System.getProperty("user.dir"));
        System.out.println("Поточна директорія: " + currentDirectory.getAbsolutePath());
    }
}