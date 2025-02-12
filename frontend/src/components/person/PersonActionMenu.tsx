import { Button } from "@chakra-ui/react";
import { MenuContent, MenuItem, MenuRoot, MenuTrigger } from "../ui/menu";
import { LuEllipsisVertical } from "react-icons/lu";

type Props = {
    handleAddTransaction: () => void
    handleToDelete: () => void
}

export default function ActionMenu({handleAddTransaction, handleToDelete}: Props) {
    
    return(
        <>
            <MenuRoot onSelect={(action) => {
                switch (action.value) {
                    case "add":
                        handleAddTransaction()
                        break;

                    case "delete":
                        handleToDelete()
                        break;
                }
            }}>
                 <MenuTrigger asChild>
                    <Button variant="ghost" p={0}>
                        <LuEllipsisVertical />
                    </Button>
                    </MenuTrigger>
                <MenuContent>
                    <MenuItem 
                        value="add" 
                    >
                        Adicionar transação
                    </MenuItem>
                    
                    <MenuItem 
                        value="delete"
                        color="fg.error"
                    >
                        Deletar
                    </MenuItem>                    
                </MenuContent>
            </MenuRoot>
        </>
    );
}