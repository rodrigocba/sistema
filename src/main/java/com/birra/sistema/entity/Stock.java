import com.birra.sistema.entity.Insumo;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long cantidad;
//    private Insumo insumo;
}
