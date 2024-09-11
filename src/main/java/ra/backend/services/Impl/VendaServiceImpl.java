package ra.backend.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.backend.entity.VendaEntity;
import ra.backend.repository.VendasRepository;
import ra.backend.services.VendasService;

@Service
public class VendaServiceImpl implements VendasService {

    @Autowired
    private VendasRepository repository;

    @Override
    public VendaEntity cadastrarVenda(VendaEntity vendaEntity) {

        System.out.println(vendaEntity.toString());

        return repository.save(vendaEntity);
    }
}
