import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrijedlogPlacanjaComponent } from './prijedlog-placanja.component';

describe('PrijedlogPlacanjaComponent', () => {
  let component: PrijedlogPlacanjaComponent;
  let fixture: ComponentFixture<PrijedlogPlacanjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrijedlogPlacanjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrijedlogPlacanjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
