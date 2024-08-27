package ra.backend.entity.DTOs.request;

public class FiltroProdutoRequest extends FiltroBusca {

    private String bolsaMasculina;
    private String bolsaFeminina;
    private String mala;
    private String carteira;

    public FiltroProdutoRequest(Integer pagina, Integer tamanhoPagina, String bolsaMasculina, String bolsaFeminina, String mala, String carteira) {
        super(pagina, tamanhoPagina);
        this.bolsaMasculina = bolsaMasculina;
        this.bolsaFeminina = bolsaFeminina;
        this.mala = mala;
        this.carteira = carteira;
    }

    public FiltroProdutoRequest() {
    }

    public String getBolsaMasculina() {
        return bolsaMasculina;
    }

    public void setBolsaMasculina(String bolsaMasculina) {
        this.bolsaMasculina = bolsaMasculina;
    }

    public String getBolsaFeminina() {
        return bolsaFeminina;
    }

    public void setBolsaFeminina(String bolsaFeminina) {
        this.bolsaFeminina = bolsaFeminina;
    }

    public String getMala() {
        return mala;
    }

    public void setMala(String mala) {
        this.mala = mala;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }
}


