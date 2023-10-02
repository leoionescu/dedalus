import { TestBed } from '@angular/core/testing';
import { MyService } from './my-service.service';
// import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClientModule } from '@angular/common/http';

describe('MyServiceService', () => {
  let service: MyService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule], providers: [MyService]
    });
    service = TestBed.inject(MyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('simple text - vowels - offline', (done: DoneFn) => {
    const online = false;
    const type = 'vowels';
    const text = 'This is a sample text';

    service.analyzeText(online, type, text).subscribe((result) => {
      // Split the result into lines and trim white spaces
      const lines = result.split('\n').map((line: string) => line.trim());

      expect(lines).toContain("Letter 'A' appears 2 times");
      expect(lines).toContain("Letter 'E' appears 2 times");
      expect(lines).toContain("Letter 'I' appears 2 times");
      done();
    });
  });

  it('simple text - consonants - offline', (done: DoneFn) => {
    const online = false;
    const type = 'consonants';
    const text = 'This is a sample text';

    service.analyzeText(online, type, text).subscribe((result) => {
      // Split the result into lines and trim white spaces
      const lines = result.split('\n').map((line: string) => line.trim());

      expect(lines).toContain("Letter 'H' appears 1 times");
      expect(lines).toContain("Letter 'L' appears 1 times");
      expect(lines).toContain("Letter 'M' appears 1 times");
      expect(lines).toContain("Letter 'P' appears 1 times");
      expect(lines).toContain("Letter 'S' appears 3 times");
      expect(lines).toContain("Letter 'T' appears 3 times");
      expect(lines).toContain("Letter 'X' appears 1 times");

      done();
    });
  });

  it('hard text - vowels - offline', (done: DoneFn) => {
    const online = false;
    const type = 'vowels';
    const text = 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.';

    service.analyzeText(online, type, text).subscribe((result) => {
      // Split the result into lines and trim white spaces
      const lines = result.split('\n').map((line: string) => line.trim());

      expect(lines).toContain("Letter 'A' appears 103 times");
      expect(lines).toContain("Letter 'E' appears 125 times");
      expect(lines).toContain("Letter 'I' appears 71 times");
      expect(lines).toContain("Letter 'O' appears 95 times");
      expect(lines).toContain("Letter 'U' appears 68 times");
      done();
    });
  });

  it('hard text - consonants - offline', (done: DoneFn) => {
    const online = false;
    const type = 'consonants';
    const text = 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.';

    service.analyzeText(online, type, text).subscribe((result) => {
      // Split the result into lines and trim white spaces
      const lines = result.split('\n').map((line: string) => line.trim());

      expect(lines).toContain("Letter 'B' appears 13 times");
      expect(lines).toContain("Letter 'C' appears 26 times");
      expect(lines).toContain("Letter 'D' appears 61 times");
      expect(lines).toContain("Letter 'G' appears 18 times");
      expect(lines).toContain("Letter 'J' appears 4 times");
      expect(lines).toContain("Letter 'K' appears 8 times");
      expect(lines).toContain("Letter 'L' appears 51 times");
      expect(lines).toContain("Letter 'M' appears 74 times");
      expect(lines).toContain("Letter 'N' appears 47 times");
      expect(lines).toContain("Letter 'P' appears 24 times");
      expect(lines).toContain("Letter 'Q' appears 5 times");
      expect(lines).toContain("Letter 'R' appears 73 times");
      expect(lines).toContain("Letter 'S' appears 83 times");
      expect(lines).toContain("Letter 'T' appears 111 times");
      expect(lines).toContain("Letter 'V' appears 14 times");
      expect(lines).toContain("Letter 'Y' appears 10 times");
      done();
    });
  });

});
