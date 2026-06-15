import { TestBed } from '@angular/core/testing';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { CitaMedicaService } from './cita-medica-service';

describe('CitaMedicaService', () => {
  let service: CitaMedicaService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        CitaMedicaService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(CitaMedicaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});