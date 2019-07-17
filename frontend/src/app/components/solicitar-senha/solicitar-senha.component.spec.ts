import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitarSenhaComponent } from './solicitar-senha.component';

describe('SolicitarSenhaComponent', () => {
  let component: SolicitarSenhaComponent;
  let fixture: ComponentFixture<SolicitarSenhaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SolicitarSenhaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SolicitarSenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
