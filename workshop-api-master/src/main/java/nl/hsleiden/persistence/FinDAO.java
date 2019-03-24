package nl.hsleiden.persistence;

import nl.hsleiden.DBConnection;
import nl.hsleiden.model.Fin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FinDAO {

    public List<Fin> getAll() {
        List<Fin> finList = new ArrayList<>();
        Connection connection = DBConnection.createConnection();

        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fin fin = new Fin();
                fin.setProductNr(rs.getInt(""));
                fin.setBrand(rs.getString(""));
                fin.setName(rs.getString(""));
                fin.setPrice(rs.getInt(""));
                fin.setSize(rs.getInt(""));
                finList.add(fin);
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return finList;
    }

    public Optional<Fin> get(int id) {
        Fin fin = new Fin();
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                fin.setProductNr(rs.getInt(""));
                fin.setBrand(rs.getString(""));
                fin.setName(rs.getString(""));
                fin.setPrice(rs.getInt(""));
                fin.setSize(rs.getInt(""));
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
        return Optional.of(fin);
    }

    public void save(Fin fin) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, fin.getProductNr());
            ps.setString(2, fin.getName());
            ps.setString(4, fin.getBrand());
            ps.setInt(5, fin.getSize());
            ps.setInt(6, fin.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void update(Fin fin) {
        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, fin.getProductNr());
            ps.setString(2, fin.getName());
            ps.setString(4, fin.getBrand());
            ps.setInt(5, fin.getSize());
            ps.setInt(6, fin.getPrice());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }

    public void delete(Fin fin) {

        Connection connection = DBConnection.createConnection();
        String sql = "";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, fin.getProductNr());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        DBConnection.shutdown(connection);
    }
}
