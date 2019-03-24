package nl.hsleiden.persistence;

import nl.hsleiden.DBConnection;
import nl.hsleiden.model.Mask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaskDAO {

    public List<Mask> getAll() {
        List<Mask> maskList = new ArrayList<>();
        Connection connection = DBConnection.createConnection();

        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mask mask = new Mask();
                mask.setProductNr(rs.getInt(""));
                mask.setBrand(rs.getString(""));
                mask.setName(rs.getString(""));
                mask.setPrice(rs.getInt(""));
                maskList.add(mask);
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return maskList;
    }

    public Optional<Mask> get(int id) {
        Mask mask = new Mask();
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                mask.setProductNr(rs.getInt(""));
                mask.setBrand(rs.getString(""));
                mask.setName(rs.getString(""));
                mask.setPrice(rs.getInt(""));
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return Optional.of(mask);
    }

    public void save(Mask mask) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mask.getProductNr());
            ps.setString(2, mask.getName());
            ps.setString(4, mask.getBrand());
            ps.setInt(6, mask.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void update(Mask mask) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mask.getProductNr());
            ps.setString(2, mask.getName());
            ps.setString(4, mask.getBrand());
            ps.setInt(6, mask.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void delete(Mask mask) {

        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mask.getProductNr());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }
}
