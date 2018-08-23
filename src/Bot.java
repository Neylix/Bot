import java.util.HashMap;

public class Bot {

    public static void main(String[] args) {
        Data data = new Data();

        String html = data.getHtml();
        System.out.println(html);

        Parser pars = new Parser();
        HashMap<String, String> tab = pars.getIndicators(html);

        for (String ind : tab.keySet()) {
            System.out.println(ind + " → " + tab.get(ind));
        }
    }
}
