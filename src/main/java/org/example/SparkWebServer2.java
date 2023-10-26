package org.example;

import static spark.Spark.*;

public class SparkWebServer2 {


    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("lucasSeq", (req,res) -> {

            res.type("text/json");

            int number = Integer.parseInt(req.queryParams("number"));

            return lucasSeq(number);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4569;
    }

    public static String lucasSeq(int number){
        String result = "";
        String response = "";
        int first = 2;
        int second = 1;
        int temp = 0;
        int []arr = new int[number];

        if(number == 1)
        {
            result = "2";
            return result;
        }

        else if(number == 2)
        {
            result = "1";
            return result;
        }
        arr[0] = 2;
        arr[1] = 1;
        for(int i = 2; i < number; i++)
        {
            temp = first + second;
            arr[i] = temp;
            first = second;
            second = temp;
        }
        for(int i = 0; i < number; i++)
        {
            result += arr[i]+",";

        }

        response = "{\n" +
                "\n" +
                " \"operation\": \"Secuencia de Lucas\",\n" +
                "\n" +
                " \"input\": " + String.valueOf(number) + ",\n" +
                "\n" +
                " \"output\": " + result + "\n" +
                "\n" +
                "}";

        return response;
    }

}