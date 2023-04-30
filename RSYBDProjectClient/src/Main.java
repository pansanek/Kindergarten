import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import org.json.*;
public class Main {
    public static void main(String[] args) throws Exception {




    }
    public static void PrintTable() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите просмотреть?");
        String table = keyboard.nextLine();
        switch (table) {
            case "Educators":
                get("http://localhost:8081/educators/all-educators");
                break;
            case "Parents":
                get("http://localhost:8081/parents/all-parents");
                break;
            case "Children":
                get("http://localhost:8081/children/all-children");
                break;
            case "Groups":
                get("http://localhost:8081/groups/all-groups");
                break;
            case "Nutrition":
                get("http://localhost:8081/nutrition/all-nutrition");
                break;
            default:
                System.out.println("Invalid service name");
        }
    }

    public static void WriteInTable() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("В какую таблицу вы хотите записать?");
        String table = keyboard.nextLine();
        switch (table) {
            case "Educators":
                post("http://localhost:8081/educators/all-educators");
                break;
            case "Parents":
                get("http://localhost:8081/parents/all-parents");
                break;
            case "Children":
                get("http://localhost:8081/children/all-children");
                break;
            case "Groups":
                get("http://localhost:8081/groups/all-groups");
                break;
            case "Nutrition":
                get("http://localhost:8081/nutrition/all-nutrition");
                break;
            default:
                System.out.println("Invalid service name");
        }
    }
    public static String uploadEducators(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите фамилию перподавателя");
        String secondName = keyboard.nextLine();
        System.out.println("Введите имя перподавателя");
        String firstName = keyboard.nextLine();
        System.out.println("Введите возраст перподавателя");
        String age = keyboard.nextLine();
        String educator="{\n    \"secondName\": \""+secondName+"\",\n    \"firstName\": \""+firstName+"\",\n    \"age\": "+age+"\n}";
        return educator;
    }

    public static void deleteEducators() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите фамилию перподавателя которого вы хотите удалить");
        String secondName = keyboard.nextLine();
        String educator=String.format("http://localhost:8081/educators/delete-educators?secondName=%s",secondName);
        get(educator);
    }

    public static void post(String StringURL) throws IOException{
        URL url= new URL(StringURL);
        String requestBody = uploadEducators();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
        connection.getOutputStream().write(requestBodyBytes);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = in.readLine();
            System.out.println("Response from server: " + response);
            in.close();
        } else {
            System.out.println("Error: " + responseCode);
        }
    }

    public static void get(String StringURL) throws IOException {
        URL url = new URL(StringURL);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            printJsonTable(response.toString());
        }

        http.disconnect();
    }

    public static void printJsonTable(String jsonString) {
        // Парсим строку JSON
        JSONArray jsonArray = new JSONArray(jsonString);

        // Получаем массив ключей из первого объекта JSON
        JSONObject firstObj = jsonArray.getJSONObject(0);
        String[] keys = firstObj.keySet().toArray(new String[firstObj.length()]);

        // Выводим заголовок таблицы
        for (String key : keys) {
            System.out.print(key + "\t");
        }
        System.out.println();

        // Выводим строки таблицы
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            for (String key : keys) {
                System.out.print(obj.get(key) + "\t");
            }
            System.out.println();
        }
    }
}