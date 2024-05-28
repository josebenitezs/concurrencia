
package com.iudigital.concurrency.snthread;

import com.iudigital.concurrency.domain.ClienteProducto;
import com.iudigital.concurrency.domain.Producto;



public class CajeraProducto {

   private String CajeraProducto;
   
   
   private String nombreCajera;

    public CajeraProducto( String nombreCajera) {
        this.nombreCajera = nombreCajera;
    }
   
   
    public void  procesarCompra(ClienteProducto cliente, long timeStanp){
        System.out.println("La cajera " + this.nombreCajera + " Comiensa a procesar la compra del cliente "
         + cliente.getNombre() + " en el tiempo " +(System.currentTimeMillis()- timeStanp) / 1000
         + "seg ");
        
        int conCliente = 1;
        
        for(Producto producto : cliente.getProductos()){
            this.esperarXSegundos();
            System.out.println("procesando el producto " + conCliente
                    + " nombre producto " + producto.getNombre()
                    + " precio producto " + producto.getPrecio()
                    + " cantidad de productos " + producto.getCantidad()
                    + " costo total del producto " + producto.getCantidad() * producto.getPrecio()
                    + " ->Tiempo: " + (System.currentTimeMillis() - timeStanp) / 1000 + "seg");
            System.out.println("==================================================================");
                    
                    
        }
        System.out.println("La cajera " + this.nombreCajera + " ha terminado de procesar a " + cliente.getNombre()
                            + " en el tiempo " + (System.currentTimeMillis() - timeStanp) / 1000 + "seg");
    }

    private void esperarXSegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
