import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StopaPdvComponent } from './stopa-pdv.component';

describe('StopaPdvComponent', () => {
  let component: StopaPdvComponent;
  let fixture: ComponentFixture<StopaPdvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StopaPdvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StopaPdvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
