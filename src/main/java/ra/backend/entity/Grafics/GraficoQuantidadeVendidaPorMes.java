package ra.backend.entity.Grafics;

public class GraficoQuantidadeVendidaPorMes {

    private Integer ano;
    private Integer mes;
    private Long quantidadeVendas;

    public GraficoQuantidadeVendidaPorMes(Integer ano, Integer mes, Long quantidadeVendas) {
        this.ano = ano;
        this.mes = mes;
        this.quantidadeVendas = quantidadeVendas;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Long getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(Long quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }
}
