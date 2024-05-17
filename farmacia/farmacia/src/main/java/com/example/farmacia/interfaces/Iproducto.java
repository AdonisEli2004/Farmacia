package com.example.farmacia.interfaces;
import com.example.farmacia.modelos.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iproducto extends CrudRepository<Producto, Integer> {

}
