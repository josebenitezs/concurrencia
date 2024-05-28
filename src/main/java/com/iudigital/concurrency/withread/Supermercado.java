
package com.iudigital.concurrency.withread;

import com.iudigital.concurrency.domain.ClienteProducto;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<ClienteProducto> clientesProductos;
    private List<CajeraThreand> cajeraThreands;

    public Supermercado() {
        this.clientesProductos = new ArrayList<>();
        this.cajeraThreands = new ArrayList<>();
    }

    public void agregarCliente(ClienteProducto clienteProducto) {
        clientesProductos.add(clienteProducto);
    }

    public void agregarCajera(CajeraThreand cajeraThreand) {
        cajeraThreands.add(cajeraThreand);
    }

    public void iniciarProcesoDeCobro() {
        List<Thread> hilos = new ArrayList<>();
        
        for (int i = 0; i < clientesProductos.size(); i++) {
            CajeraThreand cajeraThreand = cajeraThreands.get(i % cajeraThreands.size());
            ClienteProducto clienteProducto = clientesProductos.get(i);
            CajeraThreand cajeraHilo = new CajeraThreand(cajeraThreand.getNombre(), clienteProducto);
            hilos.add(cajeraHilo);
            cajeraHilo.start();
        }
        
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Todos los clientes han sido atendidos");
    }

    
}
