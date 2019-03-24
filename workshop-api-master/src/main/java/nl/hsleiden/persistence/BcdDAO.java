package nl.hsleiden.persistence;

import nl.hsleiden.DBConnection;
import nl.hsleiden.model.BCD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BcdDAO  {

    public List<BCD> getAll() {
        List<BCD> bcdList = new ArrayList<>();
        Connection connection = DBConnection.createConnection();

        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BCD bcd = new BCD();
                bcd.setProductNr(rs.getInt(""));
                bcd.setBrand(rs.getString(""));
                bcd.setName(rs.getString(""));
                bcd.setPrice(rs.getInt(""));
                bcd.setSize(rs.getString(""));
                bcdList.add(bcd);
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return bcdList;
    }

    public Optional<BCD> get(int id) {
        BCD bcd = new BCD();
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                bcd.setProductNr(rs.getInt(""));
                bcd.setBrand(rs.getString(""));
                bcd.setName(rs.getString(""));
                bcd.setPrice(rs.getInt(""));
                bcd.setSize(rs.getString(""));
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return Optional.of(bcd);
    }

    public void save(BCD bcd) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bcd.getProductNr());
            ps.setString(2, bcd.getName());
            ps.setString(4, bcd.getBrand());
            ps.setString(5, bcd.getSize());
            ps.setInt(6, bcd.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void update(BCD bcd) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bcd.getProductNr());
            ps.setString(2, bcd.getName());
            ps.setString(4, bcd.getBrand());
            ps.setString(5, bcd.getSize());
            ps.setInt(6, bcd.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void delete(BCD bcd) {

        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bcd.getProductNr());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }
}
