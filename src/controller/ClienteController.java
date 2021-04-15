package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Cliente;

public class ClienteController {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public ClienteController() {
        this.loadData();
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public Cliente findById(Integer id) {
        Iterator<Cliente> lista = this.clientes.iterator();
        while (lista.hasNext()) {
            Cliente cliente = lista.next();
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente findByLogin(String login) {
        Iterator<Cliente> lista = this.clientes.iterator();
        while (lista.hasNext()) {
            Cliente cliente = lista.next();
            if (cliente.getLogin().equals(login)) {
                return cliente;
            }
        }
        return null;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        this.saveData();
    }

    public void saveData() {
        try {
            FileOutputStream f = new FileOutputStream(new File("Clientes.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            Iterator<Cliente> clientes = this.clientes.iterator();
            while (clientes.hasNext()) {
                o.writeObject(clientes.next());
            }

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public void loadData() {
        try {
            FileInputStream fi = new FileInputStream(new File("Clientes.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Boolean eof = false;
            this.clientes = new ArrayList<Cliente>();
            while (!eof) {
                this.clientes.add((Cliente) oi.readObject());
            }

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
