package UTN.repository;

import UTN.Utilities;
import UTN.models.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordsDao {

    public static String getWord(){

        Connection conn;
        Statement stmt;
        String str = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");



            conn = DriverManager.getConnection("jdbc:mysql://localhost/threads","root","");
            String sql;
            sql = "Select * from words";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            List<Word> words = new ArrayList<>();

            while (rs.next()){

                Word word = new Word(rs.getString("word"));
                words.add(word);

            }

            str = words.get(Utilities.getRandom().nextInt(words.size())).getWord();



        }catch(SQLException se){

            System.out.println("error sql");
            se.printStackTrace();
        }catch(Exception e){

            System.out.println("error classforname");
            e.printStackTrace();
        }finally{
            return str;
        }


    }

}
