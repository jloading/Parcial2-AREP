package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.*;

public class Server {

    private static int currentIndex = -1;

    private static String[] urls = {"http://ec2-54-198-37-248.compute-1.amazonaws.com:4568/lucasSeq?number=", "http://ec2-54-198-37-248.compute-1.amazonaws.com:4569/lucasSeq?number="};

    public static void main(String... args) {
        port(getPort());
        staticFiles.location("/public");
        get("lucasSeq", (req, res) -> {
            int number = Integer.parseInt(req.queryParams("number"));
            System.out.println("Number: " + number);
            String url = getUrl();
            System.out.println("URL " + url);
            res.type("application/json");
            String response = HttpConnection(url, number);
            return response;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String getUrl() {
        int index = getNextNumber();
        return urls[index];
    }

    private static int getNextNumber() {
        currentIndex = (currentIndex + 1) % 2;
        return currentIndex;
    }

    private static String HttpConnection(String url, int number) {
        try {
            URL obj = new URL(url + number);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                System.out.println("GET request not worked");
                return "{ \"error\": \"GET request not worked\" }";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{ \"error\": \"Internal server error\" }";
        }
    }
}
