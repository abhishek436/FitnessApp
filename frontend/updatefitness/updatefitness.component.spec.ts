import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatefitnessComponent } from './updatefitness.component';

describe('UpdatefitnessComponent', () => {
  let component: UpdatefitnessComponent;
  let fixture: ComponentFixture<UpdatefitnessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatefitnessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatefitnessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
