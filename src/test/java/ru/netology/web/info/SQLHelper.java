package ru.netology.web.info;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.AfterAll;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;

import static com.codeborne.selenide.Selenide.$;

public class SQLHelper {

    public static String getCode() {
        val codesSQL = "SELECT code FROM auth_codes ORDER BY create DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            val codes = runner.query(conn, codesSQL, new ScalarHandler<>());
            return String.valueOf(codes);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;

    }

    public static int clear(String[] args) {
        val rowsSQL = "DELETE FROM auth_codes";
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {

            val rows = runner.query(conn, rowsSQL, new ScalarHandler<>());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}



