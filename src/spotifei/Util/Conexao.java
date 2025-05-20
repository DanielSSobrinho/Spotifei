/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daniel.sobrinho
 */
public class Conexao {
    public static Connection getConnection() throws SQLException{ // ****alterei para static aqui****
        Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Spotifei",
                "postgres", "fei");
        return conexao;
    }
}
