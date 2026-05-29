class Solution {

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    int num = 0;
    public int calculate(String s) {
        char[] ex = s.toCharArray();
        num = 0;
        Stack<Expression> stack = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i = 0; i < ex.length; i++) {
            char c = ex[i];

            if(c == ' ') continue;

            if(Character.isDigit(c)) {
                num = num*10 + (c - '0');
            } else {
                stack.push(new Value(num));
                num = 0;
            }

            if(!Character.isDigit(c)) {
                while(ops.size() > 0 && precedence(ops.peek()) >= precedence(c)) {
                    Expression right = stack.pop();
                    Expression left = stack.pop();
                    stack.push(create(ops.pop(), right, left));
                    stack.push(new Value(stack.pop().calculate()));
                }
                ops.push(c);
            }
        }
        stack.push(new Value(num));

        // System.out.println(ops);
        // System.out.println(stack);

        while(ops.size() > 0) {
            Expression right = stack.pop();
            Expression left = stack.pop();
            stack.push(create(ops.pop(), right, left));
        }

        return stack.peek().calculate();
    }

    int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    Expression create(char op, Expression right, Expression left) {
        if(op == '-' && left == null) return new Negate(right);
        if(op == '+') return new Add(left, right);
        if(op == '-') return new Subtract(left, right);
        if(op == '/') return new Divide(left, right);
        if(op == '*') return new Multiply(left, right);
        return new Value(0);
    }

    abstract class Expression {
        public abstract int calculate();
    }

    class Value extends Expression {
        int val;

        public Value(int val) {
            this.val = val;
        }

        public int calculate() {
            return val;
        }

        public String toString() {
            return ""+ this.val;
        }
    }

    class Negate extends Expression {
        Expression e;

        public Negate(Expression e) {
            this.e = e;
        }

        public int calculate() {
            return -e.calculate();
        }

        public String toString() {
            return "[-u]";
        }
    }

    class Add extends Expression {
        Expression left;
        Expression right;

        public Add(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public int calculate() {
            return left.calculate() + right.calculate();
        }

        public String toString() {
            return "[+]";
        }
    }

    class Subtract extends Expression {
        Expression left;
        Expression right;

        public Subtract(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public int calculate() {
            return left.calculate() - right.calculate();
        }

        public String toString() {
            return "[-]";
        }
    }

    class Multiply extends Expression {
        Expression left;
        Expression right;

        public Multiply(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public int calculate() {
            return left.calculate() * right.calculate();
        }

        public String toString() {
            return "[*]";
        }
    }

    class Divide extends Expression {
        Expression left;
        Expression right;

        public Divide(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public int calculate() {
            return left.calculate() / right.calculate();
        }

        public String toString() {
            return "[/]";
        }
    }

}