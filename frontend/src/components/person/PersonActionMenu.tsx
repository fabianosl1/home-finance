import { Button } from "@chakra-ui/react";
import { MenuContent, MenuItem, MenuRoot, MenuTrigger } from "../ui/menu";
import { LuEllipsisVertical } from "react-icons/lu";


export default function ActionMenu() {
    
    
    return(
        <>
            <MenuRoot >
                <MenuTrigger>
                    <Button variant="ghost" p={0}>
                        <LuEllipsisVertical />
                    </Button>
                    </MenuTrigger>
                <MenuContent>
                    <MenuItem value="add">
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