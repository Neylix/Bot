import java.util.HashMap;

class Parser {
    HashMap<String, String> getIndicators(String html) {
        int n = html.indexOf("technicalIndicatorsTbl");
        int n1;
        String indicator;
        String value;
        HashMap<String, String> tab = new HashMap<>();

        for (int i = 0; i < 12; i++) {
            n = html.indexOf("first left symbol", n + 1);
            n = html.indexOf(">", n + 1);
            n++;
            n1 = html.indexOf("<", n);

            indicator = html.substring(n, n1);

            n = html.indexOf("span", n1);
            n = html.indexOf(">", n + 1);
            n++;
            n1 = html.indexOf("<", n);

            value = html.substring(n, n1);

            tab.put(indicator, value);
        }

        return tab;
    }
}
