package database;

import objects.Coordinates;
import objects.Difficulty;
import objects.Discipline;
import objects.LabWork;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.HashMap;

public class DatabaseService {
    private static DatabaseService ds;
    private final static String INSERT_LABWORK_SQL = "INSERT INTO labworks" +
            "  (id, labname, coordinate_x, coordinate_y, minimal_point, difficulty, discipline, self_study_hours, creation_date, labwork_id, author) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
    private final static String CLEAR_SQL = "DELETE FROM labworks WHERE author = ?";
    private final static String CLEAR_SQL_ALL = "TRUNCATE TABLE labworks";
    private final static String REMOVE_BY_KEY_SQL = "DELETE FROM labworks WHERE id = ? and author = ?;";
    private final static String ADD_USER_SQL = "INSERT INTO users (\"user\", password) VALUES (?, ?);";
    private final static String UPDATE_SQL = "UPDATE labworks SET labname = ?, coordinate_x = ?, coordinate_y = ?," +
            " minimal_point = ?, difficulty = ?, discipline = ?, self_study_hours = ?" +
            ", creation_date = ? WHERE labwork_id = ? and author = ?;";
    private final static String REMOVE_LOWER_SQL = "DELETE FROM labworks WHERE labwork_id < ? and author = ?";
    private final static String REMOVE_BY_DISCIPLINE_SQL = "DELETE FROM labworks WHERE discipline = ? and self_study_hours = ? and author = ?";
    private final static String GET_SQL = "SELECT * FROM labworks";
    private final static String GET_USERS = "SELECT * FROM users";

    public DatabaseService() {
        ds = this;
    }

    public HashMap<String, LabWork> getCollection() throws SQLException {
        HashMap<String, LabWork> collection = new HashMap<>();
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_SQL);
        while (resultSet.next()) {
            LabWork labWork = new LabWork(resultSet.getString(2),
                    new Coordinates(resultSet.getFloat(3), resultSet.getFloat(4)),
                    resultSet.getLong(5),
                    Difficulty.valueOf(resultSet.getString(6)),
                    new Discipline(resultSet.getString(7), resultSet.getLong(8)),
                    resultSet.getString(9),
                    resultSet.getString(10));
            collection.put(resultSet.getString(1), labWork);
        }
        return collection;
    }

    public void update(int id, LabWork labWork) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
        preparedStatement.setInt(9, id);
        preparedStatement.setString(1, labWork.getName());
        preparedStatement.setDouble(2, labWork.getCoordinates().getX());
        preparedStatement.setDouble(3, labWork.getCoordinates().getY());
        preparedStatement.setLong(4, labWork.getMinimalPoint());
        preparedStatement.setString(5, labWork.getDifficulty().toString());
        preparedStatement.setString(6, labWork.getDiscipline().getName());
        preparedStatement.setLong(7, labWork.getDiscipline().getSelfStudyHours());
        preparedStatement.setString(8, labWork.getCreationDate().toString());
        preparedStatement.setString(10, labWork.getAuthor());
        preparedStatement.execute();
    }
    public void remove(String key, String auth) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BY_KEY_SQL);
        preparedStatement.setInt(1, Integer.parseInt(key));
        preparedStatement.setString(2, auth);
        preparedStatement.execute();
    }
    public void clear() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CLEAR_SQL_ALL);
        preparedStatement.execute();
    }

    public void user_clear(String user) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CLEAR_SQL);
        preparedStatement.setString(1, user);
        preparedStatement.execute();
    }

    public void removeAllLower(LabWork labWork) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_LOWER_SQL);
        preparedStatement.setLong(1, labWork.getId());
        preparedStatement.setString(2, labWork.getAuthor());
        preparedStatement.execute();
    }
    public void removeByDiscipline(Discipline discipline, String user) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BY_DISCIPLINE_SQL);
        preparedStatement.setString(1, discipline.getName());
        preparedStatement.setLong(2, discipline.getSelfStudyHours());
        preparedStatement.setString(3, user);
        preparedStatement.execute();

    }
    public void insert(String key, LabWork labWork) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LABWORK_SQL);
        preparedStatement.setInt(1, Integer.parseInt(key));
        preparedStatement.setString(2, labWork.getName());
        preparedStatement.setDouble(3, labWork.getCoordinates().getX());
        preparedStatement.setDouble(4, labWork.getCoordinates().getY());
        preparedStatement.setLong(5, labWork.getMinimalPoint());
        preparedStatement.setString(6, labWork.getDifficulty().toString());
        preparedStatement.setString(7, labWork.getDiscipline().getName());
        preparedStatement.setLong(8, labWork.getDiscipline().getSelfStudyHours());
        preparedStatement.setString(9, labWork.getCreationDate().toString());
        preparedStatement.setInt(10, labWork.getId());
        preparedStatement.setString(11, labWork.getAuthor());
        preparedStatement.execute();
    }


    public synchronized static DatabaseService getInstance() {
        return ds;
    }

    public void addUser(String pass, String user) throws SQLException{
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_SQL);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, hash(pass));
        preparedStatement.execute();
    }

    public String hash(String input) {
        try {
            // getInstance() method is called with algorithm SHA-224
            MessageDigest md = MessageDigest.getInstance("SHA-224");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUser(String user, String pass) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            if (user.equals(resultSet.getString(1))
                    && hash(pass).equals(resultSet.getString(2))) return true;
        }
        return false;
    }
}
