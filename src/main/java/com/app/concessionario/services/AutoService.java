package com.app.concessionario.services;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.entity.*;
import com.app.concessionario.mapper.AutoMapper;
import com.app.concessionario.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private MotoreRepository motoreRepository;
    @Autowired
    private AccessorioRepository accessorioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    ConcessionarioRepository concessionarioRepository;


//                                CHIAMATE DTO
//
//    chiamata get di tutti le auto
    public List<AutoDTO> getAutosDTO() {
        List<AutoDTO> autosDTO = new ArrayList<>();
        List<Auto> auto = autoRepository.findAll();
        for (Auto a : auto) {
            AutoDTO autoDTO = AutoMapper.toDTO(a);
            autosDTO.add(autoDTO);
        }
        return autosDTO;
    }

//    chiamata get per una singola auto
    public AutoDTO getAutoDTO(Integer id) {
        Optional<Auto> a = autoRepository.findById(id);
        List<Cliente> clienti = clienteRepository.findAll();
        return AutoMapper.toDTO(a.get());
    }



//    chiamata post per creare una nuova auto
    public void addAutoDTO(AutoDTO autoDTO) throws Exception {
        List<Integer> autoIds = autoRepository.findAll().stream().map(Auto::getId).toList();
        if (autoIds.contains(autoDTO.getId())) {
            throw new Exception("L'id inserito non é valido");
        } else if (autoDTO.getBrand() == null) {
            throw new Exception("Il campo brand non può essere vuoto");
        } else if (autoDTO.getModello() == null) {
            throw new Exception("Il campo modello non può essere vuoto");
        } else if (autoDTO.getBrand().length() > 50) {
            throw new Exception("La lunghezza del campo brand non può superare i 50 caratteri");
        } else if (autoDTO.getModello().length() > 50) {
            throw new Exception("La lunghezza del campo modello non può superare i 50 caratteri");
        } else if (autoDTO.getColore().length() > 20) {
            throw new Exception("La lunghezza del campo colore non può superare i 20 caratteri");
        } else if (autoDTO.getStato() != null && autoDTO.getStato().length() > 50) {
            throw new Exception("La lunghezza del campo stato non può superare i 20 caratteri");
        } else if (autoDTO.getCarrozzeria() == null) {
            throw new Exception("Il campo carrozzeria non può essere vuoto");
        } else if (autoDTO.getCarrozzeria() != null) {
            if (autoDTO.getCarrozzeria().equalsIgnoreCase("suv") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("berlina") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("crossover") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("stationwagen") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("utilitaria")) {

                List<Motore> motori = motoreRepository.findAll();
                List<Accessorio> accessori = accessorioRepository.findAll();
                List<Cliente> clienti = clienteRepository.findAll();
                List<Concessionario> concessionari = concessionarioRepository.findAll();
                Auto newAuto = AutoMapper.toEntity(autoDTO, motori, accessori, clienti, concessionari);
                autoRepository.save(newAuto);
            } else {
                throw new Exception("I campi carrozzeria disponibili sono: 'suv', 'berlina', 'stationwagon', 'crossover', 'utilitaria'");
            }

        }
    }

//    chiamata put per update auto
    public void updateAutoDTO(Integer id, AutoDTO autoDTO) throws Exception {
        List<Motore> motori = motoreRepository.findAll();
        List<Accessorio> accessori = accessorioRepository.findAll();
        List<Cliente> clienti = clienteRepository.findAll();
        List<Concessionario> concessionari = concessionarioRepository.findAll();
        Auto newAuto = AutoMapper.toEntity(autoDTO, motori, accessori, clienti, concessionari);
        newAuto.setId(id);
        autoRepository.save(newAuto);
    }

//    chiamata per eliminare un auto
    public void deleteAuto(Integer id) throws Exception {
        List<Integer> autoIds = autoRepository.findAll().stream().map(Auto::getId).toList();
        if (autoIds.contains(id)) {
            autoRepository.deleteById(id);
        }
        throw new Exception("L'id inserito non é valido");
}



//    METODO PER AGGIORNARE IL CLIENTE ID DI UN AUTO QUANDO VIENE VENDUTA
    public void sellAuto(Integer autoId, Integer clienteId) throws Exception {
        List<Integer> autoIds = autoRepository.findAll().stream().map(Auto::getId).toList();
        List<Integer> clientiIds = clienteRepository.findAll().stream().map(Cliente::getId).toList();
            Optional<Auto> a = autoRepository.findById(autoId);
            Optional<Cliente> c = clienteRepository.findById(clienteId);
            Auto auto = a.get();
            Cliente cliente = c.get();
        if (!autoIds.contains(autoId)) {
            throw new Exception("L'id dell'auto inserita non è presente");
        } else if (auto.getIsVentuta()) {
            throw new Exception("L'auto selezionata ha giá un cliente");
        } else if (!clientiIds.contains(clienteId)) {
            throw new Exception("L'id del cliente inserito non è presente");
        } else {
            auto.setCliente(cliente);
            auto.setIsVentuta(true);
            autoRepository.save(auto);
        }


    }
}
