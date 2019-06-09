import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerregComponent } from './trainerreg.component';

describe('TrainerregComponent', () => {
  let component: TrainerregComponent;
  let fixture: ComponentFixture<TrainerregComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerregComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
