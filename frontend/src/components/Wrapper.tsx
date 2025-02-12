import { Tabs, VStack } from "@chakra-ui/react";
import TableTransactions from "./TableTransactions";

import { useEffect, useState } from "react";
import { TransactionService } from "@/services/TransactionService";
import { TransactionResponse } from "@/types/Transaction";

import Person from "./person/Person";

export default function Wrapper() {
    const [transactions, setTransactions] = useState<TransactionResponse[]>([])

    useEffect(() => {
        TransactionService.listAll()
        .then(({transactions}) => setTransactions(transactions))
    },[])
    return (
      <>
        <Tabs.Root width="full" defaultValue="persons">
            <Tabs.List>
                <Tabs.Trigger value="persons">
                    Pessoas
                </Tabs.Trigger>
                <Tabs.Trigger value="transactions">
                    Transações
                </Tabs.Trigger>
            </Tabs.List>
            <Tabs.Content value="persons">
                <Person/>
            </Tabs.Content>
            <Tabs.Content value="transactions">
            <VStack alignItems="end">
                <TableTransactions transactions={transactions}/>
            </VStack>

            </Tabs.Content>
        </Tabs.Root>
      </>
    )
}