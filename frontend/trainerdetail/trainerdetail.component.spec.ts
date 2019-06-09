import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerdetailComponent } from './trainerdetail.component';

describe('TrainerdetailComponent', () => {
  let component: TrainerdetailComponent;
  let fixture: ComponentFixture<TrainerdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
