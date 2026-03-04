package ch01;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class Main { // クラスの開始

    @Test
    void testDbConnection() {
        // 接続情報
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "pass";

        // 接続テスト
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            assertNotNull(conn, "接続オブジェクトが取得できること");
            System.out.println("データベース接続成功！");
        } catch (SQLException e) {
            fail("接続失敗: " + e.getMessage());
        }
    }
} // クラスの終了