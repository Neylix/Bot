import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Data {
    private Request request = new Request();

    String getData() {
        String data = null;
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        try {
            data = Request.post("https://fr.investing.com/crypto/bitcoin/btc-usd-technical", keys, values);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
