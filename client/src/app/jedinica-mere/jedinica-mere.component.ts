import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {JedinicaMere, Valuta} from '../model/model';
import {SifrarniciService} from '../service/sifrarnici.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-jedinica-mere',
  templateUrl: './jedinica-mere.component.html',
  styleUrls: ['./jedinica-mere.component.css']
})
export class JedinicaMereComponent implements OnInit {

 jediniceList: JedinicaMere[] = [];
 jedMere: JedinicaMere;
  modalRef: BsModalRef;

  constructor(private sifrarniciService: SifrarniciService, private modalService: BsModalService, private router: Router) {
    this.jedMere = new JedinicaMere();
  }

  ngOnInit() {
    this.sifrarniciService.getJediniceMere().subscribe(
      (response: JedinicaMere[]) => {
        this.jediniceList = response;
      },
      error2 => {
        alert('Nisu ucitane jedinice mere!');
      }
    );
  }
  obrisi (id: number) {
    this.sifrarniciService.deleteJediniceMere(id).subscribe( (response: any) => {
        this.jediniceList.forEach( function (value, index, array) {
          if (value.id === id) {
            array.splice(index, 1);
          }
        });
      },
      error2 => {
        alert('Nije moguće obrisati jedinicu mere jer se proizvodi mere u njoj!');
      });

  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  dodaj() {
    this.sifrarniciService.postJedinicuMere(this.jedMere).subscribe(
      (response: JedinicaMere) => {
        this.jediniceList.push(response);
        this.jedMere = new JedinicaMere();
        this.modalRef.hide();
      },
      error2 => {
        alert('Već postoji jedinica!');
      }
    );
  }
}
