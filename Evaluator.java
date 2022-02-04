import java.util.*;

public class Evaluator {

    static boolean isNumber(String str) {
        try{
            Double.valueOf(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    static Queue<String> convertInfixToRPN(ArrayList<String> infixNotation) {
        Map<String, Integer> prededence = new HashMap<>();
        prededence.put("%", 5);
        prededence.put("/", 5);
        prededence.put("*", 5);
        prededence.put("+", 4);
        prededence.put("-", 4);
        prededence.put("(", 0);


        Queue<String> Q = new LinkedList<>();
        Stack<String> S = new Stack<>();

        for (String token : infixNotation) {
            if ("(".equals(token)) {
                S.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(S.peek())) {
                    Q.add(S.pop());
                }
                S.pop();
                continue;
            }
            // an operator
            if (prededence.containsKey(token)) {
                while (!S.empty() && prededence.get(token) <= prededence.get(S.peek())) {
                    Q.add(S.pop());
                }
                S.push(token);
                continue;
            }

            if (isNumber(token)) {
                Q.add(token);
                continue;
            }

            throw new IllegalArgumentException("Invalid input");
        }
        // at the end, pop all the elements in S to Q
        while (!S.isEmpty()) {
            Q.add(S.pop());
        }

        return Q;
    }









    static double evalRPN(ArrayList list) {
        Stack<Double> stack = new Stack();
        double val1, val2;

        for (int i = 0; i < list.size(); i++) {
            if ("+".equals(list.get(i))) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(list.get(i))) {
                val1 = stack.pop();
                val2 = stack.pop();
                stack.push(val2 - val1);
            } else if ("*".equals(list.get(i))) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(list.get(i))) {
                val1 = stack.pop();
                val2 = stack.pop();
                stack.push(val2 / val1);
            } else if ("%".equals(list.get(i))){
                val1 = stack.pop();
                val2 = stack.pop();
                stack.push(val2 % val1);
            }else {
                stack.push(Double.parseDouble((String) list.get(i)));
            }
        }
        return stack.pop();
    }






}
