
package com.iudigital.concurrency.withread;

import com.iudigital.concurrency.domain.ClienteProducto;
import com.iudigital.concurrency.domain.Producto;


  
    

public class CajeraThreand extends Thread {
    private String nombre;
    private ClienteProducto clienteProducto;
    
    public CajeraThreand(String nombre, ClienteProducto clienteProducto) {
        this.nombre = nombre;
        this.clienteProducto = clienteProducto;
         this.setPriority(Thread.MIN_PRIORITY); 
    }
    
    
  
    public String getNombre() {
        return nombre;
    }
    
    private void procesarCompra(ClienteProducto cliente, long timeStanp) {
        System.out.println("La cajera " + this.nombre + " comiensa a procesar la compra del cliente "  + clienteProducto.getNombre() + "en el tiempo " 
                + (System.currentTimeMillis()- timeStanp) / 1000 + "seg ");
        System.out.println();  
        
        int conCliente = 1;
        
        for(Producto producto : clienteProducto.getProductos()){
            this.esperarXSegundos();
            System.out.println();  
            System.out.println("procesando el producto " + conCliente
                    + " nombre producto " + producto.getNombre()
                    + " precio producto " + producto.getPrecio()
                    + " cantidad de productos " + producto.getCantidad()
                    + " costo total del producto " + producto.getCantidad() * producto.getPrecio()
                    + " ->Tiempo: " + (System.currentTimeMillis() - timeStanp) / 1000 + "seg");
            System.out.println("================================================================================================");
            System.out.println();       
                    
        }
        System.out.println("La cajera " + this.nombre + " ha terminado de procesar a " + clienteProducto.getNombre()
                            + " en el tiempo " + (System.currentTimeMillis() - timeStanp) / 1000 + "seg");
        
    }
    
      @Override
    public void run() {
        procesarCompra(clienteProducto, System.currentTimeMillis());
    }
    
    private void esperarXSegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    
   
}
}
 