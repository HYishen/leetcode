package nowcoder.huawei;

import java.util.*;

/**
 * <pre>
 * https://www.nowcoder.com/practice/9999764a61484d819056f807d2a91f1e?tpId=37&tqId=21273&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey。
 * 四则运算.
 * </pre>
 *
 * @author Yishen 844147804@qq.com
 * @version 1.00.00
 */
public class HJ50 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        //1.把字符串放入List中，好处理
        List<String> mid = midExpre(expression);
        List<String> middle = change(mid);
        //System.out.println(middle);
        //2.中缀变后缀
        List<String> last = lastExpre(middle);
        /*System.out.println(last);*/
        //3.后缀运算结果
        int num = calculate(last);
        System.out.println(num);
    }

    public static int calculate(List<String> last) {

        Stack<String> st = new Stack<>();
        for (String item : last) {
            if (item.matches("\\d+")) {
                st.push(item);
            } else {
                int s2 = Integer.parseInt(st.pop());
                int s1 = Integer.parseInt(st.pop());
                int num = 0;
                if (item.equals("+")) {
                    num = s1 + s2;
                }
                if (item.equals("-")) {
                    num = s1 - s2;
                }
                if (item.equals("*")) {
                    num = s1 * s2;
                }
                if (item.equals("/")) {
                    num = s1 / s2;
                }
                st.push(num + "");//算了一通要把结果入栈啊！！
            }

        }
        return Integer.parseInt(st.pop());
    }

    //2.此函数用来中缀变后缀
    public static List<String> lastExpre(List<String> middle) {//别忘了<String>，否则增强for出错
        //1.按步骤，一个栈（符号），一个List集合（不出只往中放）
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        //2.用增强for遍历List
        //3.如果是数、符号、括号
        for (String item : middle) {
            if (item.matches("\\d+")) {//用正则表达式判断是否为数字
                s2.add(item);//是数字放入f2
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {//用equals，不要用成==了
                    s2.add(s1.pop());
                }
                s1.pop();//把"("丢弃掉
            } else {//如果是运算符的话，此处易错，若优先级低，则不断pop用while,不能只pop一次
                //且不能忘记pop完后要入栈的。这个写法是最简洁的
                while (s1.size() != 0 && HJ50.getVal(item) <= HJ50.getVal(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //创建一个函数，返回各个符号的数值，以能比较优先级
    private static int getVal(String item) {//没有break造成了错误
        int i = 0;
        switch (item) {
            case "+":
                i = 1;
                break;
            case "-":
                i = 1;
                break;
            case "*":
                i = 2;
                break;
            case "/":
                i = 2;
                break;
            default:
                break;
        }
        return i;
    }

    //1.此函数用来把字符串放入List中，好处理。 1+((2553+3)×4)-5=>[1, +, (, (, 2553, +, 3, ), ×, 4, ), -, 5]
    public static List<String> midExpre(String expression) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str = "";//拼接数字用
        while (i < expression.length()) {
            //情况分为是数字，不是数字。不是数字直接加入List
            //数字的ASCII是 a-z:97-122,A-Z:65-90,0-9:48-57,也可以用isDigit
            if (!Character.isDigit(expression.charAt(i))) {
                list.add(expression.charAt(i) + "");
                i++;
            } else {
                str = "";
                //当是数字时就一直拼接，用while
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    str = str + expression.charAt(i);
                    i++;
                }
                list.add(str);
            }
        }
        return list;
    }

    //处理List变成想要的中缀表达式
    private static List<String> change(List<String> mid) {
        for (int i = 0; i < mid.size(); i++) {
            String str = mid.get(i);
            if (str.equals("[") || str.equals("{")) {
                mid.set(i, "(");
            } else if (str.equals("]") || str.equals("}")) {
                mid.set(i, ")");
            }
            if (str.equals("-")) {
                if (i == 0) {
                    mid.add(0, "0");
                } else if (mid.get(i - 1).equals("(")) {
                    mid.add(i, "0");
                }
            }
        }
        return mid;
    }

}
