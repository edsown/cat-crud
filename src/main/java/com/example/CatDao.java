package com.example;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatDao {

    String jdbcUrl = Credentials.getJdbcUrl(); 
	String jdbcUser = Credentials.getJdbcUser(); 
    String jdbcPassword = Credentials.getJdbcPassword();
    

    public void registerCat(Cat cat) throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
        
    try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
        String sqlQuery = "INSERT INTO cats.cats(name, tutor_name, tutor_phone, blood_type, date_of_birth, is_castrated) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, cat.getName());
            statement.setString(2, cat.getTutorName());
            statement.setString(3, cat.getTutorPhone());
            statement.setString(4, cat.getBloodType());
            statement.setObject(5, cat.getDateOfBirth());
            statement.setBoolean(6, cat.getIsCastrated());

            statement.executeUpdate(); 
        }
    }
}


   public List<Cat> getAllCats() throws SQLException, ClassNotFoundException {
    List<Cat> allCats = new ArrayList<>();
            Class.forName("org.postgresql.Driver");

    try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
        String sqlQuery = "SELECT * FROM cats.cats";
        
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String tutorName = resultSet.getString("tutor_name");
                String tutorPhone = resultSet.getString("tutor_phone");
                String bloodType = resultSet.getString("blood_type");
                LocalDate dateOfBirth = resultSet.getObject("date_of_birth", LocalDate.class);
                Boolean isCastrated = resultSet.getBoolean("is_castrated");
                Integer id = resultSet.getInt("id");
                Cat cat = new Cat(name, tutorName, tutorPhone, bloodType, dateOfBirth, isCastrated, id);
                allCats.add(cat);
            }
        }
    }
    
    return allCats;
}

    
public Cat getCatById(Integer id) throws ClassNotFoundException {
    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        String sqlQuery = "SELECT * FROM cats.cats WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Cat singleCat = null;
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String tutorName = resultSet.getString("tutor_name");
            String tutorPhone = resultSet.getString("tutor_phone");
            String bloodType = resultSet.getString("blood_type");
            LocalDate dateOfBirth = resultSet.getObject("date_of_birth", LocalDate.class);
            Boolean isCastrated = resultSet.getBoolean("is_castrated");
            singleCat = new Cat(name, tutorName, tutorPhone, bloodType, dateOfBirth, isCastrated, id);
        }
        connection.close();
        return singleCat;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }

}

    
public void updateCatById(Cat cat) throws ClassNotFoundException {
    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        String sqlQuery = "UPDATE cats.cats " +
                  "SET name = ?, tutor_name = ?, tutor_phone = ?, blood_type = ?, date_of_birth = ?, is_castrated = ? " +
                  "WHERE id = ?";

        ;
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, cat.getName());
            statement.setString(2, cat.getTutorName());
            statement.setString(3, cat.getTutorPhone());
            statement.setString(4, cat.getBloodType());
            statement.setObject(5, cat.getDateOfBirth());
            statement.setBoolean(6, cat.getIsCastrated());
            statement.setInt(7, cat.getId());
            statement.executeUpdate();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
    
public void deleteCatById(Integer id) throws ClassNotFoundException {
    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        String sqlQuery = "DELETE FROM cats.cats WHERE id= ?";
        ;
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}

}