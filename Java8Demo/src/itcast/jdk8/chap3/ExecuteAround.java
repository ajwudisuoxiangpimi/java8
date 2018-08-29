package itcast.jdk8.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        String result = processFileLimited();
        System.out.println(result);
        System.out.println("-------");

        String one = processFile((BufferedReader br) -> br.readLine());
        System.out.println(one);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\dev\\Java8Demo\\src\\itcast\\jdk8\\data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedFileProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\dev\\Java8Demo\\src\\itcast\\jdk8\\data.txt"))) {
            return p.process(br);
        }
    }
    public interface BufferedFileProcessor{
        public String process(BufferedReader br) throws IOException;
    }
}
