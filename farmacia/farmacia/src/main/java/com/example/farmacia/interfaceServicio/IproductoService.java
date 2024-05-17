package com.example.farmacia.interfaceServicio;
import com.example.farmacia.modelos.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IproductoService {
    public List<Producto>listar();
    public Optional<Producto>listarId(int id);
    public int save(Producto p);
    public void delete(int id);
}