import { TestBed } from '@angular/core/testing';

import { ConsultaMedicaServices } from './consulta-medica-services';

describe('ConsultaMedicaServices', () => {
  let service: ConsultaMedicaServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsultaMedicaServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
