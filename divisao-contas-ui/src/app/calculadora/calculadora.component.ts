import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ContaGeral } from '../model/conta-geral.model';
import { Item } from '../model/item.model';
import { Conta } from '../model/conta.model';
import { GatewayPagamentoEnum } from '../model/geteway-pagamento.enum';
import { Gateway } from '../model/gateway.model';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {


  valorTotal: number = 0;
  valorTaxaExtra: number = 0 ;
  isChecked: boolean = false;
  valorEntrega: number = 0 ;
  descontos: number = 0 ;
  pix: string;
  credencial: string;
  contaGeral: ContaGeral;
  valorSelecionado: GatewayPagamentoEnum;

  obterOpcoesEnum(): GatewayPagamentoEnum[] {
    return Object.values(GatewayPagamentoEnum);
  }

  nomeConta: string = '' ;
  numeroConta:number= 0 ;
  valorItem: number = 0 ;
  nomeItem: string = '' ;

  items: Item[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.valorTotal = 0;

  }

  public adicionarContaGeral(): void {
     const conta: ContaGeral = {
        taxaAtendimento: this.isChecked,
        valorEntrega: this.valorEntrega,
        valorTaxaExtra: this.valorTaxaExtra,
        valorTotal: this.valorTotal,
        descontos: this.descontos,
        pix: this.pix,
        credencial: this.credencial,
        gatewayPagamento: this.valorSelecionado
    }

    this.contaGeral = conta;

    console.log(this.contaGeral)
  }

  public adicionarItem(): void {
    const item: Item = {
       nomeConta: this.nomeConta,
       numeroConta: this.numeroConta,
       valorItem: this.valorItem,
       nomeItem: this.nomeItem
   }

   this.items.push(item);
   console.log(this.items);
 }

  public ativarDesativar(checked: boolean): void {
      if (checked == false){
        this.isChecked = true;
      } 
      if (checked == true) {
        this.isChecked = false;
      }
  }

  public limparConta(): void{
    location.reload();
  }

  calcular() {
    const calculoConta: Conta = {
        items: this.items,
        conta: this.contaGeral
    }

    console.log(calculoConta);
  }

}
