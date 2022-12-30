package model;

public class Producto {
    private int idproducto;
    private String nombre;
    private Double precio;
    private int cantidad;
    private String descripcion;
    private String imagen;

    public Producto(int idproducto, String nombre, Double precio, int cantidad, String descripcion, String imagen) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Producto(String nombre, Double precio, int cantidad, String descripcion, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Producto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public String toString(){
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", imagen=" + imagen + "}";
    }
}
