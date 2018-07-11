import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StavkeFaktureComponent } from './stavke-fakture.component';

describe('StavkeFaktureComponent', () => {
  let component: StavkeFaktureComponent;
  let fixture: ComponentFixture<StavkeFaktureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StavkeFaktureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StavkeFaktureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
