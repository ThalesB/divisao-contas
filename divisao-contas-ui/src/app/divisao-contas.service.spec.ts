import { TestBed } from '@angular/core/testing';

import { DivisaoContasService } from './divisao-contas.service';

describe('DivisaoContasService', () => {
  let service: DivisaoContasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DivisaoContasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
