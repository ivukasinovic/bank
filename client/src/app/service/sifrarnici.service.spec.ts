import { TestBed, inject } from '@angular/core/testing';

import { SifrarniciService } from './sifrarnici.service';

describe('SifrarniciService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SifrarniciService]
    });
  });

  it('should be created', inject([SifrarniciService], (service: SifrarniciService) => {
    expect(service).toBeTruthy();
  }));
});
