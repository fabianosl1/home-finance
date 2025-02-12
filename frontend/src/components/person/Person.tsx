import { PersonService } from "@/services/PersonService"
import { PersonResponse } from "@/types/Person"
import { useEffect, useState } from "react"
import TablePersons from "./TablePerson"
import AddPersonForm from "./AddPersonForm"
import { Button, HStack, VStack } from "@chakra-ui/react"
import { TransactionProvider } from "../transaction/TransactionProvider"

export default function Person() {
    const [persons, setPersons] = useState<PersonResponse[]>([])
    
    async function fetch() {
        const {persons} = await PersonService.listAll()
        setPersons(persons)
    }

    useEffect(() => {
        fetch()
    }, [])

    return (
        <>
            <VStack alignItems="end" gap={4}>
            <HStack>
                <AddPersonForm />
                <Button onClick={fetch}>Atualizar</Button>
            </HStack>
            <TransactionProvider>
                <TablePersons persons={persons}/>
            </TransactionProvider>

            </VStack>
        </>
    )
}