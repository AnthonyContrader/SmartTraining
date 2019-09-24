import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GruppoComponent } from './gruppo.component';

describe('GruppoComponent', () => {
  let component: GruppoComponent;
  let fixture: ComponentFixture<GruppoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GruppoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GruppoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
