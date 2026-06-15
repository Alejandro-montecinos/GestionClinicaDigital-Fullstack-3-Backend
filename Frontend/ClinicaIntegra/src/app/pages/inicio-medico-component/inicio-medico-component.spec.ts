import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioMedicoComponent } from './inicio-medico-component';

describe('InicioMedicoComponent', () => {
  let component: InicioMedicoComponent;
  let fixture: ComponentFixture<InicioMedicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InicioMedicoComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(InicioMedicoComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
