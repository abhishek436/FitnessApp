import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProteinFoodComponent } from './protein-food.component';

describe('ProteinFoodComponent', () => {
  let component: ProteinFoodComponent;
  let fixture: ComponentFixture<ProteinFoodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProteinFoodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProteinFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
