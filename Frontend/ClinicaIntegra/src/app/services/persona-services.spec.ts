import { TestBed } from '@angular/core/testing';

import { PersonaServices } from './persona-services';

describe('PersonaServices', () => {
  let service: PersonaServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonaServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
