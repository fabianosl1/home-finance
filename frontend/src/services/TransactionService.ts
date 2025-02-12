import { CreateTransactionRequest, CreateTransactionResponse, ListTransactionsResponse } from "@/types/Transaction";
import { ApiService } from "./ApiService";

export class TransactionService {
    
    private constructor() {}
    
    static async listAll(): Promise<ListTransactionsResponse> {
        return await ApiService.get("/transactions")
    }

    static async create(personId: number, body: CreateTransactionRequest): Promise<CreateTransactionResponse> {
        return await ApiService.post(`/persons/${personId}/transactions`, body)
    }

}