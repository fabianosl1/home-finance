export class ApiService {
    private static url: string = import.meta.env.VITE_API_URL

    private static headers = {
        "Content-Type": "application/json"
    }

    private constructor() {}

    static async get<T>(path: string) {
        return this.makeRequest<T>(path, "GET")
    }

    static async post<T>(path: string, body: Record<string, unknown>) {
        return await this.makeRequest<T>(path, "POST", body)
    }

    static async delete(path: string) {
        return await this.makeRequest(path, "DELETE");
    }

    private static async makeRequest<T>(path: string, method: string, body?: Record<string, unknown>): Promise<T> {
        const config :RequestInit = {
            headers: this.headers,
            method: method
        }

        if (body) {
            config.body = JSON.stringify(body)
        }

        const response = await fetch(this.url + path, config);

        return response.json();
    }
}
