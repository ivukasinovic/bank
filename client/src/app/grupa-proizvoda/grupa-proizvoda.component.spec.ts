import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupaProizvodaComponent } from './grupa-proizvoda.component';

describe('GrupaProizvodaComponent', () => {
  let component: GrupaProizvodaComponent;
  let fixture: ComponentFixture<GrupaProizvodaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupaProizvodaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupaProizvodaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
