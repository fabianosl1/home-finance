export class ApiException extends Error {
    constructor(public readonly messages: string[]) {
        super()
    }
}