import { TransactionResponse } from "@/types/Transaction";
import { formatCurrency } from "../../utils/Currency";
import { Table } from "@chakra-ui/react";

type Props = {
    transactions: TransactionResponse[]
}

const labels = {
    "EXPENSE": "despesa",
    "INCOME": "receita"
}

export default function TableTransactions({transactions}: Props) {

  return(
        <>
            <Table.Root variant="outline">
                <Table.Header>
                    <Table.Row>
                        <Table.ColumnHeader>Id</Table.ColumnHeader>
                        <Table.ColumnHeader>Descrição</Table.ColumnHeader>
                        <Table.ColumnHeader>Tipo</Table.ColumnHeader>
                        <Table.ColumnHeader textAlign="end">Preço</Table.ColumnHeader>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {transactions.map(({id, description, type, amount}) => (
                    <Table.Row key={id}>
                        <Table.Cell>{id}</Table.Cell>
                        <Table.Cell>{description}</Table.Cell>
                        <Table.Cell>{labels[type]}</Table.Cell>
                        <Table.Cell  textAlign="end">{formatCurrency(amount)}</Table.Cell>
                    </Table.Row>
                    ))}
                </Table.Body>
                <Table.Footer>
                <Table.Row fontWeight="black">
                        <Table.Cell></Table.Cell>
                        <Table.Cell></Table.Cell>
                        <Table.Cell>Count</Table.Cell>
                        <Table.Cell  textAlign="right">{transactions.length}</Table.Cell>
                    </Table.Row>
                </Table.Footer>
            </Table.Root>
        </>
    )
}
