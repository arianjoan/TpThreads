package UTN.repository;

import UTN.models.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class WinnersDao {


    public static boolean insertWinner (Player winner){

        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/threads","root","");

            String sql;
            sql = "insert into winners (nameWinner,remainingLifes,attempts,datePlay,word) values (?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1,winner.getPlayerName());
            stmt.setInt(2,winner.getLifes());
            stmt.setInt(3,winner.getAttempts());
            stmt.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now()));
            stmt.setString(5,winner.getWord().getWord());


            stmt.executeUpdate();

            return true;


        }catch(SQLException se){
            System.out.println("error sql");
            se.printStackTrace();
            return false;
        }catch(Exception e){
            System.out.println("error classforname");
            e.printStackTrace();
            return false;
        }


    }

}
