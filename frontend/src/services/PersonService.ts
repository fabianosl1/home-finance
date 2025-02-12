import { CreatePersonRequest, CreatePersonResponse, ListPersonsResponse } from "@/types/Person";
import { ApiService } from "./ApiService";

export class PersonService {
    
    private constructor() {}
    
    static async listAll(): Promise<ListPersonsResponse> {
        return await ApiService.get("/persons")
    }


    static async save(person: CreatePersonRequest): Promise<CreatePersonResponse> {
        return await ApiService.post("/persons", person)
    }
}

