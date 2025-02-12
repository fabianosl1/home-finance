import { useContext } from "react";
import { TransactionContext } from "../transaction/TransactionContext";

export function useTransaction() {
        const context = useContext(TransactionContext)

        if (context === null) {
            throw new Error("transaction context not load")
        }

        return context
}