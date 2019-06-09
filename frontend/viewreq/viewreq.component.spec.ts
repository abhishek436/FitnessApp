import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewreqComponent } from './viewreq.component';

describe('ViewreqComponent', () => {
  let component: ViewreqComponent;
  let fixture: ComponentFixture<ViewreqComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewreqComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewreqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
