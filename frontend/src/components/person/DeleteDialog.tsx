import { Button, DialogRootProvider, UseDialogReturn } from "@chakra-ui/react";
import { 
    DialogActionTrigger, 
    DialogCloseTrigger, 
    DialogContent, 
    DialogFooter, 
    DialogHeader,
    DialogTitle, 
} from "../ui/dialog";

type Props = {
    dialog: UseDialogReturn;
    callback: () => void;
}
export default function DeleteDialog({dialog, callback}: Props) {
    return (
        <DialogRootProvider value={dialog} >
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Deseja deletar o usuario?</DialogTitle>
          </DialogHeader>
          <DialogFooter>
            <DialogActionTrigger asChild>
              <Button variant="outline">Cancel</Button>
            </DialogActionTrigger>
            <Button colorPalette="red" onClick={callback}>Confirmar</Button>
          </DialogFooter>
          <DialogCloseTrigger />
        </DialogContent>
    </DialogRootProvider>
    )
}