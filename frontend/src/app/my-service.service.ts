import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class MyService {
  private baseUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  analyzeText(online: boolean, type: string, text: string) {
    if (online) {
      try {
        console.log('text analyzed online')
        return this.fetchData(type, text)
      } catch (e) {
        alert("You're offline. The text is analyzed offline")
      }
    }
    return new Observable((observer) => {
      console.log('text analyzed offline')
      const frequencyArray: number[] = new Array(26).fill(0);
      let result: string = "";
      const chars: string[] = text.split('');

      // Create frequency array
      for (let i = 0; i < chars.length; i++) {
        let charCode: number = chars[i].charCodeAt(0) - 'A'.charCodeAt(0);
        if (charCode >= 32) charCode -= 32;
        if (charCode >= 0 && charCode <= 31) frequencyArray[charCode]++;
      }

      // Create result from frequency array
      for (let i = 0; i < 26; i++) {
        if (type === "vowels") {
          if (i === 0 || i === 'E'.charCodeAt(0) - 'A'.charCodeAt(0) || i === 'I'.charCodeAt(0) - 'A'.charCodeAt(0) ||
            i === 'O'.charCodeAt(0) - 'A'.charCodeAt(0) || i === 'U'.charCodeAt(0) - 'A'.charCodeAt(0)) {
            if (frequencyArray[i] > 0)
              result = result.concat(`Letter '${String.fromCharCode('A'.charCodeAt(0) + i)}' appears ${frequencyArray[i]} times\n`);
          }
        } else if (type === "consonants") {
          if (i !== 0 && i !== 'E'.charCodeAt(0) - 'A'.charCodeAt(0) && i !== 'I'.charCodeAt(0) - 'A'.charCodeAt(0) &&
            i !== 'O'.charCodeAt(0) - 'A'.charCodeAt(0) && i !== 'U'.charCodeAt(0) - 'A'.charCodeAt(0)) {
            if (frequencyArray[i] > 0)
              result = result.concat(`Letter '${String.fromCharCode('A'.charCodeAt(0) + i)}' appears ${frequencyArray[i]} times\n`);
          }
        }
      }

      observer.next(result);
      observer.complete();
    });
  }

  fetchData(type: string, text: string): Observable<any> {
    const params = new HttpParams({ fromObject: { type, text } });
    return this.http.get(`${this.baseUrl}/text-analyzer`, { responseType: 'text', params });
  }
}
