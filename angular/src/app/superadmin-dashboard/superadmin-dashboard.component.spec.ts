import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperadminDashboardComponent } from './superadmin-dashboard.component';

describe('SuperadminDashboardComponent', () => {
  let component: SuperadminDashboardComponent;
  let fixture: ComponentFixture<SuperadminDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuperadminDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperadminDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
