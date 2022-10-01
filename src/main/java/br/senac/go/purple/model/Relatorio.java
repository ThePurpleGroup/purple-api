package br.senac.go.purple.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Relatorio {
    private Long id_veiculo;
    private String postoMaisCaro;
    private String postoMaisBarato;
    private double mediaConsumo;

}
