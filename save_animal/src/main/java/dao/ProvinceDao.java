package dao;

import model.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDao extends HelperDAO implements BaseDAO<Province> {
    private static String SELECT_ALL_PROVINCE="SELECT * FROM save_animals.provinces;";
    private static String SELECT_PROVINCE_BY_ID="SELECT * FROM save_animals.provinces where provinceID=?;";

    @Override
    public List<Province> findAll() {
        List<Province> provinceList = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROVINCE)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int provinceID=rs.getInt("provinceID");
                String provinceName = rs.getString("provinceName");
                String provinceCode=rs.getString("provinceCode");

                provinceList.add(new Province(provinceID,provinceName,provinceCode));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return provinceList;
    }

    @Override
    public Province findById(int id) {
        Province province = null;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROVINCE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String provinceName = rs.getString("provinceName");
                String provinceCode=rs.getString("provinceCode");
                province=new Province(id,provinceName,provinceCode);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return province;
    }

    @Override
    public void add(Province e) throws SQLException {

    }

    @Override
    public boolean update(Province e) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Province e) throws SQLException {
        return false;
    }


}
