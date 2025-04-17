import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solved {
    static String str;
    static int titleNumber;
    static String title = ""; // "p_nnnn : test" :

    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        updateMain();
        updateReadme();
        isReadmeSorted();
        setClipboard();
    }

    private static void setClipboard() throws IOException, UnsupportedFlavorException {
        System.out.println("클립보드에 저장하기");
        StringSelection data = new StringSelection(title);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(data, data);
        System.out.printf("\"%s\" : 클립보드에 복사되었습니다.\n", clipboard.getContents(clipboard).getTransferData(DataFlavor.stringFlavor));
    }

    static void isReadmeSorted() throws IOException {
        System.out.println("README.md 정렬 여부 확인");
        BufferedReader readme = new BufferedReader(new FileReader("README.md"));
        int idx = 0;
        while ((str = readme.readLine()) != null) {
            if (str.startsWith("p_")) {
                String string = str.replace("p_", "");
                StringTokenizer st = new StringTokenizer(string);
                int num = Integer.parseInt(st.nextToken());
                if (num <= idx) {
                    System.out.println("순서 안맞음");
                    System.out.println("num = " + num);
                    System.out.println("idx = " + idx);
                }
                idx = num;
            }
        }
    }

    static void updateMain() throws IOException {
        System.out.println("클래스 파일 작성");
        BufferedReader main = new BufferedReader(new FileReader("Main.java"));
        String packageName = "";
        while ((str = main.readLine()) != null) {
            if (str.startsWith("    //    p_")) {
                title = str.replace("    //    ", "");
            }
        }
        titleNumber = Integer.parseInt(new StringTokenizer(title.substring(2)).nextToken());
        switch (titleNumber / 10000) {
            case 0 -> packageName = "P1000toP9999";
            case 1 -> packageName = "P10000toP19999";
            case 2 -> packageName = "P20000toP29999";
            default -> packageName = "P30000toP39999";
        }
        // 파일에 내용 입력하기
        String packagePath = "./SOLUTIONS_code/" + packageName + "/p_" + titleNumber + ".java";
        System.out.println(packagePath + "에 파일 내용 입력");
        BufferedWriter writer = new BufferedWriter(new FileWriter(packagePath));
        // package 명 라인 추가
        writer.write("package SOLUTIONS_code." + packageName + ";\n\n");
        main = new BufferedReader(new FileReader("Main.java"));
        while ((str = main.readLine()) != null) {
            // 클래스명 p_titleNumber로 변경
            if (str.startsWith("public class Main")) {
                str = str.replace("Main", "p_" + titleNumber);
            }
            // psvm을 psv + solution()으로 변경
            if (str.startsWith("    public static void main")) {
                str = str.replace("main", "solution");
            }
            writer.write(str);
            writer.write("\n");
        }
        writer.close();
        System.out.println("Main.java 초기화");
        writer = new BufferedWriter(new FileWriter("Main.java"));
        writer.write("""
                import java.io.IOException;
                
                public class Main {
                    //    p_
                    public static void main(String[] args) throws IOException {
                
                    }
                }"""
        );
        writer.close();
        main.close();

    }

    /***
     * README.md 수정하기
     */
    static void updateReadme() throws IOException {
        System.out.println("README.md 작성");
        BufferedReader readme = new BufferedReader(new FileReader("README.md"));
        List<String> lines = new ArrayList<>();
        while ((str = readme.readLine()) != null) {
            lines.add(str);
        }

        readme.close();

        // 다시 파일에 덮어쓰기
        BufferedWriter readmeWriter = new BufferedWriter(new FileWriter("README.md"));
        int index = 0;
        boolean isAdded = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("### #")) {
                index += 10000;
            }
            if (!isAdded && line.startsWith("p_")) {
                String string = line.replace("p_", "");
                StringTokenizer st = new StringTokenizer(string);
                int num = Integer.parseInt(st.nextToken());
                if (num < index && num > titleNumber) {
                    readmeWriter.write(title + "  \n");
                    isAdded = true;
                }
            }
            readmeWriter.write(line);
            readmeWriter.write("\n");
        }
        if (!isAdded) {
            lines.add(title + "  "); // 마지막에 추가
        }
        readmeWriter.close();
    }
}
