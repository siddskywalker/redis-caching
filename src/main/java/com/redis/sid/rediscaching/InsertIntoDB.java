// package com.redis.sid.rediscaching;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.Random;

// public class InsertIntoDB {

//     private static final String DB_URL = "jdbc:mysql://localhost:3306/redis";
//     private static final String USER = "root";
//     private static final String PASSWORD = "password";

//     private static final int NUMBER_OF_RECORDS = 2000;
//     private static final String[] TITLES = {"The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice", "The Catcher in the Rye", "The Hobbit", "Moby-Dick", "Hamlet", "War and Peace", "The Odyssey"};
//     private static final String[] AUTHORS = {"F. Scott Fitzgerald", "Harper Lee", "George Orwell", "Jane Austen", "J.D. Salinger", "J.R.R. Tolkien", "Herman Melville", "William Shakespeare", "Leo Tolstoy", "Homer"};

//     public static void main(String[] args) {
//         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
//             String insertSQL = "INSERT INTO book (title, author) VALUES (?, ?)";
//             try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
//                 Random random = new Random();
//                 for (int i = 0; i < NUMBER_OF_RECORDS; i++) {
//                     String title = TITLES[random.nextInt(TITLES.length)];
//                     String author = AUTHORS[random.nextInt(AUTHORS.length)];
//                     pstmt.setString(1, title);
//                     pstmt.setString(2, author);
//                     pstmt.executeUpdate();
//                 }
//                 System.out.println("Inserted " + NUMBER_OF_RECORDS + " records into the book table.");
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }

