import { Component } from '@angular/core';
import { MyService } from './my-service.service';
import { AnalyzedText } from './AnalyzedText';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  inputText = ''
  entries: AnalyzedText[] = [];
  selectedMode = 'online';
  selectedType = 'vowels';

  constructor(private myService: MyService) { }

  addEntry(entry: AnalyzedText) {
    if (entry) {
      this.entries.unshift(entry);
    }
    this.inputText = ''
  }

  fetchData(): void {
    this.myService.analyzeText(this.selectedMode == 'online', this.selectedType, this.inputText).subscribe(
      (response) => {
        console.log(response)
        this.addEntry({ type: this.selectedType, text: this.inputText, result: response })
      },
      (error) => {
        console.error('Error:', error);
      }
    );

  }
}

