import java.util.*;

class Solution {

    private String expression;
    private int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parseExpression() {
        Set<String> result = new HashSet<>();

        while (index < expression.length() &&
               expression.charAt(index) != '}') {

            Set<String> part = parseTerm();

            result.addAll(part);

            if (index < expression.length() &&
                expression.charAt(index) == ',') {
                index++;
            }
        }

        return result;
    }
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < expression.length()) {

            char ch = expression.charAt(index);

            if (ch == '}' || ch == ',') {
                break;
            }

            Set<String> current = parseFactor();

            result = concatenate(result, current);
        }

        return result;
    }

    private Set<String> parseFactor() {

        char ch = expression.charAt(index);

        if (ch >= 'a' && ch <= 'z') {
            index++;

            Set<String> result = new HashSet<>();
            result.add(String.valueOf(ch));

            return result;
        }

        index++; 

        Set<String> result = parseExpression();

        index++; 

        return result;
    }
    private Set<String> concatenate(
        Set<String> first,
        Set<String> second
    ) {
        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}
