import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengarComponent } from './passengar.component';

describe('PassengarComponent', () => {
  let component: PassengarComponent;
  let fixture: ComponentFixture<PassengarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassengarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
