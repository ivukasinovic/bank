import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajPdvComponent } from './dodaj-pdv.component';

describe('DodajPdvComponent', () => {
  let component: DodajPdvComponent;
  let fixture: ComponentFixture<DodajPdvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajPdvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajPdvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
