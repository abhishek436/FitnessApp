import { TestBed, inject } from '@angular/core/testing';

import { FabfitServiceService } from './fabfitService.service';

describe('FabfitServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FabfitServiceService]
    });
  });

  it('should be created', inject([FabfitServiceService], (service: FabfitServiceService) => {
    expect(service).toBeTruthy();
  }));
});
