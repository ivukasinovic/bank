
export class User {
  id: number;
  username: string;
  name: string;
  surname: string;
  email: string;
  adress: string;
  city: string;
  number: string;
  role: string;
  password: string;
  activated: boolean;
}

export class Adresa {
  id: number;
  broj: number;
  drzava: string;
  grad: string;
  ulica: string;
  postanski_broj: number;
}

export class Preduzece {
  id: number;
  naziv: string;
  pib: string;
  lozinka: string;
  email: string;
  adresa: Adresa;   // samo broj
  // activated: boolean;
}

export class Partnerstvo {
  id: number;
  datum: string;
  preduzece2: Preduzece;
  preduzece1: Preduzece;
}

export class Faktura {
  id: number;
  broj: number;
  preostaliIznos: number;
  ukupnoZaPlacanje: number;
  status: string;
  datum: string;
  valuta: string;
  ukupanRabat: number;
  bezPDV: number;
  ukupanPDV: number;
  datumValute: string;
  poslovnaGodina: string;
  primalac: Preduzece;
  duznik: Preduzece;
  stavkaFaktureList: StavkaFakture[];
}

export class StaSePlaca {
  faktura: Faktura;
  iznos: number;
}

export class StopaPDV {
  id: number;
  datumVazenja: string;
  stopa: number;
  pdv: string ;
}
export class PDV {
  id: number;
  naziv: string;
  stopaPDVList: StopaPDV[];
}

export class GrupaProizvoda {
  id: number;
  naziv: string;
  opis: string;
  pdv: string; // naziv pdv kom pripada
}

export class StavkaFakture {
  id: number;
  osnovica: number;
  iznosRabata: number;
  procenatRabata: number;
  stopaPdv: number;
  iznosPdv: number;
  jedinicnaCena: number;
  kolicinaStavkeFakture: number;
  ukupanIznos: number;
  proizvod: string;
}
export class StavkaCenovnika {
  id: number;
  cena: number;
  proizvod: Proizvod;
  cenovnik: Cenovnik;
}


export class Cenovnik {
  id: number;
  datumVazenja: Date;
  valuta: string;
  stavkaCenovnikaList: StavkaCenovnika[];
  preduzece: Preduzece;
}

export class Valuta {
  id: number;
  oznaka: string;
  naziv: string;
}

export class Proizvod {
  id: number;
  naziv: string;
  opis: string;
  grupaProizvoda: any;
  jedinicaMere: string;
  preduzece: Preduzece;
}

export class NalogZaPlacanje {
  id: number;
  duzink: string;
  primalac: string;
  svrha: string;
  datumNaloga: string;
  datumValute: string;
  modelZaduzenja: number;
  pozivNaBrojZaduzenja: string;
  modelOdobrenja: number;
  pozivNaBrojOdobrenja: string;
  oznakaValute: string;
  hitno: boolean;
  iznos: number;
}

export class JedinicaMere {
  id: number;
  naziv: string;
  skracenica: string;
}
