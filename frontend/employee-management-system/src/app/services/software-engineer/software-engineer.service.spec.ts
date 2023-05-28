import { TestBed } from '@angular/core/testing';

import { SoftwareEngineerService } from './software-engineer.service';

describe('SoftwareEngineerService', () => {
  let service: SoftwareEngineerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SoftwareEngineerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
