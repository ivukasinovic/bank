import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartneriComponent } from './partneri.component';

describe('PartneriComponent', () => {
  let component: PartneriComponent;
  let fixture: ComponentFixture<PartneriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartneriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartneriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
