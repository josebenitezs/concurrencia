
package com.iudigital.concurrency.snthread;

import com.iudigital.concurrency.domain.ClienteProducto;
import com.iudigital.concurrency.domain.Producto;
import java.util.ArrayList;
import java.util.List;


public class CajeraProductoMain {
   
    public static void main(String[] args){
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);
        
        ClienteProducto cliente1 = new ClienteProducto(" Tony Stark" , productos);
        ClienteProducto cliente2 = new ClienteProducto(" Superman" , productos);
        ClienteProducto cliente3 = new ClienteProducto(" Acuaman" , productos);
        
        long initialTime = System.currentTimeMillis();
        CajeraProducto cajeraUno = new CajeraProducto("Cajera Valentina");
        CajeraProducto cajeraDos = new CajeraProducto("Cajera Paola");
        CajeraProducto cajeraTres = new CajeraProducto("Cajera Franchesca");
        
        
        cajeraUno.procesarCompra(cliente1, initialTime);
        cajeraDos.procesarCompra(cliente2, initialTime);
        cajeraTres.procesarCompra(cliente3, initialTime);
    }
    
    private static void setProductos(List<Producto> productos){
        
        Producto productoUno = new Producto("Zapatos", 500, 6);
        Producto productoDos = new Producto("Pantalones", 800, 18);
        Producto productoTres = new Producto("Camisas", 500, 46);
        
        productos.add(productoUno);
        productos.add(productoDos);
        productos.add(productoTres);
    }
    
    
}
