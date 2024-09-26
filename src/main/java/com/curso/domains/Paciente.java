package com.curso.domains;

import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
    private int id;
    @NotNull @NotBlank
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @NotNull
    @Digits(integer = 15, fraction=2)
    private BigDecimal custoInternacao;
    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="status")
    private Status status;

    public Paciente() {
    }

    public Paciente(int id, String nome, Date dataNascimento, BigDecimal custoInternacao, Status status) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.custoInternacao = custoInternacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return getId() == paciente.getId() && Objects.equals(getNome(), paciente.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }
}
