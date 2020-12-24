package ru.netology.web.info;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.$;

public class SQLHelper {

    public static String getCode() {
        val codesSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1;";
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

    public static void clear() {
        val authSQL = "DELETE FROM auth_codes";
        val transactionsSQL = "DELETE FROM card_transactions";
        val cardSQL = "DELETE FROM cards";
        val userSQL = "DELETE FROM users";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            runner.update(conn, authSQL);
            runner.update(conn, transactionsSQL);
            runner.update(conn, cardSQL);
            runner.update(conn, userSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}



