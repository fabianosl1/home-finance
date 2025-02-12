import { TransactionService } from "@/services/TransactionService"
import { TransactionResponse } from "@/types/Transaction"
import { useEffect, useState } from "react"
import TableTransactions from "./TableTransactions"
import { Button, VStack } from "@chakra-ui/react"

export default function Transaction() {
    const [transactions, setTransactions] = useState<TransactionResponse[]>([])

    const fetch = async () => {
        const {transactions} = await TransactionService.listAll()
        setTransactions(transactions)
    }

    useEffect(()=> {
        fetch()
    }, [])

    return(
        <>
            <VStack alignItems="end" gap={4}>
                <Button onClick={fetch}>Atualizar</Button>
                <TableTransactions transactions={transactions}/>
            </VStack>
        </>
    )
}