import { TestBed } from '@angular/core/testing';

import { CitaMedicaServices } from './cita-medica-services';

describe('CitaMedicaServices', () => {
  let service: CitaMedicaServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CitaMedicaServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
