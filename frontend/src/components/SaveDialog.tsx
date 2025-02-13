import { Button, DialogHeader, DialogRootProvider, UseDialogReturn,  } from "@chakra-ui/react"
import {
    DialogActionTrigger,
    DialogBody,
    DialogCloseTrigger,
    DialogContent,
    DialogFooter,
  } from "@/components/ui/dialog"
import { ReactNode, useState } from "react"

type Props = {
    callback: () => Promise<void>;
    children: ReactNode;
    dialog: UseDialogReturn;
}
export default function SaveDialog({dialog, callback, children}: Props) {
    const [disabled, setDisabled] = useState(false)

    // tentando evitar duplicidade de registros
    const handle = async () => {
        setDisabled(true)                        
        await callback()                
        setDisabled(false)                    
    }
    
    return(
        <>
         <DialogRootProvider size="sm" value={dialog}>
            <DialogContent>
                <DialogHeader>
                </DialogHeader>
                <DialogBody>
                    {children}
                </DialogBody>
                <DialogFooter>
                    <DialogActionTrigger asChild>
                        <Button variant="outline">Cancelar</Button>
                    </DialogActionTrigger>
                    <Button onClick={handle} disabled={disabled}>Salvar</Button>
                </DialogFooter>
                <DialogCloseTrigger />
            </DialogContent>
        </DialogRootProvider>
        </>
    )
}