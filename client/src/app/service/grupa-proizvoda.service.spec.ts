import { TestBed, inject } from '@angular/core/testing';

import { GrupaProizvodaService } from './grupa-proizvoda.service';

describe('GrupaProizvodaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GrupaProizvodaService]
    });
  });

  it('should be created', inject([GrupaProizvodaService], (service: GrupaProizvodaService) => {
    expect(service).toBeTruthy();
  }));
});
