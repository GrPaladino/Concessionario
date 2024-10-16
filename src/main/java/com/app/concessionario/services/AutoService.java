package com.app.concessionario.services;

import com.app.concessionario.dto.AutoDTO;
import com.app.concessionario.entity.*;
import com.app.concessionario.mapper.AutoMapper;
import com.app.concessionario.repositories.*;
import com.app.concessionario.utils.enumerate.Carrozzeria;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    public AutoDTO getAutoDTO(Integer id) throws Exception {
        Optional<Auto> a = autoRepository.findById(id);

        if (a.isPresent()) {
            return AutoMapper.toDTO(a.get());
        } else {
            throw new Exception("L'id inserito non é corretto");
        }
    }



//    chiamata post per creare una nuova auto
    public void addAutoDTO(AutoDTO autoDTO) throws Exception {
        Optional<Auto> a = autoRepository.findById(autoDTO.getId());

        if (a.isPresent())
            throw new Exception("L'id inserito non é valido");

        if (autoDTO.getBrand() == null)
            throw new Exception("Il campo brand non può essere vuoto");

        if (autoDTO.getModello() == null)
            throw new Exception("Il campo modello non può essere vuoto");

        if (autoDTO.getBrand().length() > 50)
            throw new Exception("La lunghezza del campo brand non può superare i 50 caratteri");

        if (autoDTO.getModello().length() > 50)
            throw new Exception("La lunghezza del campo modello non può superare i 50 caratteri");

        if (autoDTO.getColore().length() > 20)
            throw new Exception("La lunghezza del campo colore non può superare i 20 caratteri");

        if (autoDTO.getStato() != null && autoDTO.getStato().length() > 50)
            throw new Exception("La lunghezza del campo stato non può superare i 20 caratteri");

        if (autoDTO.getCarrozzeria() == null)
            throw new Exception("Il campo carrozzeria non può essere vuoto");

        if (autoDTO.getCarrozzeria().equalsIgnoreCase("suv") ||
                autoDTO.getCarrozzeria().equalsIgnoreCase("berlina") ||
                autoDTO.getCarrozzeria().equalsIgnoreCase("crossover") ||
                autoDTO.getCarrozzeria().equalsIgnoreCase("stationwagon") ||
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

//    chiamata put per update auto
    public void updateAutoDTO(Integer id, AutoDTO autoDTO) throws Exception {
        Optional<Auto> a = autoRepository.findById(id);

        if (a.isPresent()) {


            if (autoDTO.getBrand() == null)
                throw new Exception("Il campo brand non può essere vuoto");

            if (autoDTO.getModello() == null)
                throw new Exception("Il campo modello non può essere vuoto");

            if (autoDTO.getBrand().length() > 50)
                throw new Exception("La lunghezza del campo brand non può superare i 50 caratteri");

            if (autoDTO.getModello().length() > 50)
                throw new Exception("La lunghezza del campo modello non può superare i 50 caratteri");

            if (autoDTO.getColore().length() > 20)
                throw new Exception("La lunghezza del campo colore non può superare i 20 caratteri");

            if (autoDTO.getStato() != null && autoDTO.getStato().length() > 50)
                throw new Exception("La lunghezza del campo stato non può superare i 20 caratteri");

            if (autoDTO.getCarrozzeria() == null)
                throw new Exception("Il campo carrozzeria non può essere vuoto");

            if (autoDTO.getCarrozzeria().equalsIgnoreCase("suv") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("berlina") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("crossover") ||
                    autoDTO.getCarrozzeria().equalsIgnoreCase("stationwagon") ||
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

        } else {
            throw new Exception("L'id inserito non è valido");
        }

    }
//    chiamata per patch un auto
    public void patchAutoDTO(Integer id, AutoDTO patchAutoDTO) throws Exception {
        Optional<Auto> a = autoRepository.findById(id);

        if (a.isPresent()) {

            if (patchAutoDTO.getBrand() != null) {
                if (patchAutoDTO.getBrand().length() > 50)
                    throw new Exception("La lunghezza del campo brand non può superare i 50 caratteri");

                a.get().setBrand(patchAutoDTO.getBrand());
            }

            if (patchAutoDTO.getModello() != null) {
                if (patchAutoDTO.getModello().length() > 50)
                    throw new Exception("La lunghezza del campo modello non può superare i 50 caratteri");

                a.get().setModello(patchAutoDTO.getModello());
            }

            if (patchAutoDTO.getColore() != null) {
                if (patchAutoDTO.getColore().length() > 20)
                    throw new Exception("La lunghezza del campo colore non può superare i 20 caratteri");
                a.get().setColore(patchAutoDTO.getColore());
            }

            if (patchAutoDTO.getStato() != null) {
                if (patchAutoDTO.getStato().length() > 50)
                    throw new Exception("La lunghezza del campo stato non può superare i 20 caratteri");
                a.get().setStato(patchAutoDTO.getStato());
            }

            if (patchAutoDTO.getCarrozzeria() != null) {
                if (patchAutoDTO.getCarrozzeria().equalsIgnoreCase("suv") ||
                        patchAutoDTO.getCarrozzeria().equalsIgnoreCase("berlina") ||
                        patchAutoDTO.getCarrozzeria().equalsIgnoreCase("crossover") ||
                        patchAutoDTO.getCarrozzeria().equalsIgnoreCase("stationwagon") ||
                        patchAutoDTO.getCarrozzeria().equalsIgnoreCase("utilitaria")) {


                    a.get().setCarrozzeria(Carrozzeria.valueOf(patchAutoDTO.getCarrozzeria().toUpperCase()));
                } else {
                    throw new Exception("I campi carrozzeria disponibili sono: 'suv', 'berlina', 'stationwagon', 'crossover', 'utilitaria'");
                }
            }
            autoRepository.save(a.get());

        } else {
            throw new Exception("L'id inserito non è valido");
        }
    }

//    chiamata per eliminare un auto
    public void deleteAuto(Integer id) throws Exception {
        Optional<Auto> a = autoRepository.findById(id);

        if (a.isPresent()) {
            autoRepository.deleteById(id);
        } else {
            throw new Exception("L'id inserito non é valido");
        }
    }



//    METODO PER AGGIORNARE IL CLIENTE ID DI UN AUTO QUANDO VIENE VENDUTA
    public void sellAuto(Integer autoId, Integer clienteId) throws Exception {
        Optional<Auto> a = autoRepository.findById(autoId);
        Optional<Cliente> c = clienteRepository.findById(clienteId);

        if (!a.isPresent())
            throw new Exception("L'id dell'auto inserita non è presente");

        if (a.get().getIsVentuta())
            throw new Exception("L'auto selezionata ha giá un cliente");

        if (!c.isPresent())
            throw new Exception("L'id del cliente inserito non è presente");

        a.get().setCliente(c.get());
        a.get().setIsVentuta(true);
        autoRepository.save(a.get());
    }
}
