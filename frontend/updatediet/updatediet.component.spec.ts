import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatedietComponent } from './updatediet.component';

describe('UpdatedietComponent', () => {
  let component: UpdatedietComponent;
  let fixture: ComponentFixture<UpdatedietComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatedietComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatedietComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
