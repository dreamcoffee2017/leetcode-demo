package my;

public class Rar {

    public static void main(String[] args) {
//        String s="abc";
//        String s = "abc3[aa]";
//        String s = "abc3[aa]2[bb]";
//        String s = "abc3[aa2[bb]]";
        String s = "abc3[aa2[bb]3[cc]]2[dd]";
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) <= '9') {
                i = dfs(sb, i);
            }
        }
        System.out.println(sb);
    }

    static int dfs(StringBuilder sb, int index) {
        int end = 0;
        int num = Integer.parseInt(String.valueOf(sb.charAt(index)));
        for (int i = index + 2; i < sb.length(); i++) {
            if (sb.charAt(i) == ']') {
                end = i;
                break;
            } else if (sb.charAt(i) <= '9') {
                i = dfs(sb, i);
            }
        }
        StringBuilder s = new StringBuilder();
        String sub = sb.substring(index + 2, end);
        for (int i = 0; i < num; i++) {
            s.append(sub);
        }
        sb.replace(index, end + 1, s.toString());
        return index + s.length() - 1;
    }
}
