public class Bot {

    public static void main(String[] args) {
        Data data = new Data();

        while (true) {

            String html = data.getData();


            int n = html.indexOf("tiBuy");
            String temp = html.substring(n + 8, n + 10);

            int indNbBuy;

            if (temp.substring(1, 2).equals(")")) {
                indNbBuy = Integer.valueOf(temp.substring(0, 1));
            } else {
                indNbBuy = Integer.valueOf(temp);
            }

            n = html.indexOf("tiSell");
            temp = html.substring(n + 9, n + 11);

            int indNbSell;

            if (temp.substring(1, 2).equals(")")) {
                indNbSell = Integer.valueOf(temp.substring(0, 1));
            } else {
                indNbSell = Integer.valueOf(temp);
            }

            if (indNbBuy > 7) {
                System.out.println("Achat");
            } else if (indNbSell > 7) {
                System.out.println("Vente");
            } else {
                System.out.println("Neutre");
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
