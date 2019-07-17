import { TestBed } from '@angular/core/testing';

import { PrivateGuardService } from './private-guard.service';

describe('PrivateGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PrivateGuardService = TestBed.get(PrivateGuardService);
    expect(service).toBeTruthy();
  });
});
