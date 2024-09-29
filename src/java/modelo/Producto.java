package modelo;

public class Producto {
    int producto_id;
    String codigo;
    String descripcion;
    String unidad;
    String precio;
    String peso;
    String volumen;

    public Producto() {
    }

    public Producto(String volumen, String peso, String precio, String unidad, String descripcion, String codigo, int producto_id) {
        this.volumen = volumen;
        this.peso = peso;
        this.precio = precio;
        this.unidad = unidad;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.producto_id = producto_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
}
