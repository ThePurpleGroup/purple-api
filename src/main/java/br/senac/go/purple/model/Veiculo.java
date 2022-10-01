package br.senac.go.purple.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Veiculo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "desc_veiculo")
    private String descVeiculo;

    @Column(name = "placa")
    private String placa;


    @Column(name = "id_usuario")
    private Integer usuarioId;

    @Column(name = "tipo_combustivel")
    private String tipoCombustivel;

    @Column(name = "tipo_veiculo")
    private String tipoVeiculo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Veiculo veiculo = (Veiculo) o;
        return id != null && Objects.equals(id, veiculo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
