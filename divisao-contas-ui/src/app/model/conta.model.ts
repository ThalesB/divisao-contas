import { ContaGeral } from "./conta-geral.model";
import { Item } from "./item.model";

export interface Conta {
    items: Item[];
    conta: ContaGeral;
}