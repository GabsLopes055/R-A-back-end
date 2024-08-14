package ra.backend.controllers.exceptions.exemploExeception;

import java.time.Instant;

public class ExcecaoExemplo {

    private Instant momentoDaExcecao;

    private Integer status;

    private String error;

    private String mensagem;

    private String caminho;

    public ExcecaoExemplo() {
    }

    public ExcecaoExemplo(Instant momentoDaExcecao, Integer status, String error, String mensagem, String caminho) {
        this.momentoDaExcecao = momentoDaExcecao;
        this.status = status;
        this.error = error;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }

    public Instant getMomentoDaExcecao() {
        return momentoDaExcecao;
    }

    public void setMomentoDaExcecao(Instant momentoDaExcecao) {
        this.momentoDaExcecao = momentoDaExcecao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
