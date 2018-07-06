INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('ADMIN', 'Novi Sad', 'admin@admin.com', 'Ivan', '0635569989', 'admin', 'Vukasinovic', 'admin', true,'' );
INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('AGENT', 'Beograd', 'agent@agent.com','Agent', '0641569989', 'agent', 'Agentic', 'agent', true,'');
INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('User', 'Vranje', 'user@user.com','User', '0641569589', 'user', 'Useric', 'user', true,'Futoska 38');
INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('User', 'Beograd', 'mironikos94@gmail.com', 'Dejan', '0615565239', 'dejan', 'Stojkic', 'dejan', true,'Becejska 38');
INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('User', 'Novi Sad', 'milanovicstefann@gmail.com', 'Stefan', '0645565239', 'stefan', 'Milanovic', 'stefan', true,'Celopecka 38');
INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('User', 'Novi Sad', 'jovananovakovic404@gmail.com', 'Jovana', '0645565239', 'jovana', 'Novakovic', 'jovana', true,'Francuska 38');
INSERT INTO user (role, city, email, name, number, password, surname, username, activated,adress) VALUES ('User', 'Becej', 'ivan.becej@gmail.com', 'Ivan', '0645565239', 'ivan', 'Vukasinovic', 'ivan', true,'Niska 38');

INSERT INTO adresa (id, broj, drzava, grad, postanski_broj, ulica) VALUES (1, '22', 'Srbija', 'Becej', 21220, 'Cara Dusana');
INSERT INTO adresa (id, broj, drzava, grad, postanski_broj, ulica) VALUES (2,'21', 'Srbija', 'Sid', 22240, 'Jelice Stanivukovic');
INSERT INTO adresa (id, broj, drzava, grad, postanski_broj, ulica) VALUES (3,'1', 'Srbija', 'Sid', 22240, 'Kneza Milosa');
INSERT INTO adresa (id, broj, drzava, grad, postanski_broj, ulica) VALUES (4,'4', 'Srbija', 'Novi Sad', 21000, ' Bulevar Oslobodjenja');
INSERT INTO adresa (id, broj, drzava, grad, postanski_broj, ulica) VALUES (5,'14a', 'Srbija', 'Novi Sad', 21000, 'Tolstojeva');
INSERT INTO adresa (id, broj, drzava, grad, postanski_broj, ulica) VALUES (6,'11a', 'Srbija', 'Beograd', 11000, 'Karadjordjeva');

INSERT INTO valuta (id, naziv, oznaka) VALUES (1, 'Srpski dinar', 'RSD');
INSERT INTO valuta (id, naziv, oznaka) VALUES (2, 'Evro', 'EUR');
INSERT INTO valuta (id, naziv, oznaka) VALUES (3, 'Americki dolar', 'USD');
INSERT INTO valuta (id, naziv, oznaka) VALUES (4, 'Britanska funta', 'GPB');
INSERT INTO valuta (id, naziv, oznaka) VALUES (5, 'Svajcarski franak', 'CHF');

INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (1, 'Kilogram', 'kg');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (2, 'Metar', 'm');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (3, 'Komad', 'kom');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (4, 'Amper', 'A');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (5, 'Mol', 'mol');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (6, 'Miligram', 'mg');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (7, 'Tona', 't');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (8, 'Centimetar', 'cm');
INSERT INTO jedinica_mere (id, naziv, skracenica) VALUES (9, 'Milimetar', 'mm');

INSERT INTO pdv (id, naziv) VALUES (1, 'Potrosnju');
INSERT INTO pdv (id, naziv) VALUES (2, 'Dohodak');
INSERT INTO pdv (id, naziv) VALUES (3, 'Dobit');
INSERT INTO pdv (id, naziv) VALUES (4, 'Imovinu ');
INSERT INTO pdv (id, naziv) VALUES (5, 'Prenos imovine');

INSERT INTO stopapdv (id, stopa, datum_vazenja, pdv_id) VALUES (1,20, '2018-09-24',1);
INSERT INTO stopapdv (id, stopa, datum_vazenja, pdv_id) VALUES (2, 8, '2018-07-21',2);
INSERT INTO stopapdv (id, stopa, datum_vazenja, pdv_id) VALUES (3, 15.7, '2018-08-22',3);
INSERT INTO stopapdv (id, stopa, datum_vazenja, pdv_id) VALUES (4, 10.5, '2018-10-20',4);
INSERT INTO stopapdv (id, stopa, datum_vazenja, pdv_id) VALUES (5, 12, '2018-10-23',5);

INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (1, 'Prehrambeni', 'Voce, povrce meso itd.',1);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (2, 'Kancelarijski', 'Materijal za pisanje i rad u kancelariji',2);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (3, 'Higijenski', 'Proizvodi za higijenu',3);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (4, 'Elektro', ' Elektromaterijali',1);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (5, 'Tehnika', 'Bela tehnika i ostali uredjaji',1);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (6, 'Gradjevinski', 'Gradjevinski materijal',1);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (7, 'Tehnika', 'Bela tehnika i ostali uredjaji',2);
INSERT INTO grupa_proizvoda (id, naziv, opis, pdv_id) VALUES (8, 'Gradjevinski', 'Gradjevinski materijal',2);

INSERT INTO preduzece (id, email, lozinka, pib, naziv, adresa_id) VALUES (1, 'sdd@email.com','sdd','12121212120', 'SDD Technology Group',6);
INSERT INTO preduzece (id, email, lozinka, pib, naziv, adresa_id) VALUES (2, 'v@v.com','v','12121212121', 'Victoria Oil',2);
INSERT INTO preduzece (id, email, lozinka, pib, naziv, adresa_id) VALUES (3, 'i@i.com','i','12121212122', 'TIM Izolirka',3);
INSERT INTO preduzece (id, email, lozinka, pib, naziv, adresa_id) VALUES (4, 'flora@flora.com','flora','12121212123', 'Flora',1);
INSERT INTO preduzece (id, email, lozinka, pib, naziv, adresa_id) VALUES (5, 'a@a.com','a','12121212125', 'Arcus Health',5);

INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (1, 'Papir','A4 format',2, 3, 1);
INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (2, 'Kabl','Presek 13mm',4, 2, 3);
INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (3, 'Opticki kabl','Presek 13mm',4, 2, 1);
INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (4, 'Sapun','Klasik sapun',3, 3, 5);
INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (5, 'Peskir','Beli 0.5x1m',3, 3, 5);
INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (6, 'Sijalice','LED',4, 3, 3);
INSERT INTO proizvod (id, naziv, opis, grupa_proizvoda_id, jedinica_mere_id, preduzece_id) VALUES (7, 'Karton','0.5x1m',2, 3, 2);

INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (1, 2017,true,1);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (2, 2017,true,5);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (3, 2017,true,3);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (4, 2016,true,2);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (5, 2018,false,1);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (6, 2018,false,2);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (7, 2018,false,3);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (8, 2018,false,4);
INSERT INTO poslovna_godina (id, godina,zakljucana,preduzece_id) VALUES (9, 2018,false,5);

INSERT INTO cenovnik (id, datum_vazenja,preduzece_id,valuta_id) VALUES (1,'2018-10-23',1,2);
INSERT INTO cenovnik (id, datum_vazenja,preduzece_id,valuta_id) VALUES (2,'2018-09-23',2,1);
INSERT INTO cenovnik (id, datum_vazenja,preduzece_id,valuta_id) VALUES (3,'2018-07-30',3,1);
INSERT INTO cenovnik (id, datum_vazenja,preduzece_id,valuta_id) VALUES (4,'2018-08-13',4,1);
INSERT INTO cenovnik (id, datum_vazenja,preduzece_id,valuta_id) VALUES (5,'2018-10-22',5,1);

INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (1,2,1,1);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (2,10,2,7);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (3,10,3,2);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (4,10,3,6);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (5,10,4,1);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (6,10,5,4);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (7,10,5,5);
INSERT INTO stavka_cenovnika (id, cena, cenovnik_id, proizvod_id) VALUES (8,10,1,3);

INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (1,'0651222111','123-9876543211234-45', 'NARUCILAC','partner1@gmail.com',1);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (2,'0621222111','223-9876543211231-47', 'ISPORUCILAC','partner2@gmail.com',1);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (3,'0612341112','323-9876543211232-46', 'NARUCILAC','partner3@gmail.com',1);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (4,'0651222154','423-9876543211233-45', 'NARUCILAC','partner4@gmail.com',2);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (5,'0651222114','523-9876543211235-47', 'NARUCILAC','partner5@gmail.com',2);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (6,'0651222115','553-9876543211236-46', 'ISPORUCILAC','partner6@gmail.com',2);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (7,'0651222116','623-9876543211237-45', 'ISPORUCILAC','partner7@gmail.com',3);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (8,'0651222118','723-9876543211238-44', 'ISPORUCILAC','partner8@gmail.com',3);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (9,'0651222199','823-9876543211239-45', 'ISPORUCILAC','partner@9gmail.com',3);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (10,'0634222111','923-9876543211230-48', 'NARUCILAC','partner10@gmail.com',4);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (11,'0651227711','023-9876543211224-47', 'ISPORUCILAC','partner11@gmail.com',4);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (12,'0651229911','193-9876543211214-45', 'ISPORUCILAC','partner12@gmail.com',4);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (13,'0651220011','173-9876543211244-46', 'NARUCILAC','partner13@gmail.com',5);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (14,'0651222333','103-9876543211264-45', 'ISPORUCILAC','partner14@gmail.com',5);
INSERT INTO poslovni_partner (id, broj_telefona, broj_racuna, vrsta, email, preduzece_id) VALUES (15,'0651222175','145-9876543211254-47', 'NARUCILAC','partner15@gmail.com',5);

