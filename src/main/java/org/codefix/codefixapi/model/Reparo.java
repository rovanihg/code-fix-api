package org.codefix.codefixapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reparos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reparo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String aparelho;

    @Column(nullable = false)
    private String defeito;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String status;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    // Método executado automaticamente antes de salvar no banco
    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }
}