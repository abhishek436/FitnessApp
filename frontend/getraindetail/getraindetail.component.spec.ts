import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetraindetailComponent } from './getraindetail.component';

describe('GetraindetailComponent', () => {
  let component: GetraindetailComponent;
  let fixture: ComponentFixture<GetraindetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetraindetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetraindetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
