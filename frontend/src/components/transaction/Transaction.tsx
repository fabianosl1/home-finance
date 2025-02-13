import { TransactionService } from "@/services/TransactionService"
import { TransactionResponse } from "@/types/Transaction"
import { useEffect, useState } from "react"
import TableTransactions from "./TableTransactions"
import { Button, VStack } from "@chakra-ui/react"
import { errorFeedback } from "@/utils/errorFeedback"

export default function Transaction() {
    const [transactions, setTransactions] = useState<TransactionResponse[]>([])
    const [loading, setLoading] = useState(false)
    
    const fetch = async () => {
        try {
            setLoading(true)
            await errorFeedback(async () => { 
                const {transactions} = await TransactionService.listAll()
                setTransactions(transactions)
            })
        } finally {
            setLoading(false)
        }
    }

    useEffect(()=> {
        fetch()
    }, [])

    return(
        <>
            <VStack alignItems="end" gap={4}>
                <Button onClick={fetch} loading={loading}>Atualizar</Button>
                <TableTransactions transactions={transactions}/>
            </VStack>
        </>
    )
}