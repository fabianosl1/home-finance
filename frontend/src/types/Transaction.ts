export type TransactionResponse = {
    id: number;
    description: string;
    amount: number;
    type: "EXPENSE" | "INCOME";
}

export type ListTransactionsResponse = {
    transactions: TransactionResponse[]
}

export type CreateTransactionRequest = {
    description: string;
    amount: number;
    type: "EXPENSE" | "INCOME";
}

export type CreateTransactionResponse = {
    id: number;
    description: string;
    amount: number;
    type: "EXPENSE" | "INCOME";
}