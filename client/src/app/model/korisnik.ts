
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
  adresa: number;   // samo broj
  // activated: boolean;

}

