package com.project.service.impl;

import com.project.domain.DnevnoStanje;
import com.project.domain.Faktura;
import com.project.domain.NalogZaPlacanje;
import com.project.repository.DnevnoStanjeRepository;
import com.project.repository.FakturaRepository;
import com.project.repository.NalogZaPlacanjeRepository;
import com.project.service.NalogZaPlacanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class NalogZaPlacanjeServiceImpl implements NalogZaPlacanjeService {

    @Autowired
    private NalogZaPlacanjeRepository nalogZaPlacanjeRepository;

    @Autowired
    private FakturaRepository fakturaRepository;

    @Autowired
    private DnevnoStanjeRepository dnevnoStanjeRepository;

    @Override
    public List<NalogZaPlacanje> findAll() {
        return nalogZaPlacanjeRepository.findAll();
    }

    @Override
    public NalogZaPlacanje findOne(Long id) {
        return nalogZaPlacanjeRepository.findOne(id);
    }

    @Override
    public void delete(NalogZaPlacanje nalogZaPlacanje) {
        nalogZaPlacanjeRepository.delete(nalogZaPlacanje);
    }

    @Override
    public NalogZaPlacanje save(NalogZaPlacanje nalogZaPlacanje) {
        return nalogZaPlacanjeRepository.save(nalogZaPlacanje);
    }

    @Override
    public void generisiNalog(Long idFakture, Double iznos) {
        Faktura faktura = fakturaRepository.findOne(idFakture);
        NalogZaPlacanje nalogZaPlacanje = new NalogZaPlacanje();

        nalogZaPlacanje.setDatumNaloga(new Date());
        nalogZaPlacanje.setDuznik(faktura.getDuznik().getNaziv());
        nalogZaPlacanje.setHitno(false);
        nalogZaPlacanje.setPrimalac(faktura.getPrimalac().getNaziv());
        nalogZaPlacanje.setIznos(iznos);
        nalogZaPlacanje.setDatumValute(faktura.getDatumValute());
        nalogZaPlacanje.setSvrha("placanje fakture " + faktura.getBroj());

        DnevnoStanje dnevnoStanje = dnevnoStanjeRepository.findByPreduzeceAndDatum(faktura.getDuznik(), new Date());
        dnevnoStanje.setRezervisano(dnevnoStanje.getRezervisano() + iznos);
        dnevnoStanjeRepository.save(dnevnoStanje);

        nalogZaPlacanjeRepository.save(nalogZaPlacanje);
    }
}
