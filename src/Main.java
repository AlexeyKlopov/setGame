import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("E://Нетология//Games//temp"),
                new File("E://Нетология//Games//src"),
                new File("E://Нетология//Games//res"),
                new File("E://Нетология//Games//savegames"),
                new File("E://Нетология//Games//src//main"),
                new File("E://Нетология//Games//src//test"),
                new File("E://Нетология//Games//res//drawables"),
                new File("E://Нетология//Games//res//vectors"),
                new File("E://Нетология//Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("E://Нетология//Games//src//main//Main.java"),
                new File("E://Нетология//Games//src//main//Utils.java"),
                new File("E://Нетология//Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) builder.append("Папка " + folder + " создана\n");
            else builder.append("Папка " + folder + " не создана\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) builder.append("Файл " + file + " создан\n");
                else builder.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                builder.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter writer = new FileWriter("E://Нетология//Games//temp//temp.txt", false)) {
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException ex) {
            builder.append(ex.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader("E://Нетология//Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
