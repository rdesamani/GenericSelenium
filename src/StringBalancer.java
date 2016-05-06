import java.util.*;

public class StringBalancer {

	public static void main(String[] argh) {
		// Scanner sc = new Scanner(System.in);
		Boolean flag = true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		Stack<Character> st = new Stack<Character>();
		String raw_input = "({}[]), ({()}))), ({(){}()})()({(){}()})(){()}, {}()))(()()({}}{}, }}}}, )))), {{{, (((, []{}(){()}((())){{{}}}{()()}{{}{}}, [[]][][]";
		String[] arrRaw_Input = raw_input.split(",");
		for (int j = 0; j < arrRaw_Input.length; j++) {
			String input = arrRaw_Input[j]; // sc.next();
			char[] chars = new char[input.length()];
			input.getChars(0, input.length(), chars, 0);

			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
					st.push(chars[i]);
				} else if (chars[i] == '}' || chars[i] == ']'
						|| chars[i] == ')') {
					if (!st.empty()) {
						if (map.get(st.peek()).equals(chars[i])) {
							st.pop();
						} else {
							break;
						}
					}
					else{
						flag=false;
					}
				}
			}

			if (st.empty() && flag) {
				System.out.println("true");
			} else {
				flag=true;
				System.out.println("false");
			}
		}
	}
}
