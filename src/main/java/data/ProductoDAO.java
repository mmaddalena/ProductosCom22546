package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Producto;

public class ProductoDAO {
    private static final String SQL_SELECT = "SELECT * FROM productos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM productos WHERE idproducto = ?";
   
    private static final String SQL_INSERT = "INSERT INTO productos(nombre, precio, cantidad, descripcion, imagen) VALUES(?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ?, descripcion = ?, imagen = ? WHERE idproducto = ?";
    
    private static final String SQL_DELETE = "DELETE FROM productos WHERE idproducto = ?";

    public List<Producto> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idproducto = rs.getInt(1);
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");
                String imagen = rs.getString("imagen");

                producto = new Producto(idproducto, nombre, precio, cantidad, descripcion, imagen);

                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return productos;
    }
    
    public Producto listarPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idproducto = rs.getInt("idproducto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");
                String imagen = rs.getString("imagen");

                producto = new Producto(idproducto, nombre, precio, cantidad, descripcion, imagen);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return producto;
    }
    
    public int agregar(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.setString(4, producto.getDescripcion());
            stmt.setString(5, producto.getImagen());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.setString(4, producto.getDescripcion());
            stmt.setString(5, producto.getImagen());
            stmt.setInt(6, producto.getIdproducto());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(int idProducto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();

            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, idProducto);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
