package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class KotController {

    @Autowired
    private KotRepository kotRepo;

    @Autowired
    private HodowlaRepository hodowlaRepo;

    @Autowired
    private RasaRepository rasaRepo;

    // ✅ ZWRACA WSZYSTKIE KOTY
    @GetMapping("/koty")
    public List<KotDTO> getWszystkieKoty() {
        List<Kot> koty = kotRepo.findAll();

        return koty.stream().map(kot -> {
            KotDTO dto = new KotDTO();
            dto.setId(kot.getId());
            dto.setImie(kot.getImie());
            dto.setCena(kot.getCena());
            dto.setStatus(kot.getStatus());
            dto.setZdjecie(kot.getObrazek());

            if (kot.getDataUrodzenia() != null) {
                dto.setDataUrodzenia(new SimpleDateFormat("yyyy-MM-dd").format(kot.getDataUrodzenia()));
            }

            Rasa rasa = rasaRepo.findById(kot.getRasaID()).orElse(null);
            dto.setRasa(rasa != null ? rasa.getNazwa() : "Brak danych");

            Hodowla hodowla = hodowlaRepo.findById(kot.getHodowlaID()).orElse(null);
            dto.setHodowla(hodowla != null ? hodowla.getNazwa() : "Brak danych");
            dto.setLokalizacja(hodowla != null ? hodowla.getLokalizacja() : "Brak danych");

            return dto;
        }).toList();
    }

    // ✅ ZWRACA JEDNEGO KOTA (opcjonalnie)
    @GetMapping("/kot")
    public KotDTO getPierwszyKot() {
        Optional<Kot> kotOpt = kotRepo.findAll().stream().findFirst();
        if (kotOpt.isEmpty()) {
            return null;
        }

        Kot kot = kotOpt.get();
        KotDTO dto = new KotDTO();
        dto.setId(kot.getId());
        dto.setCena(kot.getCena());
        dto.setImie(kot.getImie());
        dto.setStatus(kot.getStatus());
        dto.setZdjecie(kot.getObrazek());

        if (kot.getDataUrodzenia() != null) {
            dto.setDataUrodzenia(new SimpleDateFormat("yyyy-MM-dd").format(kot.getDataUrodzenia()));
        }

        Hodowla hodowla = hodowlaRepo.findById(kot.getHodowlaID()).orElse(null);
        dto.setHodowla(hodowla != null ? hodowla.getNazwa() : "Brak danych");
        dto.setLokalizacja(hodowla != null ? hodowla.getLokalizacja() : "Brak danych");

        Rasa rasa = rasaRepo.findById(kot.getRasaID()).orElse(null);
        dto.setRasa(rasa != null ? rasa.getNazwa() : "Brak danych");

        return dto;
    }

    // ✅ REZERWACJA KOTA
    @PostMapping("/kot/{id}/rezerwuj")
    public ResponseEntity<String> rezerwujKota(@PathVariable String id) {
        Optional<Kot> optionalKot = kotRepo.findById(id);
        if (optionalKot.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono kota");
        }

        Kot kot = optionalKot.get();
        Date teraz = new Date();

        if (kot.getCzasRezerwacji() != null) {
            long roznicaMillis = teraz.getTime() - kot.getCzasRezerwacji().getTime();
            if (roznicaMillis < 15 * 60 * 1000) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Kot jest już zarezerwowany. Spróbuj ponownie za chwilę.");
            }
        }

        kot.setCzasRezerwacji(teraz);
        kot.setStatus("zarezerwowany");
        kotRepo.save(kot);

        return ResponseEntity.ok("Kot zarezerwowany na 15 minut.");
    }
}