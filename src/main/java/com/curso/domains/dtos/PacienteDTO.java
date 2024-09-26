package com.curso.domains.dtos;

import com.curso.domains.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public class PacienteDTO {
    private long id;
    @NotNull(message = "O campo nome social não pode ser nulo")
    @NotBlank(message = "O campo nome social não pode ser vazio")
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @NotNull(message = "O campo valor não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal custoInternacao;
    private int status;

    public PacienteDTO() {}

    public PacienteDTO(long id, String nome, Date dataNascimento, BigDecimal custoInternacao, int status) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.custoInternacao = custoInternacao;
        this.status = status;
    }

    public PacienteDTO(Paciente obj) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser vazio") @NotBlank(message = "O campo nome não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser vazio") @NotBlank(message = "O campo nome não pode ser vazio") String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O campo nome não pode ser vazio") @Digits(integer = 15, fraction = 0) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
