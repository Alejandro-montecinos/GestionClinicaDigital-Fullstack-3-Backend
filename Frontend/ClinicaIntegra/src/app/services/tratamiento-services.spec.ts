import { TestBed } from '@angular/core/testing';

import { TratamientoServices } from './tratamiento-services';

describe('TratamientoService', () => {
  let service: TratamientoServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TratamientoServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
