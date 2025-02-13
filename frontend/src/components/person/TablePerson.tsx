import { PersonResponse } from "@/types/Person";
import { formatCurrency } from "@/utils/Currency";
import { Table, useDialog } from "@chakra-ui/react";
import PersonActionMenu from "./PersonActionMenu";
import { useTransaction } from "../hooks/useTransaction";
import DeleteDialog from "./DeleteDialog";
import { PersonService } from "@/services/PersonService";
import { useState } from "react";

type Props = {
    persons: PersonResponse[]
}

export default function TablePersons({persons}: Props) {
    const {openDialog} = useTransaction()
    const deleteDialog = useDialog()
    const [personToDelete, setPersonToDelete] = useState<number|null>(null)

    const handlerDelete = async () => {
        if (personToDelete) {
            await PersonService.delete(personToDelete)
            deleteDialog.setOpen(false)
            setPersonToDelete(null)
        }
    }
    
    /*
     * considerei em calcular esses valores no servidor também mas acabei optando por fazer dessa maneira
    */
    let incomes = 0;
    let expenses = 0;

    for (const person of persons) {
        incomes += person.transactions.incomes;
        expenses += person.transactions.expenses;
    }

    const balance = incomes - expenses;
    
    return(
        <>  
            <DeleteDialog callback={handlerDelete} dialog={deleteDialog} />
            <Table.Root variant="outline">
                <Table.Header>
                    <Table.Row>
                        <Table.ColumnHeader>Id</Table.ColumnHeader>
                        <Table.ColumnHeader>Nome</Table.ColumnHeader>
                        <Table.ColumnHeader>Idade</Table.ColumnHeader>
                        <Table.ColumnHeader textAlign="end">Receita</Table.ColumnHeader>
                        <Table.ColumnHeader textAlign="end">Despesas</Table.ColumnHeader>
                        <Table.ColumnHeader textAlign="end">Balanço</Table.ColumnHeader>
                        <Table.ColumnHeader  w={2}></Table.ColumnHeader>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {persons.map(({id, name, age, transactions}) => (
                    <Table.Row key={id}>
                        <Table.Cell>{id}</Table.Cell>
                        <Table.Cell>{name}</Table.Cell>
                        <Table.Cell>{age}</Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(transactions.incomes)}</Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(transactions.expenses)}</Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(transactions.balance)}</Table.Cell>
                        <Table.Cell  textAlign="end"  maxWidth="fit-content">
                            <PersonActionMenu 
                                handleAddTransaction={() => openDialog(id)} 
                                handleToDelete={() => {
                                    setPersonToDelete(id)
                                    deleteDialog.setOpen(true)
                                }}
                            />
                        </Table.Cell>
                    </Table.Row>
                    ))}
                </Table.Body>

                <Table.Footer>
                    <Table.Row fontWeight="black">
                        <Table.Cell>Total</Table.Cell>
                        <Table.Cell></Table.Cell>
                        <Table.Cell></Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(incomes)}</Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(expenses)}</Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(balance)}</Table.Cell>
                        <Table.Cell  maxWidth="fit-content"></Table.Cell>
                    </Table.Row>
                </Table.Footer>
            </Table.Root>
        </>
    )
}