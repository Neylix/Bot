import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

class Request {

    Request() {
    }

    static String post(String adress, List<String> keys, List<String> values) throws IOException {
        StringBuilder result = new StringBuilder();
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        try {
            //encodage des paramètres de la requête
            StringBuilder data = new StringBuilder();
            for (int i = 0; i < keys.size(); i++) {
                if (i != 0) data.append("&amp;");
                data.append(URLEncoder.encode(keys.get(i), StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(values.get(i), StandardCharsets.UTF_8));
            }
            //création de la connection
            URL url = new URL(adress);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");


            //envoi de la requête
            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(data.toString());
            writer.flush();


            //lecture de la réponse
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                result.append(ligne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch (Exception ignored) {
            }
            try {
                assert reader != null;
                reader.close();
            } catch (Exception ignored) {
            }
        }
        return result.toString();
    }
}
