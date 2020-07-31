package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestTest {

    public static void main(String[] args) throws Exception {
        System.out.println(getNumDraws(2011));
    }

    public static int getNumDraws(int year) throws IOException {
        int sum = 0;
        String s1 = get(year, 1);
        Matcher m1 = Pattern.compile("\"total_pages\":(\\d+)").matcher(s1);
        if (m1.find()) {
            int pages = Integer.parseInt(m1.group(1));
            for (int i = 0; i < pages; i++) {
                String s2 = get(year, i + 1);
                Matcher m2 = Pattern.compile("\"team1goals\":\"(\\d+)\",\"team2goals\":\"(\\d+)\"").matcher(s2);
                while (m2.find()) {
                    int g1 = Integer.parseInt(m2.group(1));
                    int g2 = Integer.parseInt(m2.group(2));
                    if (g1 == g2) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    private static String get(int year, int page) throws IOException {
        HttpURLConnection con = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            con = (HttpURLConnection) new URL(
                    "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=" + page)
                            .openConnection();
            con.connect();
            if (con.getResponseCode() == 200) {
                is = con.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String temp;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                return sb.toString();
            }
            return "";
        } finally {
            if (br != null)
                br.close();
            if (is != null)
                is.close();
            if (con != null)
                con.disconnect();
        }
    }
}