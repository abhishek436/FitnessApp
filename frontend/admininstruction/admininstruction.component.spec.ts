import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmininstructionComponent } from './admininstruction.component';

describe('AdmininstructionComponent', () => {
  let component: AdmininstructionComponent;
  let fixture: ComponentFixture<AdmininstructionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmininstructionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmininstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
