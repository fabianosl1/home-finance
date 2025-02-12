import { Button } from "@chakra-ui/react"
import {
    DialogActionTrigger,
    DialogBody,
    DialogCloseTrigger,
    DialogContent,
    DialogFooter,
    DialogHeader,
    DialogRoot,
    DialogTitle,
    DialogTrigger,
  } from "@/components/ui/dialog"
import { ReactNode } from "react"

type Props = {
    handler: () => void;
    buttonText: string;
    title: string;
    children: ReactNode;
}
export default function CreateDialog({handler, buttonText, title, children}: Props) {

    return(
        <>
         <DialogRoot size="sm">
            <DialogTrigger asChild>
                <Button variant="outline" size="sm">
                    {buttonText}
                </Button>
            </DialogTrigger>
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>{title}</DialogTitle>
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
        </DialogRoot>
        </>
    )
}