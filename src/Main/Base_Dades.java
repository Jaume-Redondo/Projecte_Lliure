package Main;

import java.sql.*;

public class Base_Dades {

    private static final String db_url = "jdbc:mysql://localhost:3306/Projecte_Lliure";
    private static final String username = "JaumeAdmin";
    private static final String password = "JaumeAdmin123";

    public static void insertUser(String user) {

        int id = getUserId(user);

        if (id != -1) {
            return;
        }

        String sql = "INSERT INTO usuaris(user) VALUES(?)";

        try {
            Connection con = DriverManager.getConnection(db_url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ps.executeUpdate();

            ps.close();
            con.close();

            System.out.println("Usuari creat correctament");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getUserId(String user) {

        String sql = "SELECT id_user FROM usuaris WHERE user = ?";

        try {
            Connection con = DriverManager.getConnection(db_url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id_user");

                rs.close();
                ps.close();
                con.close();

                return id;
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static void guardarPartida(String user, int dificultat, int moviments, int temps) {

        insertUser(user);
        int id_user = getUserId(user);

        if (id_user == -1) {
            System.out.println("Error obtenint id usuari");
            return;
        }

        String sql = """
                insert into  partida(dificultat, moviments, temps, id_user)
                values(?, ?, ?, ?)
                """;
        try {

            Connection con = DriverManager.getConnection(db_url, username, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, dificultat);
            ps.setInt(2, moviments);
            ps.setInt(3, temps);
            ps.setInt(4, id_user);

            ps.executeUpdate();

            ps.close();
            con.close();

            System.out.println("Partida guardada correctament");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}