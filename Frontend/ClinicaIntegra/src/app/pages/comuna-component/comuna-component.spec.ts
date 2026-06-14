import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComunaComponent } from './comuna-component';

describe('ComunaComponent', () => {
  let component: ComunaComponent;
  let fixture: ComponentFixture<ComunaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComunaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ComunaComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
