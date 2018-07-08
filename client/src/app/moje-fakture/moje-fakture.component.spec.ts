import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MojeFaktureComponent } from './moje-fakture.component';

describe('MojeFaktureComponent', () => {
  let component: MojeFaktureComponent;
  let fixture: ComponentFixture<MojeFaktureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MojeFaktureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MojeFaktureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
