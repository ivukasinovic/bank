import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StavkeCenovnikaComponent } from './stavke-cenovnika.component';

describe('StavkeCenovnikaComponent', () => {
  let component: StavkeCenovnikaComponent;
  let fixture: ComponentFixture<StavkeCenovnikaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StavkeCenovnikaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StavkeCenovnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
