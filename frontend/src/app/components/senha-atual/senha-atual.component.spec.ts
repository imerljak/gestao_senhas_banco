import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SenhaAtualComponent } from './senha-atual.component';

describe('SenhaAtualComponent', () => {
  let component: SenhaAtualComponent;
  let fixture: ComponentFixture<SenhaAtualComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SenhaAtualComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SenhaAtualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
