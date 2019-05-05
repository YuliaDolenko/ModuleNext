package JDBС;

import java.sql.*;

public class CRUD {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/moduleNext?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "1234";

    static Connection conn = null;
    static Statement stmt = null;

    public static void selectListOfClients() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = String.format("SELECT CONCAT(`customer`.`name`, ' ' , `customer`.`surname`) AS FIO " +
                    "FROM `customer` " +
                    "ORDER BY `customer`.`name`;");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                String name = rs.getString("FIO");

                System.out.println("FIO: " + name);

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
    }

    public static void selectHotelRoomsWithComfortLux() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = String.format("SELECT `hotel_room`.`id_hotel_room`" +
                    "FROM `hotel_room` " +
                    "WHERE `hotel_room`.`capacity` <= 3;");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int id_hotel_room = rs.getInt("id_hotel_room");

                System.out.println("Hotel room number: " + id_hotel_room);

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
    }

    public static void selectListOfBookedRoomsForSpecificDate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = String.format("SELECT `hotel_room`.`id_hotel_room`" +
                    "FROM `hotel_room`" +
                    "JOIN `orders`" +
                    "ON `hotel_room`.`id_hotel_room` = `orders`.`id_order`" +
                    "WHERE `hotel_room`.`booking` = 'BOOKED' " +
                    "AND DAY(`orders`.`release_date`) = 25 " +
                    "AND MONTH(`orders`.`release_date`) = 2 " +
                    "AND YEAR(`orders`.`release_date`) = 2011;");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int id_hotel_room = rs.getInt("id_hotel_room");

                System.out.println("Hotel room number: " + id_hotel_room);

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
    }

    public static void selectDiscountForSpecificCustomer() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = String.format("SELECT `customer`.`name`, `discount`.`discount_percentage`" +
                    "FROM `customer`" +
                    "JOIN `discount`" +
                    "ON `customer`.`id_customer` = `discount`.`id_discount`" +
                    "WHERE `customer`.`name` = 'Alex';");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                String name = rs.getString("name");
                int discount_percentage = rs.getInt("discount_percentage");

                System.out.println("Name: " + name + " ");
                System.out.println("Discount percentage: " + discount_percentage);

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
    }

    public static void selectlistOfAvailablePlaces() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = String.format("SELECT `hotel_room`.`id_hotel_room`, `hotel_room`.`comfort`, `hotel_room`.`price`" +
                    "FROM `hotel_room`" +
                    "WHERE price < 350 " +
                    "ORDER BY price DESC;");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                String comfort = rs.getString("comfort");
                int id_hotel_room = rs.getInt("id_hotel_room");
                int price = rs.getInt("price");

                System.out.print("Hotel room number: " + id_hotel_room + " ");
                System.out.print(", Comfort: " + comfort + " ");
                System.out.println(", Price: " + price);

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
    }

    public static void selectHotelRoom23() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = String.format("SELECT  `customer`.`name`, ((`hotel_room`.`price` - `discount`.`discount_percentage`)*3)" +
                    "FROM `hotel_room` " +
                    "JOIN `discount`" +
                    "ON `hotel_room`.`id_hotel_room` = `discount`.`id_discount`" +
                    "JOIN `customer`" +
                    "ON `hotel_room`.`id_hotel_room` = `customer`.`id_customer`" +
                    "where `hotel_room`.`id_customer` = 23" +
                    ";");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                int final_price = rs.getInt("((`hotel_room`.`price` - `discount`.`discount_percentage`)*3)");
                System.out.print("Final price: " + final_price + " ");
                System.out.println(", Name: " + name);

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
    }

    public static void insertRecord() {
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

    public static void createEntityDiscount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = String.format("CREATE TABLE Discount" +
                    "(" +
                    "  id_discount  INTEGER NULL," +
                    "  discount_percentage  VARCHAR(20) NULL," +
                    "  count_discount  VARCHAR(20) NULL," +
                    "   PRIMARY KEY (id_discount)" +
                    ")" +
                    ";");
            stmt.execute(sql);
            System.out.println("Created table in given database...");
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

    public static void createEntityCustomer() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = String.format("CREATE TABLE Customer" +
                    "(" +
                    "  id_customer  INTEGER NULL," +
                    "  name  VARCHAR(20) NULL," +
                    "  surname  VARCHAR(20) NULL," +
                    "  comment  VARCHAR(20) NULL," +
                    "  id_discount  INTEGER NOT NULL," +
                    "  PRIMARY KEY (id_customer, id_discount)," +
                    "  FOREIGN KEY R_8 (id_discount) REFERENCES Discount(id_discount)" +
                    ")" +
                    ";");
            stmt.execute(sql);
            System.out.println("Created table in given database...");
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

    public static void createEntityOrders() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = String.format("CREATE TABLE orders" +
                    "(" +
                    "  id_order  INTEGER NULL," +
                    "  arrival_date  DATE NULL," +
                    "  release_date  DATE NULL," +
                    "  id_customer  INTEGER NOT NULL," +
                    "  id_discount  INTEGER NOT NULL," +
                    "  PRIMARY KEY (id_order,id_customer,id_discount), FOREIGN KEY R_12 (id_customer,id_discount) REFERENCES Customer(id_customer,id_discount)" +
                    ")" +
                    ";");

            stmt.execute(sql);
            System.out.println("Created table in given database...");
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

    public static void createEntityHotelRooms() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = String.format("CREATE TABLE hotel_room" +
                    "(" +
                    "  id_hotel_room  CHAR(18) NULL," +
                    "  capacity  INTEGER NULL," +
                    "  comfort  VARCHAR(20) NULL," +
                    "  price  INTEGER NULL," +
                    "  booking  DATE NULL," +
                    "  id_order  INTEGER NULL," +
                    "  id_customer  INTEGER NULL," +
                    "  id_discount  INTEGER NULL," +
                    "  PRIMARY KEY (id_hotel_room), FOREIGN KEY R_10 (id_order,id_customer,id_discount) REFERENCES orders(id_order,id_customer,id_discount)" +
                    ")" +
                    ";");

            stmt.execute(sql);
            System.out.println("Created table in given database...");
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
}




