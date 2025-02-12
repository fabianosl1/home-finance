import { ListTransactionsResponse } from "@/types/Transaction";
import { apiService } from "./ApiService";

export class TransactionService {
    
    static async listAll(): Promise<ListTransactionsResponse> {
        return await apiService.get("/transactions")
    }

}