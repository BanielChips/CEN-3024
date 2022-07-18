package WordOccurrences;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;

public class database_controller {

    public static void tableCleaner() throws Exception {

        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(
                    "DELETE FROM word_occurrences.word WHERE id > 0");
            statement.executeQuery();
        } catch (Exception e) {
            System.out.println("Table clear error:");
            e.printStackTrace();
        }

    }

    public static void printTable() throws Exception {
        String query = "SELECT * FROM word_occurrences.word ORDER BY frequency";
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                System.out.print("ID: " + results.getInt("id"));
                System.out.print(", Word: " + results.getString("word"));
                System.out.println(", Frequency: " + results.getInt("frequency"));
            }
        } catch (Exception e) {
            System.out.println("Query error:");
            e.printStackTrace();
        }
    }

    public static void insertWord(String word) throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO word_occurrences.word (word, frequency) " +
                            "VALUES ('" + word + "', 1) " +
                            "ON DUPLICATE KEY UPDATE frequency = frequency + 1");
            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println("Entry insert error:\n" + e);
        }

    }

    public static HashMap<String, Integer> read() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(
                    "SELECT word, frequency " +
                            " FROM word_occurrences.word" +
                            " ORDER BY frequency DESC");
            ResultSet result = statement.executeQuery();

            HashMap<String, Integer> list = new HashMap<String, Integer>();
            while (result.next()) {

                list.put(result.getString("word"), result.getInt("frequency"));
            }
            return list;

        } catch (Exception e) {
            System.out.println("Record query error:\n");
            e.printStackTrace();
        }
        return null;
    }

    public static void createTable() throws Exception {
        try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS word" +
                            "(id int NOT NULL AUTO_INCREMENT, " +
                            "word varchar(255) UNIQUE, " +
                            "frequency int(30), " +
                            "PRIMARY KEY(id))");
            create.executeUpdate();
        } catch (Exception e) {
            System.out.println("Create table error:\n");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/word_occurrences";
            String user = "CEN";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, user, password);
            // System.out.println("DB connection established.");
            return conn;
        } catch (Exception e) {
            System.out.println("Connection error:\n" + e);
        }
        return null;
    }

}
