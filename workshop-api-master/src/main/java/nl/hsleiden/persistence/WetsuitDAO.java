package nl.hsleiden.persistence;

import nl.hsleiden.DBConnection;
import nl.hsleiden.model.Wetsuit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO zet @singleton bij elke dao

public class WetsuitDAO {

    public List<Wetsuit> getAll() {
        List<Wetsuit> wetsuitList = new ArrayList<>();
        Connection connection = DBConnection.createConnection();

        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Wetsuit wetsuit = new Wetsuit();
                wetsuit.setProductNr(rs.getInt(""));
                wetsuit.setBrand(rs.getString(""));
                wetsuit.setMaterial(rs.getString(""));
                wetsuit.setName(rs.getString(""));
                wetsuit.setPrice(rs.getInt(""));
                wetsuit.setSize(rs.getString(""));
                wetsuit.setThickness(rs.getInt(""));
                wetsuitList.add(wetsuit);
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return wetsuitList;
    }

    public Optional<Wetsuit> get(int id) {

        Wetsuit wetsuit = new Wetsuit();
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                wetsuit.setProductNr(rs.getInt(""));
                wetsuit.setBrand(rs.getString(""));
                wetsuit.setMaterial(rs.getString(""));
                wetsuit.setName(rs.getString(""));
                wetsuit.setPrice(rs.getInt(""));
                wetsuit.setSize(rs.getString(""));
                wetsuit.setThickness(rs.getInt(""));
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return Optional.of(wetsuit);
    }

    public void save(Wetsuit wetsuit) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, wetsuit.getProductNr());
            ps.setString(2, wetsuit.getName());
            ps.setString(3, wetsuit.getMaterial());
            ps.setString(4, wetsuit.getBrand());
            ps.setString(5, wetsuit.getSize());
            ps.setInt(6, wetsuit.getPrice());
            ps.setInt(7, wetsuit.getThickness());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    //TODO als er nog tijd over is optimaliseer de code
    public void update(Wetsuit wetsuit) {

        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, wetsuit.getProductNr());
            ps.setString(2, wetsuit.getName());
            ps.setString(3, wetsuit.getMaterial());
            ps.setString(4, wetsuit.getBrand());
            ps.setString(5, wetsuit.getSize());
            ps.setInt(6, wetsuit.getPrice());
            ps.setInt(7, wetsuit.getThickness());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);

    }

    public void delete(Wetsuit wetsuit) {

        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, wetsuit.getProductNr());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);

    }
}
