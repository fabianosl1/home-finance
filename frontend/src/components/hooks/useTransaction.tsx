import { useContext } from "react";
import { TransactionContext } from "../transaction/TransactionContext";
/*
 * Estava tendo problemas com o dialog e tentei utilizar essa estrategia com Contenxt e hooks
 * fiz algo semelhante em: https://github.com/fabianosl1/frontend-mosaicq-challenge
*/
export function useTransaction() {
        const context = useContext(TransactionContext)

        if (context === null) {
            throw new Error("transaction context not load")
        }

        return context
}