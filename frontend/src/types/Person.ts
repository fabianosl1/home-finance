export type ListPersonsResponse = {
    persons: PersonResponse[]
}

export type PersonResponse = {
    id: number;
    name: string;
    age: number;
    transactions: {
        incomes: number;
        expenses: number;
        balance: number;
    }
}