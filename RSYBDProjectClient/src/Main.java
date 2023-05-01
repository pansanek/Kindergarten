import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Что вы хотите сделать?\n 1.Просмотреть таблицу\n 2.Записать из таблицы\n 3.Удалить из таблицы\n 4.Поиск в таблице\n");
        String point = keyboard.nextLine();
        switch(point) {
            case "1":
                PrintTable();
                break;
            case "2":
                WriteInTable();
                break;
            case "3":
                DeleteFromTable();
                break;
            case "4":
                SearchInTable();
                break;
            default:
                System.out.println("Такого варианта нет!");
                break;
        }
    }
    public static void PrintTable() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Какую таблицу вы хотите просмотреть?");
        System.out.println("\n 1.Educators\n 2.Parents\n 3.Children\n 4.Groups\n 5.Nutrition\n");
        String table = keyboard.nextLine();
        switch (table) {
            case "1":
                get("http://localhost:8081/educators/all-educators");
                break;
            case "2":
                get("http://localhost:8081/parents/all-parents");
                break;
            case "3":
                get("http://localhost:8081/children/all-children");
                break;
            case "4":
                get("http://localhost:8081/groups/all-groups");
                break;
            case "5":
                get("http://localhost:8081/nutrition/all-nutrition");
                break;
            default:
                System.out.println("Такой таблицы нет!");
        }
    }
    public static void WriteInTable() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("В какую таблицу вы хотите записать?");
        System.out.println("\n 1.Educators\n 2.Parents\n 3.Children\n 4.Groups\n 5.Nutrition\n");
        String table = keyboard.nextLine();
        switch (table) {
            case "1":
                post("http://localhost:8081/educators/upload-educators",uploadEducators());
                break;
            case "2":
                post("http://localhost:8081/parents/upload-parents",uploadParents());
                break;
            case "3":
                post("http://localhost:8081/children/upload-children",uploadChildren());
                break;
            case "4":
                post("http://localhost:8081/groups/upload-groups",uploadGroups());
                break;
            case "5":
                post("http://localhost:8081/nutrition/upload-nutrition",uploadNutrition());
                break;
            default:
                System.out.println("Такой таблицы нет!");
        }
    }
    public static void DeleteFromTable() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Из какой таблицы вы хотите удалить запись?");
        System.out.println("\n 1.Educators\n 2.Parents\n 3.Children\n 4.Groups\n 5.Nutrition\n");
        String table = keyboard.nextLine();
        switch (table) {
            case "1":
                delete(deleteEducators());
                break;
            case "2":
                delete(deleteParents());
                break;
            case "3":
                delete(deleteChildren());
                break;
            case "4":
                delete(deleteGroups());
                break;
            case "5":
                delete(deleteNutrition());
                break;
            default:
                System.out.println("Такой таблицы нет!");
        }
    }
    public static void SearchInTable() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("В какой таблице вы хотите провести поиск?");
        System.out.println("\n 1.Educators\n 2.Parents\n 3.Children\n 4.Groups\n 5.Nutrition\n");
        String table = keyboard.nextLine();
        switch (table) {
            case "1":
                get(searchEducators());
                break;
            case "2":
                System.out.println("Пока в разработке, извините :(");
                break;
            case "3":
                get(searchChildren());
                break;
            case "4":
                System.out.println("Пока в разработке, извините :(");
                break;
            case "5":
                System.out.println("Пока в разработке, извините :(");
                break;
            default:
                System.out.println("Такой таблицы нет!");
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
    public static String uploadParents(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите айди родителя");
        String parentId = keyboard.nextLine();
        System.out.println("Введите имя родителя");
        String firstName = keyboard.nextLine();
        System.out.println("Введите фамилию родителя");
        String lastName = keyboard.nextLine();
        System.out.println("Введите почту родителя");
        String email = keyboard.nextLine();
        System.out.println("Введите номер телефона родителя");
        String phone = keyboard.nextLine();
        System.out.println("Введите место работы родителя");
        String workplace = keyboard.nextLine();

        String parent = "{\n    \"parentId\": "+parentId+",\n    \"firstName\": \""+firstName+"\",\n    \"lastName\": \""+lastName+"\",\n    \"email\": \""+email+"\",\n    \"phone\": \""+phone+"\",\n    \"workPlace\": \""+workplace+"\"\n}";
        return parent;
    }
    public static String uploadChildren(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите фамилию ребенка");
        String secondName = keyboard.nextLine();
        System.out.println("Введите имя ребенка");
        String firstName = keyboard.nextLine();
        System.out.println("Введите название группы");
        String groupName = keyboard.nextLine();
        System.out.println("Введите возраст ребенка");
        Integer age = keyboard.nextInt();
        String child = "{\n    \"secondName\": \""+secondName+"\",\n    \"firstName\": \""+firstName+"\",\n    \"groupName\": \""+groupName+"\",\n    \"age\": "+age+"\n}" ;
        return child;
    }
    public static String uploadGroups(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите название группы");
        String groupName = keyboard.nextLine();
        System.out.println("Введите имя перподавателя");
        String educatorName = keyboard.nextLine();
        System.out.println("Введите количество детей");
        Integer num = keyboard.nextInt();
        String group="{\n    \"groupName\": \""+groupName+"\",\n    \"educatorName\": \""+educatorName+"\",\n    \"numberOfChildren\": "+num+"\n}";
        return group;
    }
    public static String uploadNutrition(){
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

    public static String deleteEducators() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите фамилию перподавателя которого вы хотите удалить");
        String secondName = keyboard.nextLine();
        String educator=String.format("http://localhost:8081/educators/delete-educators?secondName=%s",secondName);
        return educator;
    }
    public static String deleteParents() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите ID родителя которого вы хотите удалить");
        String parentId = keyboard.nextLine();
        String parent=String.format("http://localhost:8081/parents/delete-parents?parentId=%s",parentId);
        return parent;
    }
    public static String deleteChildren() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите фамилию перподавателя которого вы хотите удалить");
        String secondName = keyboard.nextLine();
        String child=String.format("http://localhost:8081/children/delete-children?secondName=%s",secondName);
        return child;
    }
    public static String deleteGroups() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите фамилию перподавателя которого вы хотите удалить");
        String groupName = keyboard.nextLine();
        String group=String.format("http://localhost:8081/groups/delete-groups?groupName=%s",groupName);
        return group;
    }
    public static String deleteNutrition() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите день недели которого вы хотите удалить");
        String day_of_week = keyboard.nextLine();
        String day=String.format("http://localhost:8081/nutrition/delete-nutrition?day_of_week=%s",day_of_week);
        return day;
    }

    public static String searchEducators() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите возраст преподавателя");
        String age = keyboard.nextLine();
        String url=String.format("http://localhost:8081/educators/get-by-age/%s",age);
        return url;
    }
    public static String searchChildren() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите возраст ребенка");
        String age = keyboard.nextLine();
        String url=String.format("http://localhost:8081/children/get-by-age/%s",age);
        return url;
    }

    public static void delete(String StringURL) throws IOException{
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
        }
        http.disconnect();
    }
    public static void post(String StringURL,String req) throws IOException{
        URL url= new URL(StringURL);
        String requestBody = req;
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