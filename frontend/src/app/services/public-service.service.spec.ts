import { TestBed } from '@angular/core/testing';

import { PublicService } from './public-service.service';

describe('PublicServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PublicService = TestBed.get(PublicService);
    expect(service).toBeTruthy();
  });
});
