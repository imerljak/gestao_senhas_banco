import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UltimasSenhasComponent } from './ultimas-senhas.component';

describe('UltimasSenhasComponent', () => {
  let component: UltimasSenhasComponent;
  let fixture: ComponentFixture<UltimasSenhasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UltimasSenhasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UltimasSenhasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
