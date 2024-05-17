package com.example.farmacia.servicio;

import com.example.farmacia.interfaceServicio.IproductoService;
import com.example.farmacia.interfaces.Iproducto;
import com.example.farmacia.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IproductoService {

    @Autowired
    private Iproducto data;

    @Override
    public List<Producto> listar() {
        return (List<Producto>) data.findAll();
    }

    @Override
    public Optional<Producto> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Producto p) {
        int res=0;
        Producto producto=data.save(p);
        if (!producto.equals(null)) {
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
