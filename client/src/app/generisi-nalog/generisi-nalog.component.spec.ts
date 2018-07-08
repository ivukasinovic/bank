import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerisiNalogComponent } from './generisi-nalog.component';

describe('GenerisiNalogComponent', () => {
  let component: GenerisiNalogComponent;
  let fixture: ComponentFixture<GenerisiNalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenerisiNalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerisiNalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
