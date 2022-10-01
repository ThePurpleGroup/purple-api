package br.senac.go.purple.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Abastecimento  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "odometro")
    private long odometro;

    @Column(name = "data_abastecimento")
    private Date dataAbastecimento;

    @Column(name = "valor_total_combustive")
    private double valor_total_combustive;

    @Column(name = "nome_posto")
    private String nome_posto;

    @Column(name = "total_litros")
    private double total_litros;

    @Column(name = "valor_por_combustive")
    private double valor_por_combustive;

    @Column(name = "id_veiculo")
    private Integer id_veiculo;

    @Column(name = "tipo_combustivel")
    private String tipo_combustivel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Abastecimento that = (Abastecimento) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
