package controller;

import data.ProductoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Producto;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");

        if (accionJava != null) {
            switch (accionJava) {
                case "editar":
                    editarProducto(req, res);
                    break;

                case "eliminar":
                    eliminarProducto(req, res);
                    break;

                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");

        if (accionJava != null) {
            switch (accionJava) {
                case "insertar":
                    agregarProducto(req, res);
                    break;

                case "modificar":
                    modificarProducto(req, res);
                    break;

                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Producto> productos = new ProductoDAO().listar();
        productos.forEach(System.out::println);

        HttpSession session = req.getSession();

        session.setAttribute("productos", productos);
        session.setAttribute("totalProductos", productos.size());
        session.setAttribute("totalPrecio", calcularPrecios(productos));
        res.sendRedirect("productos.jsp");
    }

    private double calcularPrecios(List<Producto> productos) {
        double precioTotal = 0;

        for (int i = 0; i < productos.size(); i++) {
            precioTotal += productos.get(i).getPrecio() * productos.get(i).getCantidad();
        }
        return precioTotal;
    }

    private void agregarProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String imagen = req.getParameter("imagen");
        
        double precio = 0;
        String precioString = req.getParameter("precio");
        if(precioString != null && !precioString.equals("")){
           precio = Double.parseDouble(precioString);
        }
        
        int cantidad = 0;
        String cantidadString = req.getParameter("cantidad");
        if(cantidadString != null && !cantidadString.equals("")){
           cantidad = Integer.parseInt(cantidadString);
        }

        Producto producto = new Producto(nombre, precio, cantidad, descripcion, imagen);

        int registrosModificados = new ProductoDAO().agregar(producto);

        System.out.println("Registros guardados: " + registrosModificados);

        accionDefault(req, res);
    }

    private void editarProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idProducto = Integer.parseInt(req.getParameter("idProducto"));

        Producto producto = new ProductoDAO().listarPorId(idProducto);

        req.setAttribute("producto", producto);
        String jspEditar = "/WEB-INF/paginas/operaciones/editarProducto.jsp";

        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    private void modificarProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idproducto = Integer.parseInt(req.getParameter("idProducto"));
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String imagen = req.getParameter("imagen");
        
        double precio = 0;
        String precioString = req.getParameter("precio");
        if(precioString != null && !precioString.equals("")){
           precio = Double.parseDouble(precioString);
        }
        
        int cantidad = 0;
        String cantidadString = req.getParameter("cantidad");
        if(cantidadString != null && !cantidadString.equals("")){
           cantidad = Integer.parseInt(cantidadString);
        }

        Producto producto = new Producto(idproducto, nombre, precio, cantidad, descripcion, imagen);

        int registrosModificados = new ProductoDAO().actualizar(producto);

        System.out.println("Registros actualizados: " + registrosModificados);

        accionDefault(req, res);
    }

    private void eliminarProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idproducto = Integer.parseInt(req.getParameter("idProducto"));

        int registrosBorrados = new ProductoDAO().eliminar(idproducto);

        System.out.println("Registros Eliminados: " + registrosBorrados);

        accionDefault(req, res);
    }

}
