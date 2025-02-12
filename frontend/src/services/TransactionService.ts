import { ListTransactionsResponse } from "@/types/Transaction";
import { ApiService } from "./ApiService";

export class TransactionService {
    
    private constructor() {}
    
    static async listAll(): Promise<ListTransactionsResponse> {
        return await ApiService.get("/transactions")
    }

}