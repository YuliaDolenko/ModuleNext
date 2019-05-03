package JDBС;

import java.sql.*;

public class JDBCDataReader {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/moduleNext?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "1234";


    public static void main(String[] args) {
//        selectRecord();
//        insertRecord();
//        updateRecord();
//        deleteRecord();
        createRecord();
    }

    public static void selectRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Customer";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("id");
                String name = rs.getString("name");
//                String last_name = rs.getString("last_name");
//                String email = rs.getString("last_name");
//                String gender = rs.getString("gender");
//                String ip_address = rs.getString("ip_address");
//
                System.out.print("ID: " + ID);
                System.out.println(", First_name: " + name);
//                System.out.println(", Last_name: " + last_name);
//                System.out.println(", Email: " + email);
//                System.out.println(", Gender: " + gender);
//                System.out.println(", Ip_address: " + ip_address);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public static void insertRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO Customer VALUES (1001, 'Alex', 'sss', 'asdas@sdafa.sa', 'F', 'aaa');";
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void updateRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "UPDATE mock_data SET ip_address = '8.8.8.8' WHERE gender = 'Female';";
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void deleteRecord() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "DELETE FROM mock_data WHERE ID = 1002;";
            stmt.execute(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void createRecord(){
            Connection conn = null;
            Statement stmt = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");

                System.out.println("Creating table in given database...");
                stmt = conn.createStatement();

//                String sql = "CREATE TABLE Customer " +
//                        "(customer_ID INTEGER not NULL, " +
//                        " name VARCHAR(30), " +
//                        " surname VARCHAR(30), " +
//                        " comment VARCHAR(30), " +
//                        " discount VARCHAR(30), " +
//                        " countBookings INTEGER(15), " +
//                        " primary key(customer_ID), " +
//                        " foreign key(customer_ID) references hotel_room(id))";
                String sql = "CREATE TABLE Customer " +
                        "(customer_ID INTEGER not NULL, " +
                        " name VARCHAR(30), " +
                        " surname VARCHAR(30), " +
                        " comment VARCHAR(30), " +
                        " discount VARCHAR(30), " +
                        " countBookings INTEGER(15), " +
                        " primary key(customer_ID), " +
                        " foreign key(customer_ID) references hotel_room(id))";

                stmt.execute(sql);
                System.out.println("Created table in given database...");
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){
                }
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");
        }
    }




