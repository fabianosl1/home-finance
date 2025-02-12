import { Tabs } from "@chakra-ui/react";
import TableTransactions from "./TableTransactions";

import TablePersons from "./TablePerson";
import { useEffect, useState } from "react";
import { PersonResponse } from "@/types/Person";
import { PersonService } from "@/services/PersonService";
import { TransactionService } from "@/services/TransactionService";
import { TransactionResponse } from "@/types/Transaction";

export default function Wrapper() {
    const [persons, setPersons] = useState<PersonResponse[]>([])
    const [transactions, setTransactions] = useState<TransactionResponse[]>([])

    useEffect(() => {
        PersonService.listAll()
        .then(({persons}) => setPersons(persons))

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
                <TablePersons persons={persons}/>
            </Tabs.Content>
            <Tabs.Content value="transactions">
                <TableTransactions transactions={transactions}/>
            </Tabs.Content>
        </Tabs.Root>
      </>
    )
}