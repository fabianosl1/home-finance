export type ListPersonsResponse = {
    persons: PersonResponse[]
}

export type PersonResponse = {
    id: number;
    name: string;
    age: number;
}

export type ListPersonsAmountsResponse = {
    persons: PersonAmountResponse[];
    amounts: Amounts
}

export type PersonAmountResponse = PersonResponse & {
    amounts: Amounts
}

export type Amounts = {
    expenses: number;
    incomes: number;
    balance: number;
}

export type CreatePersonRequest = {
    name: string;
    age: number;
}

export type CreatePersonResponse = {
    id: number;
    name: string;
    age: number;
}