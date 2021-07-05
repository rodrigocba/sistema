

package com.birra.sistema.service;


        import com.birra.sistema.entity.OrdenDeCompra;
        import com.birra.sistema.exception.UserNotFoundException;
        import com.birra.sistema.repository.OrdenDeCompraRepo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.util.List;

@Service
@Transactional
public class OrdenDeCompraService {

    private final OrdenDeCompraRepo ordenDeCompraRepo;

    @Autowired
    public OrdenDeCompraService(OrdenDeCompraRepo ordenDeCompraRepo) {
        this.ordenDeCompraRepo = ordenDeCompraRepo;
    }

    public OrdenDeCompra addOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        OrdenDeCompra p = ordenDeCompraRepo.save(ordenDeCompra);

        return p;
    }

    public List<OrdenDeCompra> findAllOrdenDeCompras() {
        return ordenDeCompraRepo.findAll();
    }

    public OrdenDeCompra updateOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        return ordenDeCompraRepo.save(ordenDeCompra);
    }

    public OrdenDeCompra findOrdenDeCompraById(Long id) {
        return ordenDeCompraRepo.findOrdenDeCompraById(id)
                .orElseThrow(() -> new UserNotFoundException("OrdenDeCompra nro" + id + " no existe"));
    }


    public void deleteOrdenDeCompra(Long id) {
        ordenDeCompraRepo.deleteOrdenDeCompraById(id);
    }

}