INSERT INTO narudzbenica (id, datum_kreiranja, redni_broj, poslovni_partner_id) VALUES (1,'2018-07-01',1,1);
INSERT INTO narudzbenica (id, datum_kreiranja, redni_broj,  poslovni_partner_id) VALUES (2,'2018-07-02',2,2);
INSERT INTO narudzbenica (id, datum_kreiranja, redni_broj,  poslovni_partner_id) VALUES (3,'2018-07-05',3,7);
INSERT INTO narudzbenica (id, datum_kreiranja, redni_broj, poslovni_partner_id) VALUES (4,'2018-07-11',33,15);

INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (1,10,1,1);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (2,2,1,2);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (3,6,1,3);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (4,30,1,4);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (5,15,2,5);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (6,24,2,6);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (7,1,3,7);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (8,10,3,3);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (9,12,4,4);
INSERT INTO stavka_narudzbenice (id, kolicina, narudzbenica_id,proizvod_id) VALUES (10,3,4,1);
--ako narudzbenica nije null ona se po njoj gleda ko su preduzece i poslovni partner ? PROVERI
INSERT INTO faktura (id, bezpdv, broj, datum, datum_valute,preostali_iznos,tip,ukupanpdv, ukupan_rabat,ukupno_za_placanje,zatvorena,narudzbenica_id,poslovna_godina_id,poslovni_partner_id,preduzece_id) VALUES (1,25,100,'2018-07-02','2018-07-24',200,'ULAZNA',25,10,200,true,1,5,1,1);
INSERT INTO faktura (id, bezpdv, broj, datum, datum_valute,preostali_iznos,tip,ukupanpdv, ukupan_rabat,ukupno_za_placanje,zatvorena,narudzbenica_id,poslovna_godina_id,poslovni_partner_id,preduzece_id) VALUES (2,20,101,'2018-07-05','2018-07-14',400,'IZLAZNA',26,100,400,true,2,4,2,1);
INSERT INTO faktura (id, bezpdv, broj, datum, datum_valute,preostali_iznos,tip,ukupanpdv, ukupan_rabat,ukupno_za_placanje,zatvorena,narudzbenica_id,poslovna_godina_id,poslovni_partner_id,preduzece_id) VALUES (3,21,102,'2018-07-06','2018-07-19',122,'ULAZNA',27,80,122,true,3,5,6,2);
INSERT INTO faktura (id, bezpdv, broj, datum, datum_valute,preostali_iznos,tip,ukupanpdv, ukupan_rabat,ukupno_za_placanje,zatvorena,narudzbenica_id,poslovna_godina_id,poslovni_partner_id,preduzece_id) VALUES (4,22,103,'2018-07-07','2018-07-04',40,'IZLAZNA',28,0,40,true,4,5,7,3);
INSERT INTO faktura (id, bezpdv, broj, datum, datum_valute,preostali_iznos,tip,ukupanpdv, ukupan_rabat,ukupno_za_placanje,zatvorena,narudzbenica_id,poslovna_godina_id,poslovni_partner_id,preduzece_id) VALUES (5,23,104,'2018-07-08','2018-07-22',510,'ULAZNA',29,0,510,true,null,5,8,3);
INSERT INTO faktura (id, bezpdv, broj, datum, datum_valute,preostali_iznos,tip,ukupanpdv, ukupan_rabat,ukupno_za_placanje,zatvorena,narudzbenica_id,poslovna_godina_id,poslovni_partner_id,preduzece_id) VALUES (6,24,105,'2018-07-09','2018-07-23',480,'IZLAZNA',30,12,480,true,null,9,3,1);

INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (1,20,22,2,5,50,12,10,200,1,1);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (2,21,21,60,5,50,12,10,200,1,3);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (3,22,19,55,13,55,3,11,520,2,3);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (4,20,23,50,2,200,13,1,820,3,7);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (5,19,16,60,7,255,23,12,1220,4,2);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (6,18,14,65,5,55,13,10,230,5,6);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (7,10,19,30,3,43,15,21,120,6,1);
INSERT INTO stavka_fakture (id, iznos_pdv, iznos_rabata, jedinicna_cena, kolicina_stavke_fakture,osnovica,procenat_rabata, stopa_pdv, ukupan_iznos,faktura_id,proizvod_id) VALUES (8,14,15,20,2,140,14,11,420,6,3);


