package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;


@Repository
public class LibroRepository {
    
    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro: listaLibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar (Libro book){
        listaLibros.add(book){
            return book;
        }
    }

    public Libro actualizar(Libro book){
        Libro libroBuscado=buscarPorId(book.getId());
        if (libroBuscado!=null) {
        libroBuscado.setIsbn(book.getIsbn());
        libroBuscado.setAutor(book.getAutor());
        libroBuscado.setEditorial(book.getEditorial());
        libroBuscado.setFechaPublicacion(book.getFechaPublicacion());
        libroBuscado.setTitulo(book.getTitulo());

        return libroBuscado;
        }
        return null;
    }

    

    public void eliminar(int id) {
        listaLibros.removeIf(book->book.getId()==id);
        
    }



}
