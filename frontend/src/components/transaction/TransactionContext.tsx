import { UseDialogReturn } from "@chakra-ui/react";
import { createContext } from "react";

type State = {
    personId: number|null;
    openDialog: (personId: number) => void;
    dialog: UseDialogReturn;
}
export const TransactionContext = createContext<State|null>(null)