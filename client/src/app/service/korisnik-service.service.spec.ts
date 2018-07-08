import { TestBed, inject } from '@angular/core/testing';

import { KorisnikServiceService } from './korisnik-service.service';

describe('KorisnikServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KorisnikServiceService]
    });
  });

  it('should be created', inject([KorisnikServiceService], (service: KorisnikServiceService) => {
    expect(service).toBeTruthy();
  }));
});
