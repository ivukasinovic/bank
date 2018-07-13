import {Component, OnInit, TemplateRef} from '@angular/core';
import {Valuta} from '../model/model';
import {SifrarniciService} from '../service/sifrarnici.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Router} from '@angular/router';

@Component({
  selector: 'app-valute',
  templateUrl: './valute.component.html',
  styleUrls: ['./valute.component.css']
})
export class ValuteComponent implements OnInit {

  valute: Valuta[] = [];
  val: Valuta;
  modalRef: BsModalRef;

  constructor( private sifrarniciService: SifrarniciService, private modalService: BsModalService, private router: Router) {
    this.val = new Valuta();
  }

  ngOnInit() {
    this.sifrarniciService.getValute().subscribe(
      (response: Valuta[]) => {
        this.valute = response;
    },
     error2 => {
        alert('Nisu ucitane valute!');
     }
    );
  }

  obrisi (id: number) {
    this.sifrarniciService.deleteValute(id).subscribe( (response: any) => {
      this.valute.forEach( function (value, index, array) {
        if (value.id === id) {
          array.splice(index, 1);
        }
      });
    },
      error2 => {
      alert('Nije moguće obrisati valutu jer postoje cenovnici u toj valuti!');
      });

  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  dodajValutu() {
    this.sifrarniciService.postValutu(this.val).subscribe(
      (response: Valuta) => {
        this.valute.push(response);
        this.val = new Valuta();
        this.modalRef.hide();
      },
      error2 => {
        alert('Već postoji oznaka!');
      }
    );
  }
}
