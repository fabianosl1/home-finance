import { ListPersonsResponse } from "@/types/Person";
import { apiService } from "./ApiService";

export class PersonService {
    
    static async listAll(): Promise<ListPersonsResponse> {
        return await apiService.get("/persons")
    }

}

