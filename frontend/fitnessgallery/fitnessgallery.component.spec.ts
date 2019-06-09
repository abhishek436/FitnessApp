import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FitnessgalleryComponent } from './fitnessgallery.component';

describe('FitnessgalleryComponent', () => {
  let component: FitnessgalleryComponent;
  let fixture: ComponentFixture<FitnessgalleryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FitnessgalleryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FitnessgalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
