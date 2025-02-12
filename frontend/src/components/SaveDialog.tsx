import { Button, DialogHeader, DialogRootProvider, UseDialogReturn,  } from "@chakra-ui/react"
import {
    DialogActionTrigger,
    DialogBody,
    DialogCloseTrigger,
    DialogContent,
    DialogFooter,
  } from "@/components/ui/dialog"
import { ReactNode } from "react"

type Props = {
    handler: () => void;
    children: ReactNode;
    dialog: UseDialogReturn;
}
export default function SaveDialog({dialog, handler, children}: Props) {

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
                    <Button onClick={() => handler()}>Salvar</Button>
                </DialogFooter>
                <DialogCloseTrigger />
            </DialogContent>
        </DialogRootProvider>
        </>
    )
}