import { PersonService } from "@/services/PersonService"
import { PersonResponse } from "@/types/Person"
import { useEffect, useState } from "react"
import TablePersons from "./TablePerson"
import AddPersonForm from "./AddPersonForm"
import { VStack } from "@chakra-ui/react"

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
            <AddPersonForm />
            <TablePersons persons={persons}/>
            </VStack>
        </>
    )
}