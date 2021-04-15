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

import model.Fornecedor;
import model.Produto;

public class FornecedorController {
    private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

    public FornecedorController() {
        this.loadData();
    }

    public List<Produto> getTodosOsProdutos() {
        List<Produto> todosOsProdutos = new ArrayList<Produto>();
        Iterator<Fornecedor> lista = this.fornecedores.iterator();
        while (lista.hasNext()) {
            Fornecedor fornecedor = lista.next();
            Iterator<Produto> produtos = fornecedor.getProdutos().iterator();
            while (produtos.hasNext()) {
                todosOsProdutos.add(produtos.next());
            }
        }
        return todosOsProdutos;
    }

    public Fornecedor getById(Integer id) {
        Iterator<Fornecedor> lista = this.fornecedores.iterator();
        while (lista.hasNext()) {
            Fornecedor fornecedor = lista.next();
            if (fornecedor.getId() == id) {
                return fornecedor;
            }
        }
        return null;
    }

    public void saveData() {
        try {
            FileOutputStream f = new FileOutputStream(new File("Fornecedores.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            Iterator<Fornecedor> fornecedores = this.fornecedores.iterator();
            while (fornecedores.hasNext()) {
                o.writeObject(fornecedores.next());
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
            FileInputStream fi = new FileInputStream(new File("Fornecedores.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Boolean eof = false;
            this.fornecedores = new ArrayList<Fornecedor>();
            while (!eof) {
                this.fornecedores.add((Fornecedor) oi.readObject());
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
