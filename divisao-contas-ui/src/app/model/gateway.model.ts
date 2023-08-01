import { GatewayPagamentoEnum } from "./geteway-pagamento.enum";

export interface Gateway {
    label: string;
    value: GatewayPagamentoEnum;
}