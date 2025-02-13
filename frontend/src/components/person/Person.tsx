import { PersonService } from "@/services/PersonService"
import { Amounts, PersonAmountResponse } from "@/types/Person"
import { useEffect, useState } from "react"
import TablePersons from "./TablePerson"
import AddPersonForm from "./AddPersonForm"
import { Button, HStack, VStack } from "@chakra-ui/react"
import { TransactionProvider } from "../transaction/TransactionProvider"
import { errorFeedback } from "@/utils/errorFeedback"

export default function Person() {
    const [persons, setPersons] = useState<PersonAmountResponse[]>([])
    const [amounts, setAmounts] = useState<Amounts>({balance: 0, expenses:0, incomes: 0})
    const [loading, setLoading] = useState(false)

    async function fetch() {        
        try {
            setLoading(true)
            await errorFeedback(async () => {                        
                const {persons, amounts} = await PersonService.listWithAmounts()
                setPersons(persons)    
                setAmounts(amounts)               
            })
        } finally {
            setLoading(false)
        }
        
    }

    useEffect(() => {
        fetch()
    }, [])

    return (
        <>
            <VStack alignItems="end" gap={4}>
            <HStack>
                <AddPersonForm />
                <Button onClick={fetch} loading={loading}>Atualizar</Button>
            </HStack>
            <TransactionProvider>
                <TablePersons persons={persons} amounts={amounts}/>
            </TransactionProvider>

            </VStack>
        </>
    )
}