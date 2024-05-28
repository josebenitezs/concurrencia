
package com.iudigital.concurrency.withread;

import com.iudigital.concurrency.domain.ClienteProducto;
import com.iudigital.concurrency.domain.Producto;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         Supermercado supermercado = new Supermercado();
         

        // Crear algunos productos
        Producto p1 = new Producto("Leche", 100, 10);
        Producto p2 = new Producto("Pan", 300, 25);
        Producto p3 = new Producto("Huevos", 500, 30);
        Producto p4 = new Producto("Queso", 800, 6);
        Producto p5 = new Producto("Mantequilla", 400, 10);

        // Crear algunos clientes con listas de productos
        List<Producto> productosCliente1 = new ArrayList<>();
        productosCliente1.add(p1);
        productosCliente1.add(p2);

        List<Producto> productosCliente2 = new ArrayList<>();
        productosCliente2.add(p2);
        productosCliente2.add(p3);
        
        List<Producto> productosCliente3 = new ArrayList<>();
        productosCliente3.add(p3);
        productosCliente3.add(p4);
        productosCliente3.add(p5);
        
        ClienteProducto cliente1 = new ClienteProducto("Juan", productosCliente1);
        ClienteProducto cliente2 = new ClienteProducto("Ana", productosCliente2);
        ClienteProducto cliente3 = new ClienteProducto("Pedro", productosCliente3);

        supermercado.agregarCliente(cliente1);
        supermercado.agregarCliente(cliente2);
        supermercado.agregarCliente(cliente3);

        // Crear algunas cajeras
        CajeraThreand cajera1 = new CajeraThreand("Sandra", null);
        CajeraThreand cajera2 = new CajeraThreand("Kelly", null);
        CajeraThreand cajera3 = new CajeraThreand("Laurien", null);

        supermercado.agregarCajera(cajera1);
        supermercado.agregarCajera(cajera2);
        supermercado.agregarCajera(cajera3);

        // Iniciar el proceso de cobro
        supermercado.iniciarProcesoDeCobro();
    }

   
}

    

