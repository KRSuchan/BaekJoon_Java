import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = "start";
    Stack<Character> stack = new Stack<>();
    while (s.length()>1 && s.charAt(0)!='.') {
      s = br.readLine();
      stack.empty();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') stack.push('(');
        else if (s.charAt(i) == '[') stack.push('[');
        else if (s.charAt(i) == ')' && stack.peek().equals('(')) stack.pop();
        else if (s.charAt(i) == ']' && stack.peek().equals('[')) stack.pop();
        else if (s.charAt(i) == ')' && !stack.peek().equals('(')) {
          bw.write("no\n");
          break;
        }
        else if (s.charAt(i) == ']' && !stack.peek().equals('[')) {
          bw.write("no\n");
          break;
        }
      }
      if (stack.isEmpty()) bw.write("yes\n");
      else bw.write("no\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}