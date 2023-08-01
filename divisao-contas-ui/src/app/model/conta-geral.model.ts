import { GatewayPagamentoEnum } from "./geteway-pagamento.enum";

export interface ContaGeral{
    valorTotal: number;
    valorTaxaExtra: number;
    taxaAtendimento: boolean;
    valorEntrega: number;
    descontos: number;
    pix: string;
    credencial: string;
    gatewayPagamento: GatewayPagamentoEnum;
}