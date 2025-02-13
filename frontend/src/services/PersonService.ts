import { CreatePersonRequest, CreatePersonResponse, ListPersonsAmountsResponse, ListPersonsResponse } from "@/types/Person";
import { ApiService } from "./ApiService";

export class PersonService {
    
    private constructor() {}
    
    static async list(): Promise<ListPersonsResponse> {
        return await ApiService.get("/persons")
    }

    static async listWithAmounts(): Promise<ListPersonsAmountsResponse> {
        return await ApiService.get("/persons/amounts")
    }

    static async save(person: CreatePersonRequest): Promise<CreatePersonResponse> {
        return await ApiService.post("/persons", person)
    }

    static async delete(personId: number): Promise<void> {
        await ApiService.delete("/persons/" + personId)
    }
}

