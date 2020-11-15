package dao;

import model.Animals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalsDAO extends HelperDAO implements BaseDAO<Animals> {
    private static final String INSERT_ANIMAL_SQL = "INSERT INTO animals" + "  (animalImage, animalDescription, animalProtectionLevel,animalName,staffID) VALUES " +
            " (?, ?, ?,?,?);";
    private static final String SELECT_ANIMAL_BY_ID = "select *  from animals where animalID =?;";
    private static final String SELECT_ALL_ANIMAL = "select * from animals;";
    private static final String DELETE_ANIMAL_SQL = "delete from animals where animalID = ?;";
    private static final String UPDATE_ANIMAL_SQL = "update animals set animalImage = ?,animalDescription= ?, animalProtectionLevel =?,animalName=?,staffID=? where animalID = ?;";
    private static final String SORT_ALL_ANIMALS_ASC = "SELECT * from animals order by animalName ASC;";
    private static final String SORT_ALL_ANIMALS_DESC = "SELECT * from animals order by animalName DESC;";
    private static final String SEARCH_WITH_NAME = "SELECT * from animals where animalName LIKE concat('%',?,'%');";
    private static final String SEARCH_WITH_PROTECTION_LEVEL = "SELECT * FROM animals where animalProtectionLevel =?;";


    @Override
    public List<Animals> findAll() throws Exception {
        List<Animals> animals = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ANIMAL);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("animalID");
                String image = rs.getString("animalImage");
                String description = rs.getString("animalDescription");
                int protectionLevel = rs.getInt("animalProtectionLevel");
                String name = rs.getString("animalName");
                int staffID = rs.getInt("staffID");
                animals.add(new Animals(id, name, image, description, protectionLevel, staffID));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return animals;

    }


    @Override
    public void add(Animals animal) throws Exception {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANIMAL_SQL)) {
            preparedStatement.setString(1, animal.getImage());
            preparedStatement.setString(2, animal.getDescription());
            preparedStatement.setInt(3, animal.getProtectionLevel());
            preparedStatement.setString(4, animal.getName());
            preparedStatement.setInt(5, animal.getStaffID());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public boolean update(Animals animal) throws Exception {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ANIMAL_SQL);) {
            statement.setString(1, animal.getImage());
            statement.setString(2, animal.getDescription());
            statement.setInt(3, animal.getProtectionLevel());
            statement.setString(4, animal.getName());
            statement.setInt(5, animal.getStaffID());
            statement.setInt(6, animal.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    @Override
    public boolean delete(Animals animal) throws Exception {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL_SQL);) {
            statement.setInt(1, animal.getId());
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Animals findById(int id) throws Exception {
        Animals animal = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANIMAL_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String image = rs.getString("animalImage");
                String description = rs.getString("animalDescription");
                int protectionLevel = rs.getInt("animalProtectionLevel");
                String name = rs.getString("animalName");
                int staffID = rs.getInt("staffID");

                animal = new Animals(id, name, image, description, protectionLevel, staffID);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return animal;
    }

    public List<Animals> searchWithName(String nameOfAnimal) {
        List<Animals> animals = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_WITH_NAME)) {
            preparedStatement.setString(1, nameOfAnimal);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("animalID");
                String image = rs.getString("animalImage");
                String description = rs.getString("animalDescription");
                int protectionLevel = rs.getInt("animalProtectionLevel");
                String name = rs.getString("animalName");
                int staffID = rs.getInt("staffID");

//                Type type = new Type(type_idtype, nameType);
//                Producer producer = new Producer(rs.getString("producerName"), rs.getInt("producer_id_producer"));
//                Product product = new Product(id, price, description, name, amount, image, productcol, evaluate, discount, type, producer);
//                product.setType(type);
                Animals animal = new Animals(id, name, image, description, protectionLevel, staffID);
                animals.add(animal);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return animals;
    }

    public List<Animals> selectByProtectionLevel(int protectionLevelID) {
        List<Animals> animalsList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_WITH_PROTECTION_LEVEL)) {
            preparedStatement.setInt(1, protectionLevelID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("animalID");
                String image = rs.getString("animalImage");
                String description = rs.getString("animalDescription");
                int protectionLevel = rs.getInt("animalProtectionLevel");
                String name = rs.getString("animalName");
                int staffID = rs.getInt("staffID");

                animalsList.add(new Animals(id, name, image, description, protectionLevel, staffID));
            }
        } catch (SQLException ignored) {

        }
        return animalsList;
    }
}


