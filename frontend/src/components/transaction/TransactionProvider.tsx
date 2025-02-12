import { ReactNode, useState } from "react"
import { TransactionContext } from "./TransactionContext"
import { useDialog } from "@chakra-ui/react"
import AddTransactionForm from "./AddTransactionForm"

type Props = {
    children: ReactNode
}
export function TransactionProvider({children}: Props) {
    const dialog = useDialog()
    const [personId, setPersonId] = useState<number|null>(null)
    
    const openDialog = (personId: number) => {
        setPersonId(personId)
        dialog.setOpen(true)
    }

    return(
        <TransactionContext.Provider value={{dialog, personId, openDialog}}>
            <AddTransactionForm />
            {children}
        </TransactionContext.Provider>
    )
}