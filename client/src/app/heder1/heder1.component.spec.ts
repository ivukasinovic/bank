import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Heder1Component } from './heder1.component';

describe('Heder1Component', () => {
  let component: Heder1Component;
  let fixture: ComponentFixture<Heder1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Heder1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Heder1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
