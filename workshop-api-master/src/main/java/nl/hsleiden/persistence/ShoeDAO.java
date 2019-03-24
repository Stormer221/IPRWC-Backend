package nl.hsleiden.persistence;

import nl.hsleiden.DBConnection;
import nl.hsleiden.model.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoeDAO {

    public List<Shoe> getAll() {
        List<Shoe> shoeList = new ArrayList<>();
        Connection connection = DBConnection.createConnection();

        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Shoe shoe = new Shoe();
                shoe.setProductNr(rs.getInt(""));
                shoe.setBrand(rs.getString(""));
                shoe.setName(rs.getString(""));
                shoe.setPrice(rs.getInt(""));
                shoe.setSize(rs.getInt(""));
                shoeList.add(shoe);
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return shoeList;
    }

    public Optional<Shoe> get(int id) {
        Shoe shoe = new Shoe();
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                shoe.setProductNr(rs.getInt(""));
                shoe.setBrand(rs.getString(""));
                shoe.setName(rs.getString(""));
                shoe.setPrice(rs.getInt(""));
                shoe.setSize(rs.getInt(""));
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return Optional.of(shoe);
    }

    public void save(Shoe shoe) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, shoe.getProductNr());
            ps.setString(2, shoe.getName());
            ps.setString(4, shoe.getBrand());
            ps.setInt(5, shoe.getSize());
            ps.setInt(6, shoe.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void update(Shoe shoe) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, shoe.getProductNr());
            ps.setString(2, shoe.getName());
            ps.setString(4, shoe.getBrand());
            ps.setInt(5, shoe.getSize());
            ps.setInt(6, shoe.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void delete(Shoe shoe) {

        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, shoe.getProductNr());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }
}
