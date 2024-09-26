package ra.backend.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.DTOs.request.FiltroVendaRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.request.VendaRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;
import ra.backend.entity.DTOs.response.VendaResponse;
import ra.backend.entity.ProdutosEntity;
import ra.backend.entity.VendaEntity;
import ra.backend.repository.VendasRepository;
import ra.backend.services.VendasService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaServiceImpl implements VendasService {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @Override
    public VendaResponse cadastrarVenda(VendaRequest vendaEntity) {

        VendaEntity salvarVenda = VendaRequest.toEntity(vendaEntity);

        List<ProdutosEntity> listaProdutos = darBaixaProduto(salvarVenda.getProdutosVendidos());

        salvarVenda.setProdutosVendidos(listaProdutos);

        vendasRepository.save(salvarVenda);

        return VendaResponse.toResponse(salvarVenda);
    }

    @Override
    public Page<VendaResponse> listarTodasVendas(FiltroVendaRequest filtroVendaRequest) {

        Pageable paginacao = PageRequest.of(filtroVendaRequest.getPagina(), filtroVendaRequest.getTamanhoPagina());

        Page<VendaEntity> response = vendasRepository.listarPorPaginacao(paginacao, filtroVendaRequest.getDataInicio(), filtroVendaRequest.getDataFim());

        return new PageImpl<>(response.stream().map(VendaResponse::toResponse).collect(Collectors.toList()), paginacao, response.getTotalElements());

    }

    @Override
    public void deletarVenda(String idVenda) {
        System.out.println(idVenda);
    }

    private List<ProdutosEntity> darBaixaProduto(List<ProdutosEntity> produtosEntities) {

        List<ProdutosEntity> listaProdutos = new ArrayList<>();

        produtosEntities.forEach(produto -> {
            listaProdutos.add(produtoServiceImpl.darBaixaProduto(produto.getIdProduto()));
        });

        return listaProdutos;
    }

}
