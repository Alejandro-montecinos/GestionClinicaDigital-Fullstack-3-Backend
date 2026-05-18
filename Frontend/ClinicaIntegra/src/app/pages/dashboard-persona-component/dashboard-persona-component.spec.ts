import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardPersonaComponent } from './dashboard-persona-component';

describe('DashboardPersonaComponent', () => {
  let component: DashboardPersonaComponent;
  let fixture: ComponentFixture<DashboardPersonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardPersonaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardPersonaComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
