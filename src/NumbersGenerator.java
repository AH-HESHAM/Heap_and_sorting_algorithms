import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumbersGenerator {
    public static void main(String[] args) {
        NumbersGenerator ng = new NumbersGenerator();
        ng.generate(50000, "src/50000.txt");
    }

    public void generate(int num, String path) {
        Random randNum = new Random();
        Random randSign = new Random();
        try (FileWriter writer = new FileWriter(path)) {
            for (int i = 0; i < num - 1; i++) {
                int numToAdd = randNum.nextInt(10000);
                if (randSign.nextInt(2) == 1)
                    numToAdd *= -1;
                writer.write(numToAdd + ", ");
            }
            int numToAdd = randNum.nextInt(10000);
            if (randSign.nextInt(2) == 1)
                numToAdd *= -1;
            writer.write(numToAdd + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
